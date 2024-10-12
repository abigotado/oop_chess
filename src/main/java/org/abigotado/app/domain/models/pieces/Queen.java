package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        return Math.abs(line - toLine) == Math.abs(column - toColumn) ^ line == toLine ^ column == toColumn;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
