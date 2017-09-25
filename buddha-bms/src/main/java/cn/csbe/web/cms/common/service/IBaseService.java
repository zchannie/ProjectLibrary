package cn.csbe.web.cms.common.service;

import java.util.List;

import cn.csbe.web.cms.common.bean.QueryResult;

public interface IBaseService {

	/**
	 * 持久化对象
	* @Title: persistence 
	* @param @param t
	* @param @return
	* @param @throws Exception     
	* @return boolean     
	* @throws
	 */
	public boolean persistence(Object entity)throws Exception;
	
	/**
	 * 删除对象
	* @Title: delete 
	* @param @param t
	* @param @return
	* @param @throws Exception     
	* @return boolean     
	* @throws
	 */
	public boolean delete(Integer id)throws Exception;
	
	/**
	 * 更新对象
	* @Title: update 
	* @param @param t
	* @param @return
	* @param @throws Exception     
	* @return boolean     
	* @throws
	 */
	public boolean update(Object entity)throws Exception;
	
	/**
	 * 根据Id查询实体
	* @Title: findById 
	* @param @param id
	* @param @return
	* @param @throws Exception     
	* @return Object     
	* @throws
	 */
	public Object findById(Integer id)throws Exception;
	
	/**
	 *	获取全部数据
	* @Title: findByEntity 
	* @param @param 
	* @param @return
	* @param @throws Exception     
	* @return List     
	* @throws
	 */
	public List findAll()throws Exception;
	
	/**
	 * 根据实体查询实体
	* @Title: findByEntity 
	* @param @param t 属性不为空 该属性为条件，
	* @param @return
	* @param @throws Exception     
	* @return List     
	* @throws
	 */
	public List findByEntity(Object entity)throws Exception;
	
	/**
	 * 分页查询 根据实体，
	* @Title: findByPage 
	* @param @param t
	* @param @return
	* @param @throws Exception     
	* @return QueryResult<Object> 分装了 结果集&符合条件的数量    
	* @throws
	 */
	public QueryResult findByPage(Object entity)throws Exception;
}
