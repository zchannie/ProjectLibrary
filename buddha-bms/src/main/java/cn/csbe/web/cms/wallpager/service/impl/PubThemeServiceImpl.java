package cn.csbe.web.cms.wallpager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.wallpager.bean.PubTheme;
import cn.csbe.web.cms.wallpager.mapper.IPubThemeMapper;
import cn.csbe.web.cms.wallpager.service.IPubThemeService;

@Service
public class PubThemeServiceImpl extends BaseService implements IPubThemeService {

	private IPubThemeMapper mapper;

	@Autowired
	public void setMapper(IPubThemeMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public boolean insert(PubTheme a) {
		return this.mapper.insert(a) > 0;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.mapper.findMaxId();
	}
	
	
}
