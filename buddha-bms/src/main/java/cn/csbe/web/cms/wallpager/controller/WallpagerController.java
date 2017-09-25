package cn.csbe.web.cms.wallpager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.wallpager.bean.PubTheme;
import cn.csbe.web.cms.wallpager.bean.PubWallpaper;
import cn.csbe.web.cms.wallpager.service.IPubThemeService;
import cn.csbe.web.cms.wallpager.service.IWallpagerService;

/**
 * @author chZhou
 * 创建时间：2017-6-19下午1:25:00
 * 描述：壁纸主题
 */
@Controller
@RequestMapping("/wall")
public class WallpagerController {

	@Autowired
	private IWallpagerService service;

	@Autowired
	private IPubThemeService themeService;
	
	
	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toWall")
	private Object toWall() {

		return "/wallpager/wall";
	}

	/**
	 * 跳转到添加页
	 */
	@RequestMapping("toAddWall")
	private String addTheme(HttpServletRequest request) {
        //查询主题集合
		try {
			List<PubTheme> themelist=themeService.findAll();
			request.setAttribute("themelist", themelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/wallpager/addWall";
	}

	/**
	 * 跳转到编辑页
	 */
	@RequestMapping("toEditWall")
	private ModelAndView toEditTheme(int id) throws Exception {

		ModelAndView view = new ModelAndView();
		List<PubTheme> themelist=themeService.findAll();
		PubWallpaper obj =  (PubWallpaper) service.findById(id);
		view.addObject("wall", obj);
		view.addObject("themelist", themelist);
		view.setViewName("wallpager/editWall");

		return view;
	}

	/**
	 * 获取信息
	 */
	@RequestMapping("getInfoByPage")
	@ResponseBody
	private Map<String, Object> getInfoByPage(HttpServletRequest request, HttpServletResponse response, PubWallpaper obj)
			throws Exception {
		QueryResult queryResult = this.service.findByPage(obj);
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
	@RequestMapping("addWall")
	@ResponseBody
	private Object addTheme(PubWallpaper obj) throws Exception {
		
		boolean m = this.service.insert(obj);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新信息
	 */
	@RequestMapping("editWall")
	@ResponseBody
	private Object editTheme(PubWallpaper b) throws Exception {
        b.setStatus(1);
		boolean m = this.service.update(b);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除信息
	 */
	@RequestMapping("delWall")
	@ResponseBody
	private Object delTheme(String id) throws Exception {
		boolean flag = false;
		PubWallpaper b = new PubWallpaper();
		if (id.contains(",")) {
			String[] arr = id.split(",");
			for (String str : arr) {
				b.setId(Integer.parseInt(str));
				b.setStatus(0);
				flag = this.service.update(b);
			}
		} else {
			b.setId(Integer.parseInt(id));
			b.setStatus(0);
			flag = this.service.update(b);
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

		UploadResult uploadResult = UploadUtils.upload(request, mFile,"images/wallpager/");
        
		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}


}
