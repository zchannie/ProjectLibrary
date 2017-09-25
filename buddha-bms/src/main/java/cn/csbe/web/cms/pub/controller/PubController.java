package cn.csbe.web.cms.pub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.pub.bean.PubCategory;
import cn.csbe.web.cms.pub.service.IPubService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/")
public class PubController {

	@Autowired
	private IPubService pubService;

	/**
	 * 文件上传
	 */
	@RequestMapping(value = "upload/file", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, String fileName) throws Exception {

		UploadResult upload = UploadUtils.upload(request, mFile, "/file/userphoto/");

		return CSBE.encryption(new Result(1000, upload));

	}

	/**
	 * 获取城市
	 */
	@RequestMapping("/pub/citys")
	@ResponseBody
	private Object getCitys(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Object object = this.pubService.getCitys();

		return CSBE.encryption(new Result(1000, object));

	}

	/**
	 * 根据城市id获取，下级城市
	 */
	@RequestMapping("/pub/city/{pid}")
	@ResponseBody
	private Object getCityById(@PathVariable Integer pid, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Object object = this.pubService.getCityByPid(pid);

		return CSBE.encryption(object);

	}

	/**
	 * 获取机构
	 */
	@RequestMapping("/pub/enterprise")
	@ResponseBody
	private Object getEnterprise(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Object object = this.pubService.getEnterprise();

		return CSBE.encryption(object);

	}

	/**
	 * 根据父级id，获取下级分类
	 */
	@RequestMapping("/pub/category/{pid}")
	@ResponseBody
	private Object getCategoryByPid(@PathVariable Integer pid, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Object object = this.pubService.getCategoryByPid(pid);

		return CSBE.encryption(object);

	}

	/**
	 * 根据父级id，获取下级分类
	 */
	@RequestMapping("/pub/updateCategory")
	@ResponseBody
	private Object updateCategory(PubCategory category) throws Exception {

		boolean res = this.pubService.updateCategory(category);

		return res ? new Message(true, "操作成功") : new Message(false, "操作失败");

	}

	/**
	 * 根据父级id，获取下级分类
	 */
	@RequestMapping("/pub/insertCategory")
	@ResponseBody
	private Object insertCategory(PubCategory category) throws Exception {

		boolean res = this.pubService.insertCategory(category);

		return res ? new Message(true, "操作成功") : new Message(false, "操作失败");

	}

	/**
	 * 根据父级id，获取下级分类
	 */
	@RequestMapping("/pub/delCategory")
	@ResponseBody
	private Object removeCategory(String categoryId) throws Exception {

		boolean flag = false;
		PubCategory category = new PubCategory();
		if (categoryId.contains(",")) {
			String[] arr = categoryId.split(",");
			for (String string : arr) {
				category.setCategoryId(Integer.valueOf(string));
				category.setStatus(0 + "");
				flag = this.pubService.updateCategory(category);
			}
		} else {
			category.setCategoryId(Integer.valueOf(categoryId));
			category.setStatus(0 + "");
			flag = this.pubService.updateCategory(category);
		}

		return flag ? new Message(true, "操作成功") : new Message(false, "操作失败");

	}

//	/**
//	 * 跳转到课程分类页
//	 * 
//	 * @param project
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/pub/toCategory", method = RequestMethod.GET)
//	public String toCategory(TrainCourse trainCourse) throws Exception {
//
//		return "pub/category";
//	}

	/**
	 * 获取分类
	 */
	@RequestMapping("/pub/getCategorys")
	@ResponseBody
	public Map<String, Object> getCategorys() throws Exception {
		// QueryResult queryResult =
		List rows = this.pubService.getCategorys();
		long total = rows.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows);
		return map;
	}

}
