package cn.csbe.web.cms.user.service;

import java.util.List;

import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.user.bean.WithDrawals;

public interface IUserService extends IBaseService {

	//提现审核列表
	public QueryResult findWithDrawals(WithDrawals withDrawals)throws Exception;
	
	public WithDrawals findWithDrawalsById(Integer id)throws Exception;
	
	public boolean updateWithDrawals(WithDrawals withDrawals)throws Exception;
}
