import java.util.ArrayList;
import java.util.Iterator;

public class PrimeGens {
    private static ArrayList primes = new ArrayList();
    private static boolean initalized = false;

    public static int kThPrime(int k){
        if (!initalized){
            initalized = true;
            initalize();
        }

        return (int) primes.get(k);
    }

    public static void initalize(){
        int counter = -1;
        int num = 2;

        while (counter != 500001) {

            if (Primes.isPrime(num) == true) {
                counter++;
                primes.add(num);

            }
            num++;
        }

    }


    public static class TwinPrimes implements Iterator<Integer> {
        private int k = 0; // current position in sequence

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int temp = PrimeGens.kThPrime(k);
                if (Primes.isPrime(temp + 2)) {
                    k++;
                    return temp;
                } else {
                    k++;
                }

            }

        }
    }

    public static class SafePrimes implements Iterator<Integer>{

        private int k = 0; // current position in sequence

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int temp = PrimeGens.kThPrime(k);
                if (Primes.isPrime(2*temp + 1)) {
                    k++;
                    return 2*temp + 1;
                } else {
                    k++;
                }

            }

        }
    }

    public static class StrongPrimes implements Iterator<Integer> {


        private int k = 1; // current position in sequence

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int temp = PrimeGens.kThPrime(k);
                double average = (kThPrime(k - 1) + kThPrime(k + 1)) / 2;
                if (temp > average) {
                    k++;
                    return temp;
                } else {
                    k++;
                }

            }

        }


    }
}

