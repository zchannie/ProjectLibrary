package cn.csbe.web.cms.buddha.mapper;

import cn.csbe.web.cms.buddha.bean.Buddha;
import cn.csbe.web.cms.common.mapper.IBaseMapper;

public interface IBuddhaMapper extends IBaseMapper {
	Integer insert(Buddha buddha);

	Integer findMaxId();

}
