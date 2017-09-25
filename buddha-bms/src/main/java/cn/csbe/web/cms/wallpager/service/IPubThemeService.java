package cn.csbe.web.cms.wallpager.service;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.wallpager.bean.PubTheme;

public interface IPubThemeService extends IBaseService {
	boolean insert(PubTheme obj);

	Integer findMaxId();
}
