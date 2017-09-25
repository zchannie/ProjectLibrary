package cn.csbe.web.cms.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.user.bean.WithDrawals;
import cn.csbe.web.cms.user.mapper.IUserMapper;
import cn.csbe.web.cms.user.service.IUserService;

@Service
public class UserServiceImpl extends BaseService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	public void setMapper(IUserMapper mapper) {
		super.setMapper(mapper);
	}

	@Override
	public QueryResult findWithDrawals(WithDrawals t) throws Exception {
		QueryResult queryResult = new QueryResult();
		Long totalSize = this.mapper.findWithDrawalsCount(t);
		List list = this.mapper.findWithDrawals(t);
		queryResult.setTotalSize(totalSize);
		queryResult.setList(list);
		return queryResult;
	}

	@Override
	public WithDrawals findWithDrawalsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.findWithDrawalsById(id);
	}

	@Override
	public boolean updateWithDrawals(WithDrawals withDrawals) throws Exception {
		// TODO Auto-generated method stub
			return this.mapper.updateWithDrawals(withDrawals) > 0;
	}
}
