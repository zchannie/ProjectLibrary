package cn.csbe.web.cms.news.mapper;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.news.bean.PubNews;

public interface IPubNewsMapper extends IBaseMapper {
	Integer insert(PubNews pubNews);

	Integer findMaxId();
}
