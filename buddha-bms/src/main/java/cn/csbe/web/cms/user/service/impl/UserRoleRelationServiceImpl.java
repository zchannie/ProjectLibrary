package cn.csbe.web.cms.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.user.mapper.IUserRoleRelationMapper;
import cn.csbe.web.cms.user.service.IUserRoleRelationService;

@Service
public class UserRoleRelationServiceImpl extends BaseService implements IUserRoleRelationService {

	@Autowired
	private IUserRoleRelationMapper mapper;

	@Autowired
	public void setMapper(IUserRoleRelationMapper mapper) {
		super.setMapper(mapper);
	}

}
