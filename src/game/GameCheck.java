package game;

public class GameCheck {
    Board board;
    
    public GameCheck(Board b){
        board = b;
    }
    
    public Player checkWinner() {

        if (!(checkRows() == null)) {
            return checkRows();
        } else if (!(checkColumns() == null)) {
            return checkColumns();
        } else if (!(checkDiagonalLeft() == null)) {
            return checkDiagonalLeft();
        } else if (!(checkDiagonalRight() == null)) {
            return checkDiagonalRight();
        }
        return null;
    }
    
    public Player checkDiagonalLeft() {
        Player player = board.getPlayerAt(0, 0);
        
        for (int i = 1; i < board.getBoardLength(); i++) {
            if (board.getPlayerAt(i, i) != player) {
                player = null;
                break;
            }
        }
        return player;
    }

    public Player checkDiagonalRight() {
        Player player= board.getPlayerAt(0, board.getBoardLength()-1);
        
        for (int i = 1; i < board.getBoardLength(); i++) {
            if (board.getPlayerAt(0, board.getBoardLength()-1- i) != player) {
                player = null;
                break;
            }
        }
        return player;
    }

    public Player checkRows() {
        Player player = null;
        for (int row = 0; row < board.getBoardLength(); row++) {
            for (int col = 0; col < board.getBoardLength(); col++) {
                player = board.getPlayerAt(row, 0);
                if (player == null) {
                    break;
                }
                if (board.getPlayerAt(row, col) !=player) {
                    player = null;
                    break;
                } else if (col == board.getBoardLength() - 1) {
                    return player;
                }
            }
        }
        return player;
    }
    
    public Player checkColumns() {
        Player player = null;
        for (int col = 0; col < board.getBoardLength(); col++) {
            for (int row = 0; row < board.getBoardLength(); row++) {
                player = board.getPlayerAt(0, col);
                if (player == null) {
                    break;
                }
                if (board.getPlayerAt(row, col) !=player) {
                    player = null;
                    break;
                } else if (row == board.getBoardLength() - 1) {
                    return player;
                }
            }
        }
        return player;
    }
    
}
