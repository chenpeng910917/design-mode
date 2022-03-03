package com.design.mode.structure.flyweight;

/**
 * 棋子单位 享元模式
 *
 * @author chenpeng
 */
public class ChessPieceUnit {
    /**
     * id
     */
    private int id;
    /**
     * 棋子
     */
    private String text;
    /**
     * 颜色
     */
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    /**
     * 棋子颜色
     */
    public static enum Color {
        /**
         * 红色
         */
        RED,
        /**
         * 黑色
         */
        BLACK
    }
    // ...省略其他属性和getter方法...
}
