package cn.csbe.web.cms.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.book.bean.PubBook;
import cn.csbe.web.cms.book.mapper.IPubBookMapper;
import cn.csbe.web.cms.book.service.IPubBookService;
import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.service.impl.BaseService;

@Service
public class PubBookServiceImpl extends BaseService implements IPubBookService {

	private IPubBookMapper bookMapper;

	@Autowired
	public void setBookMapper(IPubBookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public boolean insert(PubBook obj) {
		// TODO Auto-generated method stub
		return this.bookMapper.insert(obj) > 0;
	}


	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.bookMapper.findMaxId();
	}
	
	public QueryResult findByPage(Object t){
		QueryResult queryResult = new QueryResult();
		Long totalSize = this.bookMapper.findCount(t);
		List list = this.bookMapper.findByPage(t);
		queryResult.setTotalSize(totalSize);
		queryResult.setList(list);
		return queryResult;
	}
	
	public PubBook findById(int id){
		return this.bookMapper.findById(id);
	}
	
	public boolean update(PubBook t){
		return this.bookMapper.update(t) > 0;
	}
}
