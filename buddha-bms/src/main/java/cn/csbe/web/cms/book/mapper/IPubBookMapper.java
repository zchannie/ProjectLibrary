package cn.csbe.web.cms.book.mapper;

import java.util.List;

import cn.csbe.web.cms.book.bean.PubBook;
import cn.csbe.web.cms.common.mapper.IBaseMapper;

public interface IPubBookMapper extends IBaseMapper {
	Integer insert(PubBook book);

	Integer findMaxId();
	
	Long findCount(PubBook b);
	
	List findByPage(PubBook b);
	
	PubBook findById(int bookId);
	
	Integer update(PubBook b);
}
