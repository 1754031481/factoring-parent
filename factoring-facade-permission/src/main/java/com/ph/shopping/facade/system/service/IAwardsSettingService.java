package com.ph.shopping.facade.system.service;

import com.ph.shopping.common.util.result.Result;
import com.ph.shopping.facade.system.dto.LotteryAdminDTO;

/**
 * @author 荐家跃
 * @Title: IAwardsSettingService
 * @Description: 奖项设置service接口
 * @date 2018/3/20 10:44
 * @Version:1.0.0
 */
public interface IAwardsSettingService {
    /**
     * @param
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: awardsList
     * @Description: 获取奖项列表
     * @Version:1.0.0
     */
    Result awardsList();
    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: addAwards
     * @Description: 添加奖项
     * @Version:1.0.0
     */
    Result addAwards(LotteryAdminDTO lotteryAdminDTO);
    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: deleteAwards
     * @Description: 删除奖项
     * @Version:1.0.0
     */
    Result deleteAwards(LotteryAdminDTO lotteryAdminDTO);
    /**
     * @param lotteryAdminDTO
     * @author 荐家跃
     * @date 2018/3/20 18:20
     * @Title: updateAwards
     * @Description: 修改奖项
     * @Version:1.0.0
     */
    Result updateAwards(LotteryAdminDTO lotteryAdminDTO);
    /**
     * @author 荐家跃
     * @date 2018/3/20 22:09
     * @param id
     * @Title: findAwardsById
     * @Description: 通过id查询奖项
     * @Version:1.0.0
     */
    Result findAwardsById(Long id);

    /**
     * @author 荐家跃
     * @date 2018/3/22 11:24
     * @param
     * @Title: getAwardsList
     * @Description: 获取奖项数据
     * @Version:1.0.0
     */
    Result getAwardsList();
}
