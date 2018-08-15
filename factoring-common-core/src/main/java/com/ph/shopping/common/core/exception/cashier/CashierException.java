package com.ph.shopping.common.core.exception.cashier;

import com.ph.shopping.common.core.customenum.CashierEnum;
import com.ph.shopping.common.core.exception.BizException;

/**
 * @author : tenghui
 * @description ：支付异常
 * @Creation Date ： 2018/4/11 12:36
 */
public class CashierException extends BizException {

    public CashierException() {
    }

    public CashierException(String message) {
        super(message);
    }

    public CashierException(CashierEnum cashierEnum) {
        super(cashierEnum.getMsg(), cashierEnum.getCode());

    }
}
