package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0) return false;
        boolean isFirstMove = color.equals("White") ? line == 1 : line == 6;
        return ((isFirstMove && Math.abs(toLine - line) == 1) || (!isFirstMove && Math.abs(toLine - line) == 1))
               && Math.abs(toColumn - column) == 0;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
