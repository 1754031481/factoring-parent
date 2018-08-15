package com.ph.shopping.facade.system.service;

import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.system.dto.SystemParameterDTO;
import com.ph.shopping.facade.system.dto.UpdateSystemParameterDTO;
import com.ph.shopping.facade.system.vo.SystemParameterVO;

import java.util.List;

/**
 * 系统参数设置接口
 *
 * @author 郑朋
 * @create 2017/5/8
 **/
public interface ISystemParameterService {

    /**
     * @param updateSystemParameterDTO
     * @return com.ph.shopping.common.util.result.Result
     * @methodname updateSystemParameter 的描述：修改参数值
     * @author 郑朋
     * @create 2017/5/8
     */
    Result updateSystemParameter(UpdateSystemParameterDTO updateSystemParameterDTO);

    /**
     * @param
     * @return com.ph.shopping.common.util.result.Result
     * @methodname getSystemParameterList 的描述：查询所有的系统参数
     * @author 郑朋
     * @create 2017/5/8
     */
    Result getSystemParameterList(PageBean pageBean);

    /**
     * @param systemParameterDTO
     * @return com.ph.shopping.common.util.result.Result
     * @methodname getSystemParameterBySelective 的描述：条件查询系统参数
     * @author 郑朋
     * @create 2017/5/8
     */
    Result getSystemParameterBySelective(SystemParameterDTO systemParameterDTO);

    /**
     * @param ids
     * @return com.ph.shopping.common.util.result.Result
     * @methodname getSystemParameterListByIds 的描述：通过id查询系统参数
     * @author 郑朋
     * @create 2017/5/17
     */
    Result getSystemParameterListByIds(List<Long> ids);

    /**
     * 根据id获取参数信息
     *
     * @param id
     * @return
     */
    Double getSystemParameterById(Long id);

    /**
     * @param type
     * @author: 荐家跃
     * @description：修改状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    Result updateType(UpdateSystemParameterDTO dto, Integer type);

    /**
     * @param state
     * @author: 荐家跃
     * @description：修改积分启用状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    Result updateIntegratedState(UpdateSystemParameterDTO dto, Long state);
    /**
     * @param dto
     * @author: 荐家跃
     * @description：
     * @createDate: 10:14 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    Result newUpdateSystemParameter(UpdateSystemParameterDTO dto);
}
