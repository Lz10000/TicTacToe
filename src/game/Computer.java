package game;

import java.util.Random;

public class Computer implements Strategy{

    @Override
    public void move(Board b){
        Random r = new Random();
        while(true){
            try{
                int low = 1;
                int high = 9;
                int res = r.nextInt(high - low) + low;
                int[] pos = b.convertTo2D(res);
                b.play(pos[0], pos[1], Player.O);
                break;
            }catch(Exception e){
                //ignore
            }
        }
    }
}
