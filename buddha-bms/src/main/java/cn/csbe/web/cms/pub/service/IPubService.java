package cn.csbe.web.cms.pub.service;

import java.util.List;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.pub.bean.PubCategory;

public interface IPubService extends IBaseService {
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
	List getCityByPid(Integer id);

	/**
	 * 根据类别id查询父类别
	 * 
	 * @param categoryId
	 * @return
	 */
	Object getCategoryById(Integer categoryId);

	/**
	 * 获取分类列表
	 * 
	 * @return
	 */
	List getCategorys();

	/**
	 * 获取机构列表
	 * 
	 * @return
	 */
	List getEnterprise();

	/**
	 * 根据分类pid获取下级城市
	 * 
	 * @param id
	 * @return
	 */
	List getCategoryByPid(Integer pid);

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
	 * 新增分类列
	 * 
	 * @return
	 */
	boolean insertCategory(Object obj);

	/**
	 * 更新分类
	 * 
	 * @param category
	 * @return
	 */
	boolean updateCategory(PubCategory category);
}
