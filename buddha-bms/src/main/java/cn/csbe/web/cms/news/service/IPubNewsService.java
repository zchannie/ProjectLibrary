package cn.csbe.web.cms.news.service;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.news.bean.PubNews;

public interface IPubNewsService extends IBaseService {
	boolean insert(PubNews pubNews);

	Integer findMaxId();
}
