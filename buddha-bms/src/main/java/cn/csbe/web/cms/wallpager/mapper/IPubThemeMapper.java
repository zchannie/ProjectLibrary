package cn.csbe.web.cms.wallpager.mapper;

import cn.csbe.web.cms.wallpager.bean.PubTheme;
import cn.csbe.web.cms.common.mapper.IBaseMapper;

public interface IPubThemeMapper extends IBaseMapper {
	Integer insert(PubTheme PubTheme);

	Integer findMaxId();

}
