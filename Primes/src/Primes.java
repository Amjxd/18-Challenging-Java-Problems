import java.util.*;

public class Primes {

    private static ArrayList primes = new ArrayList();
    private static boolean initialized = false;
    private static  ArrayList primeFactorization = new ArrayList();
    private static int divisor = 2;



    // Primes - positive integers that are exactly divisible by only one and themselves



    public static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        int wall = (int)Math.sqrt(n);

        for (int i = 2;i <= wall;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int kthPrime(int k){
        if (!initialized){
            initialized = true;
            initalize();
        }

        return (int) primes.get(k);
    }

    public static void initalize(){
        int counter = -1;
        int num = 2;

        while (counter != 50001) {

            if (isPrime(num) == true) {
                counter++;
                primes.add(num);

            }
            num++;
        }

    }

    public static List<Integer> factorize ( int n){
        if (initialized == false){
            initalize();
            initialized = true;
        }
        primeFactorization.clear();
        int i = 0;



        while(n != 1){

            int divisor = (int) primes.get(i);

            if (n % divisor == 0){
                primeFactorization.add(divisor);
                n = n / divisor;
                i = 0;
            }
            else {
                i++;
            }
        }


        return primeFactorization;
    }

}