import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P2J9 {

    public static HashMap<Integer,Boolean> hash = new HashMap<>();
    public static boolean initialized = false;

    public static List<Boolean> hotOrCold = new ArrayList<>();
    public static boolean hotOrColdInitializer = false;



    // Create a HashMap with a x b up until positiveNumber
    public static void initializeHashMap(int positiveNumber){

        for (int i = 1; i < positiveNumber; i++){
            for (int j = 1; j < positiveNumber; j++){
                if (i == j){
                    continue;
                }
                else {
                    int n = (int) ((int) Math.pow(i,2) + Math.pow(j,2));
                    hash.put(n,true);
                }
            }
        }
    }

    public static boolean[] sumOfTwoDistinctSquares(int n){
        boolean[] result = new boolean[n];

        if (initialized == false){
            initializeHashMap(1000);
            initialized = true;
        }

        for (int i = 0; i < n; i++){
            if (hash.get(i) == null){
                result[i] = false;
            }
            else {
                result[i] = true;
            }
        }
        return result;
    }



    public static void initializeHotOrCold(int n){

        // 0
        hotOrCold.add(false); //cold == false

        // 1
        hotOrCold.add(true); //hot == true

        boolean skip = false;

        for (int i = 2; i <= n;i++){
            skip = false;

            for (int j = 1; j*j <= i; j++){
                if (hotOrCold.get(i - j*j) == false){
                    skip = true;
                    hotOrCold.add(true);
                    break;
                }
            }

            if (skip == false){
                hotOrCold.add(false);
            }
        }

    }


    public static boolean[] subtractSquare(int n){

        if (!hotOrColdInitializer){
            initializeHotOrCold(100000);
            hotOrColdInitializer = true;
        }


        boolean[] result = new boolean[n];

        for (int i = 0; i < n; i++){
            result[i] = hotOrCold.get(i);
        }


        return result;
    }
}
