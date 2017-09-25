package cn.csbe.web.cms.auth.mapper;

import java.util.List;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.auth.bean.UserRoleMenu;
import cn.csbe.web.cms.common.mapper.IBaseMapper;

public interface IAuthMapper extends IBaseMapper {

	UserPassword getUserPasswordByUserName(String userName);
	
	List<UserRoleMenu> getUserPermissionByUserId(Long userId);
	
	List<UserRoleMenu> getUserPermissionByUserName(String userName);
}
