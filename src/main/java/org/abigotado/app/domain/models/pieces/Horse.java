package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        return (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) || (
                Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2
        );
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
