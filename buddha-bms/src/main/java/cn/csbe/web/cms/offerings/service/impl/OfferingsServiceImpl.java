package cn.csbe.web.cms.offerings.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.offerings.bean.Offerings;
import cn.csbe.web.cms.offerings.mapper.IOfferingsMapper;
import cn.csbe.web.cms.offerings.service.IOfferingsService;

@Service
public class OfferingsServiceImpl extends BaseService implements IOfferingsService {

	@Autowired
	IOfferingsMapper mapper;

	@Autowired
	public void setMapper(IOfferingsMapper mapper) {
		super.setMapper(mapper);
	}

	@Override
	public boolean insert(Offerings off) {
		off.setCreateTime(DateUtils.getDateTimeStr(new Date()));
		return this.mapper.insert(off)>0;
	}

}
