package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7 || (line == toLine && column == toColumn))
            return false; if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            if (check) check = false; return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && board.board[i][j].getColor().equals(color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        } return false;
    }
}
