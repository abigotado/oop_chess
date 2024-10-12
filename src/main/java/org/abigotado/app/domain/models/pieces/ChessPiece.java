package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public abstract class ChessPiece {
     String color;
     boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}
