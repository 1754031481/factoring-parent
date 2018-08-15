package com.ph.shopping.facade.system.service;

import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.system.dto.FreightTempletDTO;

/**
  * Describe:运费模板service
  * @param:
  * @return:
  * @author 段维明
  * @Date 2018/3/20
  */
public interface IFreightService {

    /**
      * Describe:查询运费模板列表
      * @param:
      * @return:
      * @author 段维明
      * @Date 2018/3/20
      */
	/*Result getFreightList();*/
	
	/**
	 * 分页物流公司
	* @Title: getLogisticsList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author Mr.Dong
	* @date  2017年6月15日 下午1:48:45
	* @param pageBean
	* @return
	 */
    Result getFreightList(PageBean pageBean,Integer deleteFlag);

    /**
      * Describe:查询vo
      * @param:
      * @return:
      * @author 段维明
      * @Date 2018/3/21
      */
    //Result getFreightDetail(FreightTempletDTO freightTempletDTO);
    /**
      * Describe:添加
      * @param:
      * @return:
      * @author 段维明
      * @Date 2018/3/20
      */
    Result addFreightTemplet(FreightTempletDTO freightTempletDTO);
    /**
      * Describe:编辑运费模板
      * @param:
      * @return:
      * @author 段维明
      * @Date 2018/3/21
      */
    Result updateFreight(FreightTempletDTO dto);
    /**
      * Describe:删除
      * @param:
      * @return:
      * @author 段维明
      * @Date 2018/3/21
      */
    Result deleteFreight();
    
    /**
     * 通过主键获取物流公司
    * @Title: getLogisticById
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @author Mr.Dong
    * @date  2017年6月15日 上午11:55:12
    * @param
    * @return
     */
    Result getFreightDetail(Long id);


    /**
     * Describe:编辑运费模板
     * @param:
     * @return:
     * @author 段维明
     * @Date 2018/3/21
     */
    Result updateDeleteFlag(Integer deleteFlag);
}
