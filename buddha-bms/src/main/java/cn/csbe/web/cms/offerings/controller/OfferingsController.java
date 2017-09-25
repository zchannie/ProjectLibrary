package cn.csbe.web.cms.offerings.controller;

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
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.offerings.bean.Offerings;
import cn.csbe.web.cms.offerings.service.IOfferingsService;

/**
 * @author chZhou
 * 供品action
 */
@Controller
@RequestMapping("/offerings")
public class OfferingsController {

	@Autowired
	private IOfferingsService offeringsService;

	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toOfferings")
	private Object toOfferings() {

		return "/offerings/offerings";
	}

	/**
	 * 跳转到添加供品页
	 */
	@RequestMapping("toAddOfferings")
	private String addOfferings() {

		return "/offerings/addOfferings";
	}

	/**
	 * 跳转到编辑供品页
	 */
	@RequestMapping("toEditOfferings")
	private ModelAndView toEditOfferings(int offeringsId) throws Exception {

		ModelAndView view = new ModelAndView();

		Offerings offerings =  (Offerings) offeringsService.findById(offeringsId);
		view.addObject("offerings", offerings);
		view.setViewName("offerings/editOfferings");

		return view;
	}

	/**
	 * 获取供品信息
	 */
	@RequestMapping("getOfferingsByPage")
	@ResponseBody
	private Map<String, Object> getOfferingsByPage(HttpServletRequest request, HttpServletResponse response, Offerings offerings)
			throws Exception {
		if(offerings.getOfferingsName()!=null && !offerings.getOfferingsName().equals("")){
			String bud=URLDecoder.decode(offerings.getOfferingsName(),"utf-8");
			offerings.setOfferingsName(bud);
		}
		QueryResult queryResult = this.offeringsService.findByPage(offerings);
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
	@RequestMapping("addOfferings")
	@ResponseBody
	private Object addOfferings(Offerings off) throws Exception {
		boolean m = this.offeringsService.insert(off);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 更新供品
	 */
	@RequestMapping("editOfferings")
	@ResponseBody
	private Object editOfferings(Offerings b) throws Exception {
        b.setStatus(1);
        b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
		boolean m = this.offeringsService.update(b);

		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}

	/**
	 * 逻辑删除供品
	 */
	@RequestMapping("delOfferings")
	@ResponseBody
	private Object delOfferings(String offeringsId) throws Exception {
		boolean flag = false;
		Offerings b = new Offerings();
		if (offeringsId.contains(",")) {
			String[] arr = offeringsId.split(",");
			for (String string : arr) {
				b.setOfferingsId(Integer.parseInt(string));
				b.setStatus(0);
				b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
				flag = this.offeringsService.update(b);
			}
		} else {
			b.setOfferingsId(Integer.parseInt(offeringsId));
			b.setStatus(0);
			b.setUpdateTime(DateUtils.getDateTimeStr(new Date()));
			flag = this.offeringsService.update(b);
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

		UploadResult uploadResult = UploadUtils.upload(request, mFile, "/images/offerings/");

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}


}
