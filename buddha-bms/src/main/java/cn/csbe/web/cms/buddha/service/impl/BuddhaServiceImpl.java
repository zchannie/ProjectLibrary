package cn.csbe.web.cms.buddha.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.buddha.bean.Buddha;
import cn.csbe.web.cms.buddha.mapper.IBuddhaMapper;
import cn.csbe.web.cms.buddha.service.IBuddhaService;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.service.impl.BaseService;

@Service
public class BuddhaServiceImpl extends BaseService implements IBuddhaService {

	private IBuddhaMapper mapper;

	@Autowired
	public void setMapper(IBuddhaMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public boolean insert(Buddha a) {
		a.setCreateTime(DateUtils.getDateTimeStr(new Date()));
		return this.mapper.insert(a) > 0;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.mapper.findMaxId();
	}
	
	
}
