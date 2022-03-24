package com.design.pattern.structure.flyweight;

/**
 * 棋子
 *
 * @author chenpeng
 */
public class ChessPiece {
    /**
     * 棋子单位
     */
    private ChessPieceUnit chessPieceUnit;
    /**
     * 位置X
     */
    private int positionX;
    /**
     * 位置Y
     */
    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    // 省略getter、setter方法
}
