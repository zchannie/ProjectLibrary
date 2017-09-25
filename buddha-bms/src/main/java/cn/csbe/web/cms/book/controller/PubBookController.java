package cn.csbe.web.cms.book.controller;

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
import cn.csbe.web.cms.book.bean.PubBook;
import cn.csbe.web.cms.book.service.IPubBookService;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.ToHtml;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;

/**
 * Title：PubBookController
 * Description：经文/书 控制器
 * @author chZhou
 * @date    2017-7-3
 */
@Controller
@RequestMapping("/book")
public class PubBookController {

	@Autowired
	private IPubBookService pubBookService;

	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toBook")
	private Object toBook() {

		return "/book/book";
	}

	/**
	 * 跳转到添加新闻页
	 */
	@RequestMapping("toAddBook")
	private String addBook() {

		return "/book/addBook";
	}

	/**
	 * 跳转到编辑新闻页
	 */
	@RequestMapping("toEditBook")
	private ModelAndView toEditBook(int bookId) throws Exception {

		ModelAndView view = new ModelAndView();

		PubBook pubBook = (PubBook) pubBookService.findById(bookId);
		view.addObject("book", pubBook);
		view.setViewName("book/editBook");

		return view;
	}

	/**
	 * 获取新闻
	 */
	@RequestMapping("getBookByPage")
	@ResponseBody
	private Map<String, Object> getBookByPage(HttpServletRequest request, HttpServletResponse response, PubBook Book)
			throws Exception {

		QueryResult queryResult = this.pubBookService.findByPage(Book);
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
	@RequestMapping("addBook")
	@ResponseBody
	private Object addBook(PubBook book) throws Exception {
		String time=DateUtils.getDateTimeStr(new Date());
		if(!StringUtils.isEmpty(book.getHtmlUrl())){
			String content=book.getHtmlUrl();
			if(content.contains("http://localhost:8080/buddha-bms//ueditor//../../image")){
				content=content.replaceAll("http://localhost:8080/buddha-bms//ueditor//../../image",CSBE.htmlPath);
			}
			
			int rand=CSBE.getRandomNum();
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/Book/",rand,book.getBookTitle(),time,0,content);
			book.setHtmlUrl(CSBE.htmlPath+"model/book/"+rand+".html");
	   }
		book.setPublishDate(time);
		
		boolean m = this.pubBookService.insert(book);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新新闻
	 */
	@RequestMapping("editBook")
	@ResponseBody
	private Object editBook(PubBook Book) throws Exception {
		int rand;
		String time=DateUtils.getDateTimeStr(new Date());
		if(!StringUtils.isEmpty(Book.getHtmlUrl())){
			String content=Book.getHtmlUrl();
			if(content.contains("http://localhost:8080/buddha-bms//ueditor//../../image")){
				content=content.replaceAll("http://localhost:8080/buddha-bms//ueditor//../../image",CSBE.htmlPath);
			}
			
			//查询原来htmlUrl
			if(StringUtils.isEmpty(Book.getParam())){
				rand=CSBE.getRandomNum();
			}else{
				 String param=Book.getParam();
				 rand=Integer.parseInt(param.substring(49, 55));
			}
			
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/Book/",rand,Book.getBookTitle(),time,0,content);
			Book.setHtmlUrl(CSBE.htmlPath+"model/book/"+rand+".html");
	   }
		if(Book.getStatus()==null){
			Book.setStatus(1);
		}
		Book.setPublishDate(time);
		boolean m = this.pubBookService.update(Book);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除新闻
	 */
	@RequestMapping("delBook")
	@ResponseBody
	private Object delBook(String bookId) throws Exception {
		boolean flag = false;
		PubBook Book = new PubBook();
		if (bookId.contains(",")) {
			String[] arr = bookId.split(",");
			for (String string : arr) {
				Book.setBookId(Integer.valueOf(string));
				Book.setStatus(0);
				flag = this.pubBookService.update(Book);
			}
		} else {
			Book.setBookId(Integer.valueOf(bookId));
			Book.setStatus(0);
			flag = this.pubBookService.update(Book);
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

		UploadResult uploadResult = UploadUtils.upload(request, mFile, "/images/Book/");

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}



}
