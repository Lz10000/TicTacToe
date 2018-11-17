package game;

public class Board {
    
    private final int boardSize;
    private final int boardLength;
    private final Player[][] board;
    private int counter = 0;
    
    public Board(){
        boardLength = 3;
        boardSize = 9;
        board = new Player[boardLength][boardLength];
    }
    
    public Board(int len){
        boardLength = len;
        boardSize = len*len;
        board = new Player[boardLength][boardLength];
    }
    
    public Player getCurrentPlayer(){
        if(counter%2 == 0){
            return Player.X;
        }else{
            return Player.O;
        }
    }
    
    public boolean isOpen(int x, int y) {
        return board[x][y] == null;
    }
    
    public Player getPlayerAt(int row, int col){
        return board[row][col];
    }
    
    public boolean isFull(){
        return counter == boardSize;
    }
    
    public boolean isValid(int row, int col){
        if(row > boardLength-1 || row < 0)
            return false;
        else if(col > boardLength-1 || col < 0)
            return false;
        return true;
    }
    
    public int[] convertTo2D(int val) {
        val = val - 1;
        int[] pos = new int[2];
        int x = val / boardLength;
        int y = val % boardLength;
        pos[0] = x;
        pos[1] = y;
        return pos;
    }
    
    public void play(int row, int col, Player p) throws Exception {
        
        if(!getCurrentPlayer().equals(p)){
            throw new Exception("Wrong player's turn");
        }

        if(!isOpen(row, col)){
           throw new Exception("Spot is not open");
        }
        
        if(!isValid(row, col)){
            throw new Exception("Invalid row and column");
        }

        board[row][col] = p;
        counter++;
    }
    
    public int getBoardLength(){
        return boardLength;
    }
    
    public int getBoardSize(){
        return boardSize;
    }
    
}
