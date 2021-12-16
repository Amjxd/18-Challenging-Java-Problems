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

    public static void initalize(){
        int counter = -1;
        int num = 2;

        while (counter != 30000) {

            if (isPrime(num) == true) {
                counter++;
                primes.add(num);

            }
            num++;
        }

    }

    public static int kthPrime(int k) {


        if (initialized == false){
            initalize();
            initialized = true;
        }

        if (k <= 30000) {
            return (int) primes.get(k);

        } else {

            int counter = -1;
            int num = 2;

            while (counter != k) {

                if (isPrime(num) == true) {
                    counter++;
                }
                num++;
            }
            return num;
        }
    }

    public static List<Integer> factorize ( int n){
        primeFactorization.clear();
        divisor = 2;


        while(n != 1){

            if (n % 2 != 0 && divisor % 2 == 0){
                divisor++;
                continue;
            }

            while (n % divisor == 0){
                primeFactorization.add(divisor);
                n = n / divisor;
            }
            divisor++;
        }


        return primeFactorization;
    }

}
