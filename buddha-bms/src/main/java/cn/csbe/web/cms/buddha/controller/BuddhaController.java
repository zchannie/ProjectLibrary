package cn.csbe.web.cms.buddha.controller;

import java.net.URLDecoder;
import java.util.Date;
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
import cn.csbe.web.cms.buddha.bean.Buddha;
import cn.csbe.web.cms.buddha.service.IBuddhaService;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.ConfigUtil;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;

/**
 * @author chZhou
 * 佛教
 */
@Controller
@RequestMapping("/buddha")
public class BuddhaController {

	@Autowired
	private IBuddhaService buddhaService;

	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toBuddha")
	private Object toBuddha() {

		return "/buddha/buddha";
	}

	/**
	 * 跳转到添加佛教页
	 */
	@RequestMapping("toAddBuddha")
	private String addBuddha() {

		return "/buddha/addBuddha";
	}

	/**
	 * 跳转到编辑佛教页
	 */
	@RequestMapping("toEditBuddha")
	private ModelAndView toEditBuddha(int buddhaId) throws Exception {

		ModelAndView view = new ModelAndView();

		Buddha buddha =  (Buddha) buddhaService.findById(buddhaId);
		view.addObject("buddha", buddha);
		view.setViewName("buddha/editBuddha");

		return view;
	}

	/**
	 * 获取佛教信息
	 */
	@RequestMapping("getBuddhaByPage")
	@ResponseBody
	private Map<String, Object> getBuddhaByPage(HttpServletRequest request, HttpServletResponse response, Buddha buddha)
			throws Exception {
		if(buddha.getBuddhaName()!=null && !buddha.getBuddhaName().equals("")){
			String bud=URLDecoder.decode(buddha.getBuddhaName(),"utf-8");
			buddha.setBuddhaName(bud);
		}
		QueryResult queryResult = this.buddhaService.findByPage(buddha);
		List rows = queryResult.getList();
		long total = queryResult.getTotalSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", total);
		return map;

	}

	/**
	 * 添加佛像
	 */
	@RequestMapping("addBuddha")
	@ResponseBody
	private Object addBuddha(Buddha buddha) throws Exception {
		boolean m = this.buddhaService.insert(buddha);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新佛教
	 */
	@RequestMapping("editBuddha")
	@ResponseBody
	private Object editBuddha(Buddha b) throws Exception {
        b.setStatus(1);
        b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
		boolean m = this.buddhaService.update(b);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除佛教
	 */
	@RequestMapping("delBuddha")
	@ResponseBody
	private Object delBuddha(String buddhaId) throws Exception {
		boolean flag = false;
		Buddha b = new Buddha();
		if (buddhaId.contains(",")) {
			String[] arr = buddhaId.split(",");
			for (String string : arr) {
				b.setBuddhaId(string);
				b.setStatus(0);
				b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
				flag = this.buddhaService.update(b);
			}
		} else {
			b.setBuddhaId(buddhaId);
			b.setStatus(0);
			b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
			flag = this.buddhaService.update(b);
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

		UploadResult uploadResult = UploadUtils.upload(request, mFile,"images/buddha/");

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}


}
