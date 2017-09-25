package cn.csbe.web.cms.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.news.bean.PubNews;
import cn.csbe.web.cms.news.mapper.IPubNewsMapper;
import cn.csbe.web.cms.news.service.IPubNewsService;

@Service
public class PubNewsServiceImpl extends BaseService implements IPubNewsService {

	private IPubNewsMapper mapper;

	@Autowired
	public void setMapper(IPubNewsMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public boolean insert(PubNews pubNews) {
		// TODO Auto-generated method stub
		return this.mapper.insert(pubNews) > 0;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.mapper.findMaxId();
	}
	
	
}
