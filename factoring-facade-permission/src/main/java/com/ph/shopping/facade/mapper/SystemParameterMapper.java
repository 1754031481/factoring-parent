package com.ph.shopping.facade.mapper;

import com.ph.shopping.common.core.base.BaseMapper;
import com.ph.shopping.facade.system.entity.SystemParameter;
import com.ph.shopping.facade.system.vo.SystemParameterVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 系统参数设置mapper
 *
 * @author 郑朋
 * @create 2017/5/8
 **/
@Repository
public interface SystemParameterMapper extends BaseMapper<SystemParameter> {

    /**
     * @param
     * @return java.util.List<com.ph.shopping.facade.system.vo.SystemParameterVO>
     * @methodname selectSystemParameterList 的描述：查询所有的参数配置
     * @author 郑朋
     * @create 2017/5/8
     */
    List<SystemParameterVO> selectSystemParameterList();


    /**
     * @param systemParameter
     * @return java.util.List<com.ph.shopping.facade.system.vo.SystemParameterVO>
     * @methodname selectSystemParameterBySelective 的描述：条件查询系统参数
     * @author 郑朋
     * @create 2017/5/9
     */
    List<SystemParameterVO> selectSystemParameterBySelective(SystemParameter systemParameter);

    /**
     * @param ids
     * @return java.util.List<com.ph.shopping.facade.system.vo.SystemParameterVO>
     * @methodname selectSystemParameterByIds 的描述：通过id查询系统参数
     * @author 郑朋
     * @create 2017/5/9
     */
    List<SystemParameterVO> selectSystemParameterByIds(@Param(value = "ids") List<Long> ids);

    /**
     * 根据id查询参数值
     *
     * @param id
     * @return
     */
    SystemParameterVO getSystemParameterById(@Param(value = "id") Long id);

    /**
     * 修改参数
     *
     * @param param
     */
    void updateSystemParameterById(Map<String, Object> param);

    /**
     * @param type
     * @author: 荐家跃
     * @description：修改状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    void updateType(Integer type);

    /**
     * @param state
     * @author: 荐家跃
     * @description：修改积分启用状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    void updateIntegratedState(Long state);
    /**
     * @param param
     * @author: 荐家跃
     * @description：
     * @createDate: 10:14 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    void newUpdateSystemParameterById(Map<String,Object> param);

    /**
     * @author:  wangxueyang[wxueyanghj@163.com]
     * @create:  2018/6/11 20:19
     * @desc: 计算分润体系和
     * @version 1.0.0
     * @return
     */
    Double getSumProfit(@Param("id") Long id);
}
