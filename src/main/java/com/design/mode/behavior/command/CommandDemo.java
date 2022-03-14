package com.design.mode.behavior.command;

/**
 * 命令模式例子
 *
 * @author chenpeng
 */
public class CommandDemo {

    public static void main(String[] args) {
        // 股票
        Stock stock = new Stock();
        // 买股票
        BuyStock buyStock = new BuyStock(stock);
        // 卖股票
        SellStock sellStock = new SellStock(stock);
        // 经纪人
        Broker broker = new Broker();
        // 经纪人接受命令
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        // 经纪人执行
        broker.placeOrders();
    }
}
