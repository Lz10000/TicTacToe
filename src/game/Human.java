package game;

import java.util.Scanner;

public class Human implements Strategy{
    private final Scanner reader = new Scanner(System.in);

    @Override
    public void move(Board b){
        while(true){
            System.out.println("Your turn, enter a number!");
            try{
                String str = reader.next();
                int n = Integer.parseInt(str);
                int[] pos = b.convertTo2D(n);
                b.play(pos[0], pos[1], Player.X);
                return;
            }catch(Exception e){
                System.out.printf("Bad move, enter a number between 1 and 9.", e.getMessage());
            }
        }
    }
}
