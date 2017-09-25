package cn.csbe.web.cms.book.service;

import cn.csbe.web.cms.book.bean.PubBook;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.service.IBaseService;

public interface IPubBookService extends IBaseService {
	boolean insert(PubBook book);

	Integer findMaxId();

	QueryResult findByPage(Object t);

	PubBook findById(int id);

	boolean update(PubBook t);
}
