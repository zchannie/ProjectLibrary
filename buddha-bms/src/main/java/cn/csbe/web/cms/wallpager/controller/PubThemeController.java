package cn.csbe.web.cms.wallpager.controller;

import java.net.URLDecoder;
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
import cn.csbe.web.cms.wallpager.bean.PubTheme;
import cn.csbe.web.cms.wallpager.service.IPubThemeService;

/**
 * @author chZhou
 * 创建时间：2017-6-19下午1:25:00
 * 描述：壁纸主题
 */
@Controller
@RequestMapping("/theme")
public class PubThemeController {

	@Autowired
	private IPubThemeService themeService;

	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toTheme")
	private Object toTheme() {

		return "/theme/theme";
	}

	/**
	 * 跳转到添加页
	 */
	@RequestMapping("toAddTheme")
	private String addTheme() {
		
		return "/theme/addTheme";
	}

	/**
	 * 跳转到编辑页
	 */
	@RequestMapping("toEditTheme")
	private ModelAndView toEditTheme(int themeId) throws Exception {

		ModelAndView view = new ModelAndView();

		PubTheme obj =  (PubTheme) themeService.findById(themeId);
		view.addObject("theme", obj);
		view.setViewName("theme/editTheme");

		return view;
	}

	/**
	 * 获取信息
	 */
	@RequestMapping("getInfoByPage")
	@ResponseBody
	private Map<String, Object> getInfoByPage(HttpServletRequest request, HttpServletResponse response, PubTheme obj)
			throws Exception {
		if(obj!=null){
			if(obj.getThemeName()!=null&& !obj.getThemeName().equals("")){
				String bud=URLDecoder.decode(obj.getThemeName(),"utf-8");
				obj.setThemeName(bud);
			}
		}
		QueryResult queryResult = this.themeService.findByPage(obj);
		List rows = queryResult.getList();
		long total = queryResult.getTotalSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", total);
		return map;
		

	}

	/**
	 * 添加信息
	 */
	@RequestMapping("addTheme")
	@ResponseBody
	private Object addTheme(PubTheme obj) throws Exception {
		if(!StringUtils.isEmpty(obj.getHtmlUrl())){
				String content=obj.getHtmlUrl();
				if(content.contains(CSBE.addlocalStr)){
					content=content.replaceAll(CSBE.addlocalStr,CSBE.htmlPath);
				}
				
				String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
				 int rand=CSBE.getRandomNum();
				//将html内容生成html页面，将链接存储到数据库中
				ToHtml.service("model", "/model/html/",rand,obj.getThemeName(),time,obj.getPreviewTotal(),content);
				obj.setHtmlUrl(CSBE.htmlPath+"model/html/"+rand+".html");
		}
		
		obj.setCreateTime(DateUtils.getDateTimeStr(new Date()));
		boolean m = this.themeService.insert(obj);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新信息
	 */
	@RequestMapping("editTheme")
	@ResponseBody
	private Object editTheme(PubTheme b) throws Exception {
		int rand;
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
		if(!StringUtils.isEmpty(b.getHtmlUrl())){
			String content=b.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.htmlPath);
			}
			//查询原来htmlUrl
			if(StringUtils.isEmpty(b.getParam())){
				rand=CSBE.getRandomNum();
			}else{
				 String param=b.getParam();
				 rand=Integer.parseInt(param.substring(49, 55));
			}
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/html/",rand,b.getThemeName(),time,b.getPreviewTotal(),content);
			b.setHtmlUrl(CSBE.htmlPath+"model/html/"+rand+".html");
	    }else{
	    	b.setHtmlUrl(null);
	    }
		b.setCreateTime(time);
        b.setStatus(1);
		boolean m = this.themeService.update(b);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除信息
	 */
	@RequestMapping("delTheme")
	@ResponseBody
	private Object delTheme(String themeId) throws Exception {
		boolean flag = false;
		PubTheme b = new PubTheme();
		if (themeId.contains(",")) {
			String[] arr = themeId.split(",");
			for (String str : arr) {
				b.setThemeId(Integer.parseInt(str));
				b.setStatus(0);
				flag = this.themeService.update(b);
			}
		} else {
			b.setThemeId(Integer.parseInt(themeId));
			b.setStatus(0);
			flag = this.themeService.update(b);
		}

		return flag ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 图片上传
	 */
	@RequestMapping(value = "upload/pictrue", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, UserPassword userPassword) throws Exception {

		UploadResult uploadResult = UploadUtils.upload(request, mFile,"images/theme/");

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}

}
