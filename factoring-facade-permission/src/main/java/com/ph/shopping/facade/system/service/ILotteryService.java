package com.ph.shopping.facade.system.service;

import com.ph.shopping.common.util.page.PageBean;
import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.system.dto.PrizePoolDTO;
import com.ph.shopping.facade.system.vo.PrizePoolVO;
import com.ph.shopping.facade.system.vo.SystemParameterVO;

import java.util.List;

/**
 * @author 刘海洋
 * @Title: ILotteryService
 * @Description: 奖券service接口
 * @date 2018/3/20 13:37
 * @Version:1.0.0
 */
public interface ILotteryService {

    /**
     * @author 刘海洋
     * @date 2018/3/20 15:08
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: lotteryList
     * @Description: 获取奖池列表
     * @Version:1.0.0
     */
    PrizePoolVO lotteryList(PrizePoolDTO prizePoolDTO, PageBean pageBean);

    /**
     * @author 刘海洋
     * @date 2018/3/20 16:05
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: selectPriceForPrize
     * @Description: 查询奖池订单总金额和奖池总金额
     * @Version:1.0.0
     */
    PrizePoolVO selectPriceForPrize(PrizePoolDTO prizePoolDTO);

    /**
     * @author 刘海洋
     * @date 2018/3/20 21:45
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: generatePrize
     * @Description: 生成奖池
     * @Version:1.0.0
     */
    Result generatePrize(PrizePoolVO prizePoolVO);

    /**
     * @author 刘海洋
     * @date 2018/3/21 11:47
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: checkDate
     * @Description: 检查时间是否是结束时间的后一天
     * @Version:1.0.0
     */
    Result checkDate(PrizePoolDTO prizePoolDTO);

    /**
     * @author 刘海洋
     * @date 2018/3/21 14:31
     * @param {id}
     * @Title: openPrize
     * @Description: 开启奖池
     * @Version:1.0.0
     */
    Result openPrize(PrizePoolDTO prizePoolDTO);

    /**
     * @author 刘海洋
     * @date 2018/3/21 16:27
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: viewPrize
     * @Description: 奖项预览
     * @Version:1.0.0
     */
    Result viewPrize(PrizePoolDTO prizePoolDTO, PageBean pageBean);

    /**
     * @author 刘海洋
     * @date 2018/3/21 17:41
     * @param {lotteryStartTime,lotteryEndTime}
     * @Title: viewPrize
     * @Description: 查看中奖结果
     * @Version:1.0.0
     */
    List<PrizePoolVO> prizeResult(PrizePoolDTO prizePoolDTO);

    /**
     * @author 刘海洋
     * @date 2018/3/29 16:36
     * @param {}
     * @Title: selectOpenStatus
     * @Description: 查询积分比例是否开启
     * @Version:1.0.0
     */
    SystemParameterVO selectOpenStatus();

    /**
     * @author 刘海洋
     * @date 2018/4/20 18:22
     * @param {id}
     * @Title: getLotteryStatus
     * @Description: 查看开间时间是否为系统当前时间
     * @Version:1.0.0
     */
    PrizePoolVO getLotteryStatus(PrizePoolDTO prizePoolDTO);

    /**
     * @author 刘海洋
     * @date 2018/4/26 19:53
     * @param {id,lotteryOpenTime}
     * @Title: checkOpenTime
     * @Description: 检查开奖时间
     * @Version:1.0.0
     */
    Result checkOpenTime(PrizePoolDTO prizePoolDTO);
}
