package com.design.mode.creation.factory.mobile.role;

import com.design.mode.creation.factory.mobile.product.Mobile;

/**
 * 用户角色
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class User {

    /**
     * 用户打电话
     * @param mobile 手机对象
     */
    public void doCall(Mobile mobile) {
        System.out.println("使用" + mobile.getBrand() + "拨打电话");
        mobile.call();
    }

}
