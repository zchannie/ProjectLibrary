package cn.csbe.web.cms.user.mapper;

import java.util.List;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.user.bean.WithDrawals;

public interface IUserMapper extends IBaseMapper {

	//提现审核列表
	List findWithDrawals(WithDrawals withDrawals);
	
	Long findWithDrawalsCount(WithDrawals withDrawals);
	
	WithDrawals findWithDrawalsById(Integer id);
	
	int updateWithDrawals(WithDrawals withDrawals);
}
