import java.math.BigInteger;
import java.util.*;
public class P2J5
{

    // Big Integer Constants:
    private final static BigInteger SEVEN = BigInteger.valueOf(7);
    private final static BigInteger TEN = BigInteger.valueOf(10);
    private final static BigInteger ZERO= BigInteger.valueOf(0);
    private final static BigInteger ONE= BigInteger.valueOf(0);


    // Fib Sequence HashMap:
    public static HashMap<Integer,BigInteger> fibSeq = new HashMap<>();
    private static boolean initializer = false;




    public static BigInteger sevenZero(int n){
        BigInteger nArgument = new BigInteger((Integer.toString(n)));
        BigInteger result = new BigInteger("7");


        // check if n == 0
        if (n == 0){
            return ZERO;
        }

        // check if divisible by lowest num of digits:
        if (7 % n == 0){
            return SEVEN;
        }


        int numberOfDigits = 1;

        while(true){

            //LOOP Tasks
            numberOfDigits++;
            result = SEVEN;
            int zeroes = numberOfDigits - 1; // number of zeroes needed to begin
            result = result.multiply(TEN.pow(zeroes));
            //

            // Check if the 7-0 combo is it:
            if (result.mod(nArgument) == ZERO){
                return result;
            }
            else { // begin the inner loop to create all possible combinations:
                for (int i = 2; i <= numberOfDigits; i++){
                    int position = numberOfDigits - i;
                    result = result.add(TEN.pow(position).multiply(SEVEN));


                    if (result.mod(nArgument) == ZERO){
                        return result;
                    }
                    else {
                        continue;
                    }
                }
            }
        }
    }

    // construct a fibonnaci number hash map:
    public static void fibonacciSequence(int n){

        fibSeq.put(1,ONE);


        fibSeq.put(0,ZERO);


        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);


        int counter = 1;
        while(counter!=n){
            counter++;
            sum = a.add(b);
            a = b;
            b = sum;

            fibSeq.put(counter,sum);
        }
    }



    public static List<BigInteger> fibonacciSum(BigInteger n){
        if (initializer == false){
            fibonacciSequence(300);
            initializer = true;
        }


        List<BigInteger> values = new ArrayList<>();
        int counter = 1;



        while (n.compareTo(ZERO) != 0){
            //System.out.println(n);
            counter = 1;

            while(true){

                if (fibSeq.get(counter).compareTo(n) == -1){
                    counter++;
                    continue;
                }
                else if (fibSeq.get(counter).compareTo(n) == 0){
                    values.add(fibSeq.get(counter));
                    n = n.subtract(fibSeq.get(counter));
                    break;
                }

                else {
                    //System.out.println(fibSeq.get(counter - 1));
                    values.add(fibSeq.get(counter-1));
                    n = n.subtract(fibSeq.get(counter-1));
                    break;
                }
            }
        }

        return values;

    }

}