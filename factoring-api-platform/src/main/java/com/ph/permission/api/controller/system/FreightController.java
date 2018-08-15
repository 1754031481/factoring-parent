package com.ph.permission.api.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ph.base.BaseController;
import com.ph.log.SystemService;
import com.ph.shopping.common.core.customenum.SystemOperateEnum;
import com.ph.shopping.common.util.bean.VoDtoEntityUtil;
import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.permission.vo.SessionUserVO;
import com.ph.shopping.facade.system.dto.FreightTempletDTO;
import com.ph.shopping.facade.system.dto.LogisticsDTO;
import com.ph.shopping.facade.system.service.IFreightService;
import com.ph.shopping.facade.system.service.ILogisticsService;
import com.ph.shopping.facade.system.vo.FreightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
  * Describe:运费模板controller
  * @author 段维明
  * @Date 2018/3/20
  */
@Controller
@RequestMapping(value = "web/freight")
public class FreightController extends BaseController  {


	@Reference(version = "1.0.0")
	private IFreightService iFreightService;
	/**
	 * 	日志接口
	 */
	@Autowired
	private SystemService systemService;
	/**
	  * Describe:运费模板页面跳转
	  * @param:
	  * @return:
	  * @author 段维明
	  * @Date 2018/3/20
	  */
	@RequestMapping(value = "toFreightTemplet", method = RequestMethod.GET)
	public String toFreightTemplet() {
		return "permission/system/freightTemplet";
	}

	/**
	  * Describe:添加页面跳转
	  * @param:
	  * @return:
	  * @author 段维明
	  * @Date 2018/3/20
	  */
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.GET)
	public String freightTempletAddOrUpdate(@RequestParam(name = "operateType", defaultValue = "add") String operateType, Long id, FreightVO freightVO, Model model) {
		if (id != null && id > 0) {
			operateType = "update";
			FreightTempletDTO freightTempletDTO = new FreightTempletDTO();
			freightTempletDTO.setId(id);
			freightVO = VoDtoEntityUtil.convert(iFreightService.getFreightDetail(id).getData(), FreightVO.class);
		}
		model.addAttribute("freightVO", freightVO);
		model.addAttribute("operateType", operateType);
		return "permission/system/freightTempletAddOrUpdate";
	}
	/**
	 * Describe:查询运费列表(主页面)
	 * @param:
	 * @return:
	 * @author 段维明
	 * @Date 2018/3/20
	 */
	@RequestMapping(value = "/getFreightList", method = RequestMethod.GET)
	@ResponseBody
	public Result getFreightList(PageBean pageBean){
		Integer deleteFlag=2;
		return iFreightService.getFreightList(pageBean,deleteFlag);
	}

	/**
	 * Describe:查询运费列表(添加页面)
	 * @param:
	 * @return:
	 * @author 段维明
	 * @Date 2018/3/20
	 */
	@RequestMapping(value = "/getMiddleFreightList", method = RequestMethod.GET)
	@ResponseBody
	public Result getMiddleFreightList(PageBean pageBean){
		Integer deleteFlag=1;
		return iFreightService.getFreightList(pageBean,deleteFlag);
	}

	/**
	 * Describe:修改运费模板
	 * @param:
	 * @return:
	 * @author 段维明
	 * @Date 2018/3/20
	 */
	@RequestMapping(value = "/updateDeleteFlag", method = RequestMethod.POST)
	@ResponseBody
	public Result updateDeleteFlag(){
		Integer deleteFlag=2;
		return iFreightService.updateDeleteFlag(deleteFlag);
	}
	
	/**
	  * Describe:删除运费模板
	  * @param:
	  * @return:
	  * @author 段维明
	  * @Date 2018/3/21
	  */
	@RequestMapping(value = "/deleteFreight", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteFreight(){
		SessionUserVO sessionUserVO = getLoginUser();
		//记录日志
		Result result = systemService.addSysLog(sessionUserVO, SystemOperateEnum.DELETE.getType(), "删除运费模板");
		if (result.isSuccess()) {
			result = iFreightService.deleteFreight();
		}
		return result;
	}

	/**
	 * 增加方法
	 *
	 * @return String
	 * @author 段维明
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Result add(@ModelAttribute FreightTempletDTO freightTempletDTO) {
		freightTempletDTO.setCreaterId(getLoginUser().getId());
		Result result = systemService.addSysLog(getLoginUser(), SystemOperateEnum.INSERT.getType(), "运费模板添加");
		if (result.isSuccess()) {
			result = iFreightService.addFreightTemplet(freightTempletDTO);
		}
		return result;
	}
	
	/**
	  * Describe:编辑运费模板
	  * @param:
	  * @return:
	  * @author 段维明
	  * @Date 2018/3/21
	  */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Result updateFreight(FreightTempletDTO dto){
		SessionUserVO sessionUserVO = getLoginUser();
		//记录日志
		Result result = systemService.addSysLog(sessionUserVO, SystemOperateEnum.UPDATE.getType(), "修改运费模板");
		if (result.isSuccess()) {
			result =  iFreightService.updateFreight(dto);
		}
		return result;
	}
	/**
	  * Describe:子页面跳转页面
	  * @param:
	  * @return:
	  * @author 段维明
	  * @Date 2018/3/21
	  */
	@RequestMapping("/update/{id}")
	public String forwardFeightSonUrl(@PathVariable("id") Long id,Model model){
		String operateType = "update";
		FreightTempletDTO freightTempletDTO = new FreightTempletDTO();
		freightTempletDTO.setId(id);
		FreightVO freightVO = VoDtoEntityUtil.convert(iFreightService.getFreightDetail(id).getData(), FreightVO.class);
		model.addAttribute("freightVO", freightVO);
		model.addAttribute("operateType", operateType);
		return "permission/system/freightTempletAddOrUpdate";
	}

	/**
	 * Describe:父页面跳转页面
	 * @param:
	 * @return:
	 * @author 段维明
	 * @Date 2018/3/21
	 */
	@RequestMapping("/updateParent/{id}")
	public String forwardFeightParentUrl(@PathVariable("id") Long id,Model model){
		String operateType = "update";
		FreightTempletDTO freightTempletDTO = new FreightTempletDTO();
		freightTempletDTO.setId(id);
		FreightVO freightVO = VoDtoEntityUtil.convert(iFreightService.getFreightDetail(id).getData(), FreightVO.class);
		model.addAttribute("freightVO", freightVO);
		model.addAttribute("operateType", operateType);
		return "permission/system/freightTempletOnlyUpdate";
	}
}
