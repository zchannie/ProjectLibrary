package cn.csbe.web.cms.wallpager.service;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.wallpager.bean.PubWallpaper;

public interface IWallpagerService extends IBaseService {
	boolean insert(PubWallpaper obj);

	Integer findMaxId();
}
