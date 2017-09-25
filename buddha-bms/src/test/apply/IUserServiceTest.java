package apply;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.csbe.web.cms.apply.bean.UserApply;
import cn.csbe.web.cms.apply.service.IUserApplyService;
import cn.csbe.web.cms.user.mapper.IUserRoleRelationMapper;
import common.BaseTest;

public class IUserServiceTest extends BaseTest {

	@Autowired
	private IUserApplyService service;
	
	@Autowired
	private IUserRoleRelationMapper mapper;
	
	@Test
	public void show() {
		UserApply apply = new UserApply();
		apply.setApplyType(0);
		apply.setObjId(1);
		System.out.println(service.findCount(apply));
	}
	
	@Test
	public void findRole(){
		UserApply apply = new UserApply();
		apply.setUserId(10000);
		System.out.println(mapper.findRole(apply));
	}
}
