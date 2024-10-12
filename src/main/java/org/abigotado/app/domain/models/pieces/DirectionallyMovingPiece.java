package org.abigotado.app.domain.models.pieces;

import org.abigotado.app.domain.models.ChessBoard;

public abstract class DirectionallyMovingPiece extends ChessPiece {

    public DirectionallyMovingPiece(String color) {
        super(color);
    }

    public boolean canMoveDiagonally(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int lineStep = (toLine - line) > 0 ? 1 : -1;
        int columnStep = (toColumn - column) > 0 ? 1 : -1;

        int currentLine = line + lineStep;
        int currentColumn = column + columnStep;

        while (currentLine != toLine && currentColumn != toColumn) {
            if (board.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += lineStep;
            currentColumn += columnStep;
        }

        return true;
    }

    public boolean canMoveDirectly(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (line == toLine) {
            int columnStep = (toColumn - column) > 0 ? 1 : -1;
            for (int currentColumn = column + columnStep; currentColumn != toColumn; currentColumn += columnStep) {
                if (board.board[line][currentColumn] != null) {
                    return false;
                }
            }
        }
        else {
            int lineStep = (toLine - line) > 0 ? 1 : -1;
            for (int currentLine = line + lineStep; currentLine != toLine; currentLine += lineStep) {
                if (board.board[currentLine][column] != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
