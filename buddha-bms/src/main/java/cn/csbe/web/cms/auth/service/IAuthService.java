package cn.csbe.web.cms.auth.service;

import java.util.List;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.auth.bean.UserRoleMenu;
import cn.csbe.web.cms.common.service.IBaseService;

public interface IAuthService extends IBaseService {

	public UserPassword getUserPasswordByUserName(String userName);
	
	public List<UserRoleMenu> getUserPermissionByUserId(Long userId);
	
	public List<UserRoleMenu> getUserPermissionByUserName(String userName);
}
