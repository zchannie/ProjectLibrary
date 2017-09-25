package cn.csbe.web.cms.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.user.bean.PubUser;
import cn.csbe.web.cms.user.bean.UserRoleRelation;
import cn.csbe.web.cms.user.bean.WithDrawals;
import cn.csbe.web.cms.user.service.IUserRoleRelationService;
import cn.csbe.web.cms.user.service.IUserService;

/**
 * 用户模块
 * 
 * @author yangrui
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleRelationService userRoleRelationService;

	/**
	 * 根据roleId,跳转到相对应角色的列表页
	 * 
	 * @param roleId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toUser", method = RequestMethod.GET)
	public ModelAndView project(int roleId, HttpServletRequest request) throws Exception {
		ModelAndView view = new ModelAndView();
		view.addObject("roleId", roleId);
		view.setViewName("user/user");
		return view;
	}

	/**
	 * 显示相对应角色列表
	 * 
	 * @param pubUser
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getUserByPage", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserByPage(PubUser pubUser, HttpServletRequest request) throws Exception {
		if (pubUser.getStatus() != null) {
			if (pubUser.getStatus() == -1) {
				pubUser.setStatus(null);
			}
		}
		QueryResult queryResult = userService.findByPage(pubUser);
		List rows = queryResult.getList();
		long total = queryResult.getTotalSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", total);
		return map;
	}

	/**
	 * 跳转到 审核 页
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEditUser")
	private ModelAndView toEditUser(int userId, int roleId) throws Exception {
		ModelAndView view = new ModelAndView();
		PubUser pubUser = (PubUser) userService.findById(userId);
		view.addObject("roleId", roleId);
		view.addObject("pubUser", pubUser);
		view.setViewName("user/editUser");
		return view;
	}

	/**
	 * 更新
	 * 
	 * @param relation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editUserRoleRelation")
	@ResponseBody
	public Object editUserRoleRelation(UserRoleRelation relation) throws Exception {
		boolean m = userRoleRelationService.update(relation);
		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	}
	
	/**
	 * 跳转到提现审核页面
	 */
	@RequestMapping(value="/toDrawals")
	public ModelAndView toDrawals(){
		ModelAndView view = new ModelAndView();
		view.setViewName("user/withDrawals");
		return view;
	}
	
	/**
	 * 
	 * 提现审核
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/getDrawals", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> drawals(WithDrawals withDrawals) throws Exception{
		if (withDrawals.getStatus() != null) {
			if (withDrawals.getStatus() == -1) {
				withDrawals.setStatus(null);
			}
		}
		QueryResult queryResult = userService.findWithDrawals(withDrawals);
		List rows = queryResult.getList();
		long total = queryResult.getTotalSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 跳转到提现审核详情页
	 * @throws Exception 
	 */
	@RequestMapping(value="/toEditWithDrawals", method = RequestMethod.GET)
	public ModelAndView toEditWithDrawals(WithDrawals withDrawals) throws Exception{
		ModelAndView view = new  ModelAndView();
		PubUser pubUser = (PubUser)userService.findById(withDrawals.getUserId());
		if(pubUser != null){
			view.addObject("userName",pubUser.getUsername());
		}
		WithDrawals withDra = (WithDrawals)userService.findWithDrawalsById(withDrawals.getWid());
		view.addObject("withDra", withDra);
		view.setViewName("user/editWithDrawals");
		return view;
	}
	
	/**
	 * 修改审核状态
	 */
	@RequestMapping(value="editWithDraStatus")
	@ResponseBody
	public Object editWithDraStatus(WithDrawals withDrawals) throws Exception {
		boolean m = userService.updateWithDrawals(withDrawals);
		return m ? new Message(true, "操作成功") : new Message(false, "操作失败");
	} 
}
