package cn.csbe.web.cms.wallpager.mapper;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.wallpager.bean.PubWallpaper;

public interface IWallpagerMapper extends IBaseMapper {
	Integer insert(PubWallpaper PubTheme);

	Integer findMaxId();

}
