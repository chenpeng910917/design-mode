package com.design.pattern.behavior.command;

/**
 * 卖股票
 *
 * @author chenpeng
 */
public class SellStock implements Order {

    private Stock stock;

    public SellStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
