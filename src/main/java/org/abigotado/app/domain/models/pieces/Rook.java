package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public class Rook extends DirectionallyMovingPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        if (line == toLine ^ column == toColumn) {
            if (canMoveDirectly(board, line, column, toLine, toColumn)) {
                if (check) check = false; return true;
            }
        } return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
