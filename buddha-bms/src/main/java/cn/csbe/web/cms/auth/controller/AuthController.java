package cn.csbe.web.cms.auth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.auth.bean.UserRoleMenu;
import cn.csbe.web.cms.auth.service.IAuthService;

@Controller
@RequestMapping("/")
public class AuthController {

	@Autowired
	private IAuthService authService;
	/**	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, UserPassword userPassword) {
		ModelAndView view = new ModelAndView();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = "";
			String password = "";
			if(subject.isAuthenticated()){
				UserPassword sessionUser = (UserPassword) request.getSession().getAttribute("user");
				if(sessionUser!=null){
					username = sessionUser.getPhone();
					password = sessionUser.getPwd();
				}else{
					username = userPassword.getUsername();
					password = DigestUtils.md5DigestAsHex((userPassword.getPwd()+"/csbe!@#%$^ASD").getBytes());
				}
				
			} else {
				username = userPassword.getUsername();
				password = DigestUtils.md5DigestAsHex((userPassword.getPwd()+"/csbe!@#%$^ASD").getBytes());
			}
			
			if(username != null && !username.equals("")){
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				subject.login(token);
				
				UserPassword user = authService.getUserPasswordByUserName(username);
				List<UserRoleMenu> userRoleMenuList = new ArrayList<UserRoleMenu>();
				userRoleMenuList = authService.getUserPermissionByUserId(user.getUserId());
				
				if(userRoleMenuList != null && userRoleMenuList.size()>0 && checkPermissions(userRoleMenuList)){
					request.getSession().setAttribute("user", user);
					view.addObject("userRoleMenu",userRoleMenuList);
					view.setViewName("index");
				} else {
					view.addObject("error","权限不足,请联系管理员！");
					view.setViewName("../../login");
				}
			} else {
				view.setViewName("../../login");
			}
			
		} catch (AuthenticationException e) {
			view.addObject("error","用户名或密码错误！");
			view.setViewName("../../login");
		}
		
		return view;
	}
	
	public boolean checkPermissions(List<UserRoleMenu> userRoleMenuList){
		boolean checkPermissions = true;
		Subject subject = SecurityUtils.getSubject();
		
		for(UserRoleMenu menu : userRoleMenuList){
			boolean b = subject.isPermitted(menu.getUrl());
			if(!b){
				checkPermissions = false;
				break;
			}
		}
		return checkPermissions;
	}
	
	@RequestMapping(value = "quit")
	public ModelAndView UserQuit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		request.getSession().removeAttribute("user");
		view.setViewName("../../login");
		return view;
	}
	
	
}
