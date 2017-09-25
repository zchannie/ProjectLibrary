package cn.csbe.web.cms.pub.mapper;

import java.util.List;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.pub.bean.PubCategory;

public interface IPubMapper extends IBaseMapper {

	/**
	 * 获取城市信息
	 * 
	 * @return
	 */
	Object getCityById(Integer id);

	/**
	 * 获取城市列表
	 * 
	 * @return
	 */
	List getCitys();

	/**
	 * 根据城市pid获取下级城市
	 * 
	 * @param id
	 * @return
	 */
	List getCityByPid(Integer pid);

	/**
	 * 获取分类列表
	 * 
	 * @return
	 */
	List getCategorys();

	List getEnterprise();

	/**
	 * 根据分类pid获取下级城市
	 * 
	 * @param id
	 * @return
	 */
	List getCategoryByPid(Integer pid);

	/**
	 * 根据类别id查询父类别
	 * 
	 * @param categoryId
	 * @return
	 */
	Object getCategoryById(Integer categoryId);
	
	/**
	 * 获取政策列表
	 * 
	 * @param policy
	 * @return
	 */
	// Object getPolicys(Policy policy);

	/**
	 * 根据政策id，获取政策详情
	 * 
	 * @param policyId
	 * @return
	 */
	Object getPolicyById(Integer policyId);

	/**
	 * 获取创新列表
	 * 
	 * @param policy
	 * @return
	 */
	// List getInnovations(Policy policy);
	// Long getInnovationCount(Policy policy);

	/**
	 * 根据政策id，获取创新详情
	 * 
	 * @param policyId
	 * @return
	 */
	Object getInnovationById(Integer policyId);

	/**
	 * 新增分类
	 * 
	 * @param obj
	 * @return
	 */
	Integer insertCategory(Object obj);

	/**
	 * 更新分类
	 * 
	 * @param category
	 * @return
	 */
	Integer updateCategory(PubCategory category);
}
