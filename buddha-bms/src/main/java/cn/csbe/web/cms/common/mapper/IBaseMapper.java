package cn.csbe.web.cms.common.mapper;

import java.io.Serializable;
import java.util.List;

public interface IBaseMapper {
	
	/**
	 * @Description TODO 持久化实体
	 */
	int persistence(Object entity);
	
	/**
	* @Description TODO 根据Id删除数据
	 */
    int deleteById(Integer id);

    /**
    * @Description TODO 更新数据
     */
    int update(Object entity);
    
    /**
    * @Description TODO 根据ID查询对象
     */
    Object findById(Serializable id);

    /**
    * @Description TODO 根据实体查询 对象集
     */
    List findByEntity(Object entity);
    
    /**
    * @Description TODO 分页查询根据 对象
     */
    List findByPage(Object entity);
    
    /**
    * @Description TODO 根据实体查询 符合条件 总量
     */
    Long findCount(Object entity);

    /**
    * @Description TODO 获取所有实体
     */
	List findAll();

}
