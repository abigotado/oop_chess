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

        int direction = color.equals("White") ? 1 : -1;

        if (column == toColumn) {
            boolean isFirstMove = color.equals("White") ? line == 1 : line == 6;

            if (isFirstMove && toLine - line == 2 * direction) {
                if (board.board[line + direction][column] == null && board.board[toLine][toColumn] == null) {
                    return true;
                }
            }
            if (toLine - line == direction && board.board[toLine][toColumn] == null) {
                return true;
            }
        }

        if (Math.abs(toColumn - column) == 1 && toLine - line == direction) {
            if (board.board[toLine][toColumn] != null &&
                !board.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
