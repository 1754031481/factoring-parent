package com.ph.permission.api.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ph.shopping.common.util.core.RespCode;
import com.ph.shopping.common.util.core.ResultUtil;
import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.system.dto.PrizePoolDTO;
import com.ph.shopping.facade.system.service.ILotteryService;
import com.ph.shopping.facade.system.vo.LotteryAdminVO;
import com.ph.shopping.facade.system.vo.PrizePoolVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 刘海洋
 * @Title: LotteryController
 * @Description: 奖券controller
 * @date 2018/3/20 13:35
 * @Version:1.0.0
 */
@Controller
@RequestMapping(value = "web/lottery")
public class LotteryController {

    private Logger logger = LoggerFactory.getLogger(LotteryController.class);

    @Reference(version = "1.0.0")
    private ILotteryService iLotteryService;

    /**
     * @author 刘海洋
     * @date 2018/3/20 15:01
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: lotteryList
     * @Description: 获取奖池列表
     * @Version:1.0.0
     */
    @RequestMapping(value = "toLotteryList",method = {RequestMethod.POST,RequestMethod.GET})
    public String lotteryList(HttpServletRequest request, PrizePoolDTO prizePoolDTO, Model model, PageBean pageBean){
        logger.info("开始查询奖池列表,接收参数为"+JSON.toJSONString(prizePoolDTO));
        PrizePoolVO prizePoolVO1 = null;
        prizePoolVO1 = iLotteryService.lotteryList(prizePoolDTO, pageBean);
        if(ObjectUtils.isEmpty(prizePoolVO1)){
            prizePoolVO1 = new PrizePoolVO();
        }
        logger.info("查询奖池列表获取的数据" + JSON.toJSONString(prizePoolVO1));
        if(!ObjectUtils.isEmpty(prizePoolDTO.getLotteryStartTime()) || !ObjectUtils.isEmpty(prizePoolDTO.getLotteryEndTime())) {
            logger.info("开始查询订单金额和奖池总金额.......");
            PrizePoolVO prizePoolVO = iLotteryService.selectPriceForPrize(prizePoolDTO);
            if (!ObjectUtils.isEmpty(prizePoolVO)) {
                if (!ObjectUtils.isEmpty(prizePoolVO.getLotteryNum())) {
                    prizePoolVO1.setLotteryNum(prizePoolVO.getLotteryNum());
                } else {
                    prizePoolVO1.setLotteryNum(0L);
                }
                if (!ObjectUtils.isEmpty(prizePoolVO.getOrderSumPrice())) {
                    prizePoolVO1.setOrderSumPrice(prizePoolVO.getOrderSumPrice()/10000);
                } else {
                    prizePoolVO1.setOrderSumPrice(0L);
                }
                prizePoolVO1.setPrizeSumPrice(prizePoolVO1.getOrderSumPrice() * prizePoolVO1.getLotteryNum());
                prizePoolVO1.setStartTime(prizePoolDTO.getLotteryStartTime());
                prizePoolVO1.setEndTime(prizePoolDTO.getLotteryEndTime());
            }
        }
        logger.info("查询订单金额和奖池总金额得到的数据" + JSON.toJSONString(prizePoolVO1));
            model.addAttribute("prizePoolVO1", prizePoolVO1);
            return "prizePool/list";
    }

    /**
     * @author 刘海洋
     * @date 2018/3/20 21:36
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: generatePrize
     * @Description: 生成奖池
     * @Version:1.0.0
     */
    @RequestMapping(value = "generatePrize",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result generatePrize(HttpServletRequest request,PrizePoolDTO prizePoolDTO){
        logger.info("开始生成奖池....接收参数"+JSON.toJSONString(prizePoolDTO));
        if(ObjectUtils.isEmpty(prizePoolDTO.getEndTime())||ObjectUtils.isEmpty(prizePoolDTO.getStartTime())){
            logger.info("请求参数不全!");
            return ResultUtil.getResult(RespCode.Code.REQUEST_DATA_ERROR);
        }
        PrizePoolVO prizePoolVO = iLotteryService.selectPriceForPrize(prizePoolDTO);
        prizePoolVO.setLotteryStartTime(prizePoolDTO.getStartTime());
        prizePoolVO.setLotteryEndTime(prizePoolDTO.getEndTime());
        prizePoolVO.setLotteryOpenTime(prizePoolDTO.getOpenTime());
        Result result = iLotteryService.generatePrize(prizePoolVO);
        return result;
    }

    /**
     * @author 刘海洋
     * @date 2018/3/21 11:42
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: checkDate
     * @Description: 检查时间是否是结束时间的后一天
     * @Version:1.0.0
     */
    @RequestMapping(value = "checkDate",method = RequestMethod.POST)
    @ResponseBody
    public Result checkDate(HttpServletRequest request,PrizePoolDTO prizePoolDTO){
        logger.info("开始检查时间是否是结束时间的后一天...接收参数为"+JSON.toJSONString(prizePoolDTO));
        if(ObjectUtils.isEmpty(prizePoolDTO.getLotteryStartTime()) || ObjectUtils.isEmpty(prizePoolDTO.getLotteryEndTime())) {
            return ResultUtil.setResult(false,"请求参数不全!");
        }
        Result result = iLotteryService.checkDate(prizePoolDTO);
        logger.info("检查时间是否是结束时间的后一天controller得到的数据"+JSON.toJSONString(result));
        return result;
    }

    /**
     * @author 刘海洋
     * @date 2018/3/21 14:27
     * @param {id}
     * @Title: openPrize
     * @Description: 开启奖池
     * @Version:1.0.0
     */
    @RequestMapping(value = "openPrize",method = RequestMethod.POST)
    @ResponseBody
    public Result openPrize(HttpServletRequest request, PrizePoolDTO prizePoolDTO){
        logger.info("开启奖池时controller接收的参数"+JSON.toJSONString(prizePoolDTO));
        if(ObjectUtils.isEmpty(prizePoolDTO.getId())||ObjectUtils.isEmpty(prizePoolDTO.getOpenTime())){
            logger.info("请求参数不全!");
            return ResultUtil.setResult(false,"请求参数不全!");
        }
        Result result = iLotteryService.openPrize(prizePoolDTO);
        logger.info("开启奖池controller接收的参数"+JSON.toJSONString(result));
        return result;
    }

    /**
     * @author 刘海洋
     * @date 2018/3/21 15:19
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: viewPrize
     * @Description: 奖项预览
     * @Version:1.0.0
     */
    @RequestMapping(value = "viewPrize",method = {RequestMethod.POST,RequestMethod.GET})
    public String viewPrize(HttpServletRequest request,PrizePoolDTO prizePoolDTO,Model model,PageBean pageBean){
        logger.info("奖项预览时controller接收的参数"+JSON.toJSONString(prizePoolDTO));
        if(ObjectUtils.isEmpty(prizePoolDTO.getId())){
            logger.info("请求参数不全!");
            return null;
        }
        Long lotterySumNum = 0L;
        double prizeSumPrice = 0;
        double prizeOpnePrice = 0;
        List<LotteryAdminVO> prizePoolVOS = null;
        Result result = iLotteryService.viewPrize(prizePoolDTO,pageBean);
        if(!ObjectUtils.isEmpty(result.getData())){
            prizePoolVOS =(List<LotteryAdminVO>) result.getData();
            logger.info("=====================奖项预览结果："+JSON.toJSONString(prizePoolVOS));
            for(LotteryAdminVO prizePoolVO:prizePoolVOS){
                lotterySumNum = lotterySumNum + prizePoolVO.getLotteryNum();
                prizeSumPrice = prizeSumPrice + prizePoolVO.getPrice();
                prizeOpnePrice = prizeOpnePrice + prizePoolVO.getLotteryNum() * prizePoolVO.getPrice();
                logger.info("奖项预览时controller得到的数据"+JSON.toJSONString(prizePoolVOS));
            }
        }

        model.addAttribute("prizePoolVOS",prizePoolVOS);
        model.addAttribute("lotterySumNum",lotterySumNum);
        model.addAttribute("prizeSumPrice",prizeSumPrice);
        model.addAttribute("prizeOpnePrice",prizeOpnePrice);
        return "prizePool/prizePreview";
    }

    /**
     * @author 刘海洋
     * @date 2018/3/21 15:19
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: viewPrize
     * @Description: 查看中奖结果
     * @Version:1.0.0
     */
    @RequestMapping(value = "prizeResult",method = {RequestMethod.POST,RequestMethod.GET})
    public String prizeResult(HttpServletRequest request,PrizePoolDTO prizePoolDTO,Model model){
        logger.info("查看中奖结果时controller接收的参数"+JSON.toJSONString(prizePoolDTO));
        if(ObjectUtils.isEmpty(prizePoolDTO.getId())){
            logger.info("请求参数不全!");
            return null;
        }
        List<PrizePoolVO> prizePoolVOS = iLotteryService.prizeResult(prizePoolDTO);
        for(PrizePoolVO poolVO:prizePoolVOS){
            double v = poolVO.getPrizePrice() / 10000.00;
            poolVO.setPrizePriceForDouble(v);
        }
        logger.info("查看中奖结果时controller得到的数据"+JSON.toJSONString(prizePoolVOS));
        model.addAttribute("prizePoolVOS",prizePoolVOS);
        return "prizePool/prizeResult";
    }

    /**
     * @author 刘海洋
     * @date 2018/3/26 10:47
     * @param {id}
     * @Title: prizeDetails
     * @Description: 查看奖池详情
     * @Version:1.0.0
     */
    @RequestMapping(value = "prizeDetails",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result prizeDetails(HttpServletRequest request, PrizePoolDTO prizePoolDTO, Model model, PageBean pageBean){
        logger.info("查看奖池详情时controller接收的参数"+JSON.toJSONString(prizePoolDTO));
        Result prizePoolVOS = iLotteryService.viewPrize(prizePoolDTO,pageBean);
        logger.info("查看奖池详情时controller得到的数据"+JSON.toJSONString(prizePoolVOS));
        return prizePoolVOS;
    }

    /**
     * @author 刘海洋
     * @date 2018/3/26 13:56
     * @param {id}
     * @Title: toPrizeDetails
     * @Description: 去奖池详情页面
     * @Version:1.0.0
     */
    @RequestMapping(value = "toPrizeDetails",method = {RequestMethod.POST,RequestMethod.GET})
    public String toPrizeDetails(HttpServletRequest request,PrizePoolDTO prizePoolDTO,Model model){
        model.addAttribute("id",prizePoolDTO.getId());
        return "prizePool/prizeDetails";
    }

    /**
     * @author 刘海洋
     * @date 2018/4/20 17:53
     * @param {id}
     * @Title: getLotteryStatus
     * @Description: 查看开间时间是否为系统当前时间
     * @Version:1.0.0
     */
    @RequestMapping(value = "getLotteryStatus",method = RequestMethod.POST)
    public void getLotteryStatus(HttpServletRequest request, HttpServletResponse response,PrizePoolDTO prizePoolDTO) throws IOException{
        logger.info("查看开间时间是否为系统当前时间controller接收的数据:"+JSON.toJSONString(prizePoolDTO));
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(day);
        logger.info("获取当前系统时间的string格式为:"+format);
        try {
            Date parse = df.parse(format);
            logger.info("获取当前系统时间的Date格式为:"+parse);
            PrizePoolVO poolVO = iLotteryService.getLotteryStatus(prizePoolDTO);
            logger.info("查看开间时间是否为系统当前时间从数据库得到的数据:"+JSON.toJSONString(poolVO));
            if(!ObjectUtils.isEmpty(poolVO)){
                if(!ObjectUtils.isEmpty(poolVO.getLotteryOpenTime())){
                    long time = poolVO.getLotteryOpenTime().getTime();
                    long time1 = parse.getTime();
                    if (time <= time1){
                        response.getWriter().print(false);
                    }else{
                        response.getWriter().print(true);
                    }
                }
            }else{
                response.getWriter().print(false);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.getWriter().print(false);
        }

    }

    /**
     * @author 刘海洋
     * @date 2018/4/26 19:48
     * @param {id,lotteryOpenTime}
     * @Title: checkOpenTime
     * @Description: 检查开奖时间
     * @Version:1.0.0
     */
    @RequestMapping(value = "checkOpenTime",method = RequestMethod.POST)
    @ResponseBody
    public Result checkOpenTime(HttpServletRequest request,PrizePoolDTO prizePoolDTO){
        if(ObjectUtils.isEmpty(prizePoolDTO.getId())||ObjectUtils.isEmpty(prizePoolDTO.getLotteryOpenTime())){
            logger.info("请求参数不全!");
            return ResultUtil.setResult(false,"请求参数不全!");
        }
        logger.info("检查开奖时间controller接收的数据:{}",JSON.toJSONString(prizePoolDTO));
        Result poolVO = iLotteryService.checkOpenTime(prizePoolDTO);
        logger.info("检查开奖时间controller得到的上一次开奖时间和此奖池接收周期时间:{}",JSON.toJSONString(poolVO));
        return poolVO;
    }
}
