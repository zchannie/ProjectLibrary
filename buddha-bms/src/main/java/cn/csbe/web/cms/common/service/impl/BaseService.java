package cn.csbe.web.cms.common.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.common.service.IBaseService;


/**
 * 分装通用方法
 * @author e
 *
 */
public class BaseService implements IBaseService {

	
	public static Logger _log = Logger.getLogger(BaseService.class);

	private IBaseMapper mapper;

	public IBaseMapper getMapper() {
		return this.mapper;
	}

	public void setMapper(IBaseMapper mapper) {
		this.mapper = mapper;
	}

	public boolean persistence(Object t) throws Exception {
		return this.mapper.persistence(t) > 0;
	}

	public boolean delete(Integer id) throws Exception {
		return this.mapper.deleteById(id) > 0;
	}

	public boolean update(Object t) throws Exception {
		return this.mapper.update(t) > 0;
	}

	public Object findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	public List findAll() throws Exception {
		return this.mapper.findAll();
	}

	public List findByEntity(Object t) throws Exception {
		return this.mapper.findByEntity(t);
	}

	public QueryResult findByPage(Object t) throws Exception {
		QueryResult queryResult = new QueryResult();
		Long totalSize = this.mapper.findCount(t);
		List list = this.mapper.findByPage(t);
		queryResult.setTotalSize(totalSize);
		queryResult.setList(list);
		return queryResult;
	}
	
}
