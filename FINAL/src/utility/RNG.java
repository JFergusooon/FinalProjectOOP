package utility;

import java.util.Random;

public class RNG {
    static Random rng=new Random();
    public static int getRandomInt(int min, int max){
        int random = rng.nextInt((max - min) + 1) + min;
        return random;
    }
}
