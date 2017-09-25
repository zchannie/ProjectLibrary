package cn.csbe.web.cms.offerings.service;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.offerings.bean.Offerings;

public interface IOfferingsService extends IBaseService {
	boolean insert(Offerings off);
}
