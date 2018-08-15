package com.ph.permission.api.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ph.base.BaseController;
import com.ph.shopping.common.util.core.RespCode;
import com.ph.shopping.common.util.core.ResultUtil;
import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.common.util.result.ResultUtils;
import com.ph.shopping.facade.permission.vo.SessionUserVO;
import com.ph.shopping.facade.system.dto.SystemParameterDTO;
import com.ph.shopping.facade.system.dto.UpdateSystemParameterDTO;
import com.ph.shopping.facade.system.service.ISystemParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @项目：factoring-facade-order
 * @描述：系统参数设置 控制层
 * @作者： 张霞
 * @创建时间： 8:49 2017/6/15
 * @Copyright @2017 by zhangxia
 * @author YUEYUE
 */
@Controller
@RequestMapping(value = "web/systemParameter")
public class SystemParameterController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SystemParameterController.class);

    @Reference(version = "1.0.0")
    ISystemParameterService iSystemParameterService;


    /**
     * @param
     * @author: 张霞
     * @description：跳转到参数列表页面
     * @createDate: 10:00 2017/6/15
     * @return: java.lang.String
     * @version: 2.1
     */
    @RequestMapping(value = "toListPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String toListPage() {
        return "permission/system/systemParameterList";
    }

    /**
     * @param type
     * @author: 荐家跃
     * @description：修改状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "updateType", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result updateType(Integer type) {
        Result result;

        if (null == type) {
            return ResultUtils.returnError("参数错误");
        }
        try {
            UpdateSystemParameterDTO dto = new UpdateSystemParameterDTO();
            SessionUserVO loginUser = getLoginUser();
            dto.setOperatorId(loginUser.getId());
            dto.setOperateAccount(loginUser.getTelphone());
            dto.setOperatorName(loginUser.getUserName());
            result = iSystemParameterService.updateType(dto, type);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        logger.info("加载参数设置返回数据 Result = {}", JSON.toJSONString(result));
        return result;
    }

    /**
     * @param pageBean
     * @author: 张霞
     * @description：获取系统参数列表
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getSystemParameterList(PageBean pageBean) {
        Result result;
        try {
            result = iSystemParameterService.getSystemParameterList(pageBean);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        logger.info("加载参数设置返回数据 Result = {}", JSON.toJSONString(result));
        return result;
    }

    /**
     * @param dto
     * @author: 张霞
     * @description：
     * @createDate: 10:14 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result updateSystemParam(UpdateSystemParameterDTO dto) {
        Result result;
        SessionUserVO loginUser = getLoginUser();
        dto.setOperatorId(loginUser.getId());
        dto.setOperateAccount(loginUser.getTelphone());
        dto.setOperatorName(loginUser.getUserName());
        try {
            result = iSystemParameterService.updateSystemParameter(dto);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        return result;
    }
    /**
     * @param dto
     * @author: 荐家跃
     * @description：
     * @createDate: 10:14 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "newUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result newUpdateSystemParam(UpdateSystemParameterDTO dto) {
        Result result;
        SessionUserVO loginUser = getLoginUser();
        dto.setOperatorId(loginUser.getId());
        dto.setOperateAccount(loginUser.getTelphone());
        dto.setOperatorName(loginUser.getUserName());
        try {
            result = iSystemParameterService.newUpdateSystemParameter(dto);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        return result;
    }

    /**
     * @param systemParameterDTO
     * @author: 张霞
     * @description：通过参数获取对象的控制层
     * @createDate: 12:47 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "selectByParam", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result selectByParam(SystemParameterDTO systemParameterDTO) {
        Result result;
        try {
            result = iSystemParameterService.getSystemParameterBySelective(systemParameterDTO);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        return result;
    }

    /**
     * @param state
     * @author: 荐家跃
     * @description：修改积分启用状态
     * @createDate: 9:59 2017/6/15
     * @return: com.ph.shopping.common.util.result.Result
     * @version: 2.1
     */
    @RequestMapping(value = "updateIntegratedState", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result updateIntegratedState(Long state) {
        Result result;

        if (null == state) {
            return ResultUtils.returnError("参数错误");
        }
        try {
            UpdateSystemParameterDTO dto = new UpdateSystemParameterDTO();
            SessionUserVO loginUser = getLoginUser();
            dto.setOperatorId(loginUser.getId());
            dto.setOperateAccount(loginUser.getTelphone());
            dto.setOperatorName(loginUser.getUserName());
            result = iSystemParameterService.updateIntegratedState(dto, state);
        } catch (Exception e) {
            result = ResultUtil.getResult(RespCode.Code.FAIL);
        }
        logger.info("加载参数设置返回数据 Result = {}", JSON.toJSONString(result));
        return result;
    }
}
