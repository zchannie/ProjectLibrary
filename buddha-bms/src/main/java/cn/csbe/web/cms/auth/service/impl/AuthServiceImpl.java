package cn.csbe.web.cms.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.auth.bean.UserRoleMenu;
import cn.csbe.web.cms.auth.mapper.IAuthMapper;
import cn.csbe.web.cms.auth.service.IAuthService;
import cn.csbe.web.cms.common.service.impl.BaseService;

@Service
public class AuthServiceImpl extends BaseService implements IAuthService{
	
	private IAuthMapper mapper;
	
	@Autowired
	public void setMapper(IAuthMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public UserPassword getUserPasswordByUserName(String userName) {
		return mapper.getUserPasswordByUserName(userName);
	}

	@Override
	public List<UserRoleMenu> getUserPermissionByUserId(Long userId) {
		return mapper.getUserPermissionByUserId(userId);
	}

	@Override
	public List<UserRoleMenu> getUserPermissionByUserName(String userName) {
		return mapper.getUserPermissionByUserName(userName);
	}
}
