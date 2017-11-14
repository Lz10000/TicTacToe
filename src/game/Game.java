package game;

import java.util.StringJoiner;


public class Game { 
    
    public Game(){
    }

    public void start() {
        Board board = new Board();
        GameCheck gc = new GameCheck(board);
        Strategy playerX = new Human();
        Strategy playerO = new Computer();
        
        System.out.println("[Tic Tac Toe Game]");
        while (gc.checkWinner() == null && !board.isFull()) {
            printBoard(board);
                if(board.getCurrentPlayer().equals(Player.X)){
                    playerX.move(board);
                } else {
                    playerO.move(board);
                }
                System.out.println("");
        }

        printBoard(board);
        
        if (!(gc.checkWinner() == null)) {
            System.out.print("Player " + gc.checkWinner().toString() + " has won");
        } else if (board.isFull()) {
            System.out.print("Game over, it's a tie!");
        }
    }

     public void printBoard(Board board) {
        String lineSplit = "";
        StringJoiner horizontal = new StringJoiner("|", "|", "|");

        for (int index = 0; index < board.getBoardLength(); index++) {
            horizontal.add(String.format("%4s", "").replace(" ", "-"));
        }

        lineSplit = horizontal.toString();
        for (int row = 0; row < board.getBoardLength(); row++) {
            StringJoiner vertical = new StringJoiner(" | ", "| ", " |");
            for (int col = 0; col < board.getBoardLength(); col++) {
                vertical.add(String.format("%2s", playerToChar(board.getPlayerAt(row, col))));
            }
            System.out.println(lineSplit);
            System.out.println(vertical);
        }
        System.out.println(lineSplit);
    }
    
    static private char playerToChar(Player p) {
        if (p == null) {
            return ' ';
        } else {
            return p.toString().charAt(0);
        }
    }

}
