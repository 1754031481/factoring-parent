package com.ph.permission.api.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ph.base.BaseController;
import com.ph.config.shiro.MyShiroRealm;
import com.ph.log.SystemService;
import com.ph.shopping.common.core.constant.CommonConstants;
import com.ph.shopping.common.core.customenum.SystemOperateEnum;
import com.ph.shopping.common.util.core.RespCode;
import com.ph.shopping.common.util.core.ResultUtil;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.permission.dto.UserDTO;
import com.ph.shopping.facade.permission.entity.User;
import com.ph.shopping.facade.permission.service.ILoginService;
import com.ph.shopping.facade.permission.service.IUserService;
import com.ph.shopping.facade.permission.vo.SessionUserVO;
import com.ph.shopping.facade.permission.vo.UserVO;
import com.ph.shopping.facade.system.dto.LotteryAdminDTO;
import com.ph.shopping.facade.system.service.IAwardsSettingService;
import com.ph.shopping.facade.system.vo.LotteryAdminVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author 荐家跃
 * @Title: AwardsSettingController
 * @Description: 奖项设置controller
 * @date 2018/3/20 10:27
 * @Version:1.0.0
 */
@Controller
@RequestMapping(value = "web/awards", method = {RequestMethod.GET, RequestMethod.POST})
public class AwardsSettingController extends BaseController {

    @Reference(version = "1.0.0")
    private IAwardsSettingService iAwardsSettingService;

    /**
     * 日志接口
     */
    @Autowired
    private SystemService systemService;

    @Autowired
    MyShiroRealm myShiroRealm;

    @Reference
    private IUserService userService;

    @Reference(version = "1.0.0")
    private ILoginService loginService;

    private Logger logger = LoggerFactory.getLogger(AwardsSettingController.class);

    @RequestMapping(value = "awardsList", method = RequestMethod.POST)
    public Object awardsList(Model model) {
        logger.info(".......开始查询奖项设置列表........");
        Result result = iAwardsSettingService.awardsList();
        List<LotteryAdminVO> userVOList = (List<LotteryAdminVO>) result.getData();
        Double nowScale = 0.0;
        for (LotteryAdminVO lotteryAdminVO : userVOList) {
            nowScale += Float.parseFloat(lotteryAdminVO.getScale());
        }
        model.addAttribute("pageInfo", userVOList);
        model.addAttribute("nowScale", nowScale);
        return "permission/system/awardsSettingList";
    }

    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: addAwards
     * @Description: 添加奖项
     * @Version:1.0.0
     */
    @RequestMapping(value = "addAwards", method = RequestMethod.POST)
    @ResponseBody
    public Result addAwards(LotteryAdminDTO lotteryAdminDTO) {
        SessionUserVO sessionUserVO = getLoginUser();
        logger.info(".......开始查询奖项设置列表........");
        if (ObjectUtils.isEmpty(lotteryAdminDTO.getName()) || ObjectUtils.isEmpty(lotteryAdminDTO.getPrice()) || ObjectUtils.isEmpty(lotteryAdminDTO.getScale())) {
            return ResultUtil.getResult(RespCode.Code.REQUEST_DATA_ERROR);
        }
        lotteryAdminDTO.setCreateId(sessionUserVO.getId());
        lotteryAdminDTO.setCreateTime(new Date());
        lotteryAdminDTO.setUpdateTime(new Date());
        lotteryAdminDTO.setPrice(lotteryAdminDTO.getPrice()*10000);
        //记录日志
        Result result = systemService.addSysLog(sessionUserVO, SystemOperateEnum.INSERT.getType(), "添加奖项");
        if (result.isSuccess()) {
            result = iAwardsSettingService.addAwards(lotteryAdminDTO);
        }
        logger.info("返回数据为:" + JSON.toJSONString(result.getData()));
        return result;
    }

    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: deleteAwards
     * @Description: 删除奖项
     * @Version:1.0.0
     */
    @RequestMapping(value = "deleteAwards", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteAwards(LotteryAdminDTO lotteryAdminDTO) {
        SessionUserVO sessionUserVO = getLoginUser();
        logger.info(".......开始删除奖项........");
        if (ObjectUtils.isEmpty(lotteryAdminDTO.getId())) {
            return ResultUtil.getResult(RespCode.Code.REQUEST_DATA_ERROR);
        }
        Result result = systemService.addSysLog(sessionUserVO, SystemOperateEnum.DELETE.getType(), "删除奖项");
        if (result.isSuccess()) {
            result = iAwardsSettingService.deleteAwards(lotteryAdminDTO);
        }
        logger.info("返回数据为:" + JSON.toJSONString(result.getData()));
        return result;
    }

    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: updateAwards
     * @Description: 修改奖项
     * @Version:1.0.0
     */
    @RequestMapping(value = "updateAwards", method = RequestMethod.POST)
    @ResponseBody
    public Result updateAwards(LotteryAdminDTO lotteryAdminDTO) {
        SessionUserVO sessionUserVO = getLoginUser();
        logger.info(".......开始修改奖项........");
        if (ObjectUtils.isEmpty(lotteryAdminDTO.getId())) {
            return ResultUtil.getResult(RespCode.Code.REQUEST_DATA_ERROR);
        }
        lotteryAdminDTO.setCreateId(sessionUserVO.getId());
        lotteryAdminDTO.setCreateTime(new Date());
        lotteryAdminDTO.setUpdateTime(new Date());
        lotteryAdminDTO.setPrice(lotteryAdminDTO.getPrice()*10000);
        Result result = systemService.addSysLog(sessionUserVO, SystemOperateEnum.UPDATE.getType(), "修改奖项");
        if (result.isSuccess()) {
            result = iAwardsSettingService.updateAwards(lotteryAdminDTO);
        }
        logger.info("返回数据为:" + JSON.toJSONString(result.getData()));
        return result;
    }

    /**
     * @param id
     * @author 荐家跃
     * @date 2018/3/20 22:09
     * @Title: findAwardsById
     * @Description: 通过id查询奖项
     * @Version:1.0.0
     */
    @RequestMapping(value = "/findAwardsById", method = RequestMethod.GET)
    @ResponseBody
    public Result findAwardsById(Long id) {
       if(ObjectUtils.isEmpty(id)){
           return  ResultUtil.getResult(RespCode.Code.REQUEST_DATA_ERROR);
       }
        Result result = iAwardsSettingService.findAwardsById(id);
       logger.info("查询结果为="+JSON.toJSONString(result.getData()));
        return result;
    }

    /**
     * @author 荐家跃
     * @date 2018/3/22 11:24
     * @param
     * @Title: getAwardsList
     * @Description: 获取奖项数据
     * @Version:1.0.0
     */


    @RequestMapping(value = "getAwardsList", method = RequestMethod.POST)
    @ResponseBody
    public Object getAwardsList() {
        logger.info(".......开始查询奖项设置列表........");
        Result result = iAwardsSettingService.getAwardsList();
        List<LotteryAdminVO> userVOList = (List<LotteryAdminVO>) result.getData();
        return userVOList;
    }


//------------------------------------------------------------------------------------------------------------------------
    /**
     * @描述：通过SessionManage获取在线用户列表修改角色后提出拥有该角色的用户
     * @param: roleId
     * @return:
     * @作者： Mr.Shu
     * @创建时间：2017/5/16 17:05
     */
    @Override
    public SessionUserVO getLoginUser() {

        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        SessionUserVO info = (SessionUserVO) currentUser.getSession().getAttribute(
                CommonConstants.LOGIN_BACK_USER_SESSION);

        //如果是记住我，处理Session失效
        if (info == null) {
            Object telPhone = currentUser.getPrincipal();
            if (telPhone != null) {
                boolean isRemembered = currentUser.isRemembered();
                if (isRemembered) {
                    //清除权限缓存
                    myShiroRealm.getAuthorizationCache().remove(currentUser.getPrincipals());
                    UserDTO userDTO = new UserDTO();
                    userDTO.setTelphone(telPhone.toString());
                    UserVO userVO = userService.getUserByCondition(userDTO);
                    //对密码进行加密后验证
                    UsernamePasswordToken token = new UsernamePasswordToken(userVO.getTelphone(), userVO.getPassword(), currentUser.isRemembered());
                    //把当前用户放入session
                    currentUser.login(token);
                    Session session = currentUser.getSession();
                    User user = new User();
                    user.setTelphone(userVO.getTelphone());
                    user.setPassword(userVO.getPassword());
                    Result result = loginService.login(user);
                    session.setAttribute(CommonConstants.LOGIN_BACK_USER_SESSION, result.getData());
                    info = (SessionUserVO) result.getData();
                }
            }

        }
        return info;

    }
}
