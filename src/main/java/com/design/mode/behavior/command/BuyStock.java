package com.design.mode.behavior.command;

/**
 * 买股票
 *
 * @author chenpeng
 */
public class BuyStock implements Order {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
