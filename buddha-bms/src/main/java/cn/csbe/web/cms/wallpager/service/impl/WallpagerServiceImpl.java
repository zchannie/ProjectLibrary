package cn.csbe.web.cms.wallpager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.wallpager.bean.PubWallpaper;
import cn.csbe.web.cms.wallpager.mapper.IWallpagerMapper;
import cn.csbe.web.cms.wallpager.service.IWallpagerService;

@Service
public class WallpagerServiceImpl extends BaseService implements IWallpagerService {

	private IWallpagerMapper mapper;

	@Autowired
	public void setMapper(IWallpagerMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public boolean insert(PubWallpaper a) {
		return this.mapper.insert(a) > 0;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.mapper.findMaxId();
	}
	
	
}
