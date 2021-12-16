import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RationalRoots {

    public static Fraction evaluate(int[] coefficients, Fraction x){
        Fraction store = x;

        Fraction sum = new Fraction(coefficients[0]);
        for (int i = 1; i < coefficients.length; i++){
            x = store;
            if (coefficients[i] == 0){
                continue;
            }

            Fraction tempCoefficient = new Fraction(coefficients[i]);

            for (int k = 1; k < i; k++){
                x = x.multiply(store);
            }

            sum = sum.add(x.multiply(tempCoefficient));
        }

        return sum;
    }

    public static List<Fraction> rationalRoots(int[] coefficients){



        // get the highest degree coefficent number
        int highestCoef = coefficients[coefficients.length -1];

        // get the lowest degree coefficient number
        int lowestCoef = coefficients[0];

        // create array lists for both
        List<Integer> primesOfHighestCoef = factorize(highestCoef);
        List<Integer> primesOfLowestCoef = factorize(lowestCoef);
        if (highestCoef > 0){
            primesOfHighestCoef = factorize(highestCoef);
        }
        else {
            primesOfHighestCoef = factorize(highestCoef * -1);
        }

        if (lowestCoef > 0){
            primesOfLowestCoef = factorize(lowestCoef);
        }
        else {
            primesOfLowestCoef = factorize(lowestCoef * -1);
        }


        // loop through possible rational numbers
        List<Fraction> result = new ArrayList<>();

//        System.out.println("Highest Coef: " + highestCoef);
//        System.out.println("Lowest Coef" + lowestCoef);
//        System.out.println("Factors of Highest Coef: " + primesOfHighestCoef);
//        System.out.println("Factors of Lowest Coef " + primesOfLowestCoef);


        for (int i = 0; i < primesOfLowestCoef.size(); i++){
            //System.out.println("i: " + i);
            //System.out.println("value: " + primesOfLowestCoef.get(i));
            for (int j = 0; j < primesOfHighestCoef.size(); j++){
                //System.out.println("j: " + j);
                //System.out.println("value: " + primesOfHighestCoef.get(j));

                Fraction temp = new Fraction(primesOfLowestCoef.get(i),primesOfHighestCoef.get(j));


                if (evaluate(coefficients,temp).toString() == "0"){
                    result.add(temp);
                }
                Fraction Negativetemp = new Fraction(-primesOfLowestCoef.get(i),primesOfHighestCoef.get(j));
                if (evaluate(coefficients,Negativetemp).toString() == "0"){
                    result.add(Negativetemp);
                }
            }
        }

        HashSet result1 = new HashSet(result);



        result = new ArrayList<Fraction>(result1);




        List<Fraction> resultFinal = new ArrayList<>();
        int length = result.size();


        // sort in accending order:
        for (int i = 0; i < length; i++){
            Fraction lowest = result.get(0);
            for (int j = 0; j < result.size(); j++){

                if (lowest.compareTo(result.get(j))== 1){
                    lowest = result.get(j);
                }

                if (j == result.size() - 1){
                    resultFinal.add(lowest);
                    result.remove(lowest);
                }


            }

        }

        System.out.println(resultFinal);
        return resultFinal;
    }

    public static List<Integer> factorize ( int n){
        List<Integer> factors = new ArrayList<Integer>();
        factors.add(1);

        if (n == 1 || n == 0){
            return factors;
        }
        factors.add(n);

        if (n == 2){
            return factors;
        }

        int i = 2;

        int upperLimit = n /2 + 1;

        while(upperLimit >= i ){



            if (n % i == 0){
                factors.add(i);
                i++;
            }
            else {
                i++;
            }
        }
        Collections.sort(factors);
        return factors;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 58, -1349, 16186, -107315, 390238, -716167, 510510};
        rationalRoots(arr);

    }
}


