package com.design.mode.behavior.command;

import lombok.extern.slf4j.Slf4j;

/**
 * 股票
 *
 * @author chenpeng
 */
@Slf4j
public class Stock {

    /**
     * 买股票
     */
    public void buy() {
        log.info("买股票");
    }

    /**
     * 卖股票
     */
    public void sell() {
        log.info("卖股票");
    }
}