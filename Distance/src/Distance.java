import java.util.*;

public class Distance {
    private int a2;
    private int b2;

    private TreeMap<Integer,Integer> coeff = new TreeMap<Integer,Integer>();

    public static int extractSquares(int n){
        //System.out.println(n);
        int highestDivisor = 1;
        for (int i = 2; Math.pow(i,2) <= n; i++){
            if (n % Math.pow(i,2) == 0){
                highestDivisor = i;
            }
            else {
                continue;
            }
        }
        //System.out.println(highestDivisor);
        return highestDivisor;
    }

    public Distance (int a, int b){

        // Simplification 1)
        if (a != 0){
            while(true){
                int divisor = extractSquares(b);
                if (divisor == 1){
                    break;
                }
                else {
                    a *= divisor;
                    b /= Math.pow(divisor,2);
                }
            }
        }
        // Defensive Copy 2)
        TreeMap<Integer,Integer> coeff2 = new TreeMap<Integer,Integer>();
        coeff2.put(b,a);
        this.coeff = coeff2;
    }

    public Distance(Map<Integer,Integer> coeff){
        // Defensive Copy - result:
        TreeMap <Integer, Integer> result = new TreeMap<Integer,Integer>();
        // Iterate through each K V entry in coeff:
        for (Map.Entry<Integer,Integer> entry: coeff.entrySet()){
            // b = a: key = value
            int distanceB = entry.getKey();
            int distanceA = entry.getValue();
            int highestDivisor;
            highestDivisor =  extractSquares(distanceB);

            /////
            int newDistanceB = distanceB;
            int newDistanceA = distanceA;
            if (highestDivisor > 1){
                newDistanceB = (int) (distanceB / Math.pow(highestDivisor,2));
                newDistanceA = (distanceA * highestDivisor);
            }
            ////

            if(result.containsKey(newDistanceB)){
                result.put(newDistanceB, result.get(newDistanceB)+newDistanceA);
            }else{
                result.put(newDistanceB, newDistanceA);
            }
        }
        this.coeff = result;
    }


    @Override
    public String toString(){
        StringBuilder foo = new StringBuilder();
        int counter = 0;
        String result;

        for (Map.Entry<Integer,Integer> entry: this.coeff.entrySet()){
            StringBuilder zoo = new StringBuilder();
            int distanceA = entry.getValue();
            int distanceB = entry.getKey();
            int absDistanceA = Math.abs(distanceA);
            String positiveOrNegative = "";


            // determining the sign:
            if(distanceA<0 && counter ==0){
                positiveOrNegative = "-";
            }
            else if(distanceA<0 && counter>0){
                positiveOrNegative = " - ";
            }
            else if(distanceA > 0 && counter>0){
                positiveOrNegative = " + ";
            }


            // determining the structure:
            if (absDistanceA == 1 && distanceB == 1){
                zoo.append(1);
            }
            else if(absDistanceA==1 && distanceB!=1){
                zoo.append("Sqrt[").append(distanceB).append("]");
            }
            else if (absDistanceA!= 1 && distanceB==1){
                zoo.append(absDistanceA);
            }
            else if(absDistanceA == 0 || distanceB ==0){
                zoo.append(0);
            }
            else if(absDistanceA!=1 && distanceB!=1){
                zoo.append(absDistanceA).append("Sqrt[").append(distanceB).append("]");}

            // end of loop tasks:
            counter++;
            foo.append(positiveOrNegative);
            foo.append(zoo.toString());
            }
        int sumOfProducts = 0;

        for (Map.Entry<Integer,Integer> entry: this.coeff.entrySet()){
            int distanceA = entry.getValue();
            int distanceB = entry.getKey();
            sumOfProducts += Math.abs(distanceA*distanceB);
        }
        if (sumOfProducts != 0){
            result = foo.toString();
        }
        else {
            result = "0";
        }
        return result;

    }
    
}
