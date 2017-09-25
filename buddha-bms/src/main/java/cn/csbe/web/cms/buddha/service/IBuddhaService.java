package cn.csbe.web.cms.buddha.service;

import cn.csbe.web.cms.buddha.bean.Buddha;
import cn.csbe.web.cms.common.service.IBaseService;

public interface IBuddhaService extends IBaseService {
	boolean insert(Buddha buddha);

	Integer findMaxId();
}
