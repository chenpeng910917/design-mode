package com.design.mode.behavior.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 经纪人
 *
 * @author chenpeng
 */
public class Broker {

    private final List<Order> orderList = Lists.newArrayList();

    /**
     * 接受命令
     */
    public void takeOrder(Order order) {
        orderList.add(order);
    }

    /**
     * 执行命令
     */
    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
    }
}
