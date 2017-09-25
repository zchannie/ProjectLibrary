package cn.csbe.web.cms.pub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.pub.bean.PubCategory;
import cn.csbe.web.cms.pub.mapper.IPubMapper;
import cn.csbe.web.cms.pub.service.IPubService;

@Service
public class PubServiceImpl extends BaseService implements IPubService {

	@Autowired
	IPubMapper mapper;

	@Autowired
	public void setMapper(IPubMapper mapper) {
		super.setMapper(mapper);
	}

	@Override
	public List getCitys() {
		// TODO Auto-generated method stub
		return this.mapper.getCitys();
	}

	@Override
	public List getCityByPid(Integer pid) {
		// TODO Auto-generated method stub
		return this.mapper.getCityByPid(pid);
	}

	@Override
	public List getCategorys() {
		// TODO Auto-generated method stub
		return this.mapper.getCategorys();
	}

	@Override
	public List getCategoryByPid(Integer pid) {
		// TODO Auto-generated method stub
		return this.mapper.getCategoryByPid(pid);
	}

	/*
	 * @Override public Object getPolicys(Policy policy) { // TODO
	 * Auto-generated method stub return this.mapper.getPolicys(policy); }
	 */
	@Override
	public Object getPolicyById(Integer policyId) {
		// TODO Auto-generated method stub
		return this.mapper.getPolicyById(policyId);
	}

	@Override
	public List getEnterprise() {
		// TODO Auto-generated method stub
		return this.mapper.getEnterprise();
	}

	@Override
	public Object getCityById(Integer id) {
		// TODO Auto-generated method stub
		return this.mapper.getCityById(id);
	}

	@Override
	public boolean insertCategory(Object obj) {
		// TODO Auto-generated method stub
		Integer res = this.mapper.insertCategory(obj);
		return res > 0;
	}

	@Override
	public boolean updateCategory(PubCategory category) {
		// TODO Auto-generated method stub
		Integer res = this.mapper.updateCategory(category);
		return res > 0;
	}

	@Override
	public Object getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return this.mapper.getCategoryById(categoryId);
	}

}
