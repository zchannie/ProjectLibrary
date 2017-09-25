package cn.csbe.web.cms.news.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.ToHtml;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.news.bean.PubNews;
import cn.csbe.web.cms.news.service.IPubNewsService;

/**
 * Title：PubNewsController
 * Description：新闻
 * @author chZhou
 * @date    2017-7-3
 */
@Controller
@RequestMapping("/news")
public class PubNewsController {

	@Autowired
	private IPubNewsService pubNewsService;

	/**
	 * 跳转到新闻管理页
	 */
	@RequestMapping("toNews")
	private Object toNews() {

		return "/news/news";
	}

	/**
	 * 跳转到添加新闻页
	 */
	@RequestMapping("toAddNews")
	private String addNews() {

		return "/news/addNews";
	}

	/**
	 * 跳转到编辑新闻页
	 */
	@RequestMapping("toEditNews")
	private ModelAndView toEditNews(int newsid) throws Exception {

		ModelAndView view = new ModelAndView();

		PubNews pubNews = (PubNews) pubNewsService.findById(newsid);
		view.addObject("pubNews", pubNews);
		view.setViewName("news/editNews");

		return view;
	}

	/**
	 * 获取新闻
	 */
	@RequestMapping("getNewsByPage")
	@ResponseBody
	private Map<String, Object> getNewsByPage(HttpServletRequest request, HttpServletResponse response, PubNews news)
			throws Exception {

		QueryResult queryResult = this.pubNewsService.findByPage(news);
		List rows = queryResult.getList();
		long total = queryResult.getTotalSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", total);
		return map;

	}

	/**
	 * 添加新闻
	 */
	@RequestMapping("addNews")
	@ResponseBody
	private Object addNews(PubNews news) throws Exception {
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
		if(!StringUtils.isEmpty(news.getHtmlUrl())){
			String content=news.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.htmlPath);
			}
			
			int rand=CSBE.getRandomNum();
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/news/",rand,news.getNewsTitle(),time,news.getPreviewTotal(),content);
			news.setHtmlUrl(CSBE.htmlPath+"model/news/"+rand+".html");
	   }
		news.setPublishDate(time);
		
		boolean m = this.pubNewsService.insert(news);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新新闻
	 */
	@RequestMapping("editNews")
	@ResponseBody
	private Object editNews(PubNews news) throws Exception {
		int rand;
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
		if(!StringUtils.isEmpty(news.getHtmlUrl())){
			String content=news.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.htmlPath);
			}
			
			//查询原来htmlUrl
			if(StringUtils.isEmpty(news.getParam())){
				rand=CSBE.getRandomNum();
			}else{
				 String param=news.getParam();
				 rand=Integer.parseInt(param.substring(49, 55));
			}
			
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/news/",rand,news.getNewsTitle(),time,news.getPreviewTotal(),content);
			news.setHtmlUrl(CSBE.htmlPath+"model/news/"+rand+".html");
	   }
		if(news.getStatus()==null){
			news.setStatus(1);
		}
		news.setPublishDate(time);
		boolean m = this.pubNewsService.update(news);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除新闻
	 */
	@RequestMapping("delNews")
	@ResponseBody
	private Object delNews(String newsid) throws Exception {
		boolean flag = false;
		PubNews news = new PubNews();
		if (newsid.contains(",")) {
			String[] arr = newsid.split(",");
			for (String string : arr) {
				news.setNewsid(Integer.valueOf(string));
				news.setStatus(0);
				flag = this.pubNewsService.update(news);
			}
		} else {
			news.setNewsid(Integer.valueOf(newsid));
			news.setStatus(0);
			flag = this.pubNewsService.update(news);
		}

		return flag ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 新闻图片上传
	 */
	@RequestMapping(value = "upload/pictrue", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, UserPassword userPassword) throws Exception {

		UploadResult uploadResult = UploadUtils.upload(request, mFile, "/images/news/");

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}



}
