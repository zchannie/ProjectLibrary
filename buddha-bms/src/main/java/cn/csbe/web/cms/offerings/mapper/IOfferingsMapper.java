package cn.csbe.web.cms.offerings.mapper;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.offerings.bean.Offerings;

public interface IOfferingsMapper extends IBaseMapper {

	Integer insert(Offerings off);
}
