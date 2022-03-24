package com.design.pattern.structure.adapter.payment;

import com.design.pattern.structure.adapter.PayTypeEnum;
import com.design.pattern.structure.adapter.adapter.AliPayAdapter;
import com.design.pattern.structure.adapter.adapter.PayAdapter;
import com.design.pattern.structure.adapter.adapter.WeChatPayAdapter;

/**
 * 支付工厂
 *
 * @author chenpeng
 */
public class PayFactory {

    public static PayAdapter getPay(Integer type) {
        if (PayTypeEnum.ALI.getType().equals(type)) {
            return new AliPayAdapter();
        } else if (PayTypeEnum.WECHAT.getType().equals(type)) {
            return new WeChatPayAdapter();
        } else {
            throw new IllegalArgumentException("不存在的支付类型");
        }
    }
}
