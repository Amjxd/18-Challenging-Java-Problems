import java.util.*;
public class Polynomial implements Comparable<Polynomial> {
    private int[] coefficients;
    private int redundantZeros;

    @Override
    public String toString() {
        return super.toString();
    }

    // Constructor:
    public Polynomial (int[] coefficients){
        int redundantZeros = 0;

        for (int i = 0; i < coefficients.length; i++){

            if (coefficients[i] == 0){
                redundantZeros++;
            }
            else {
                redundantZeros = 0;
            }
        }

        // create a defensive copy
        this.coefficients = Arrays.copyOf(coefficients,coefficients.length);
        this.redundantZeros = redundantZeros;
    }

    public int getDegree(){
        if (redundantZeros == coefficients.length){
            return 0;
        }
        else {
            return coefficients.length - 1 - redundantZeros;}
    }

    public int getCoefficient(int k){
        if (k < 0 || k > getDegree()){
            return 0;
        }
        else {
            return coefficients[k];
        }
    }

    public long evaluate(int x){
        int sum = coefficients[0];
        for (int i = 1; i < coefficients.length; i++){

            sum += (int) (Math.pow(x,i) * coefficients[i]);
            //System.out.println(sum);
        }
        return sum;
    }

    public Polynomial add(Polynomial other){
        int size = 0;
        int smallerSize = 0;
        int[] result;
        boolean thisSmaller = false;
        boolean otherSmaller = false;

        //System.out.println(Arrays.toString(this.coefficients));
        //System.out.println(Arrays.toString(other.coefficients));
        //System.out.println(" ");



        // establish array length
        if (this.getDegree() >= other.getDegree()){
            result = new int [this.getDegree() + 1];
            size = result.length;
            smallerSize  = other.getDegree() + 1;
            otherSmaller = true;
        }
        else {
            result = new int [other.getDegree() + 1];
            size = result.length;
            smallerSize  = this.getDegree() + 1;
            thisSmaller = true;
        }

        // perform addition
        for (int i = 0; i < size;i++){

            if (i >= smallerSize){
                if (thisSmaller){
                    result[i] = other.coefficients[i];}

                else {
                    result[i] = this.coefficients[i];
                }
            }

            else {
                int value = this.coefficients[i] + other.coefficients[i];
                result[i] = value;
            }
        }

        Polynomial result1 = new Polynomial(result);

        //System.out.println(Arrays.toString(result1.coefficients));
        return result1;

    }



    public Polynomial multiply(Polynomial other){
        int[] result;
        //System.out.println(Arrays.toString(this.coefficients));
        //System.out.println(Arrays.toString(other.coefficients));
        //System.out.println(" ");

        // determine result coeffecients length:
        if (this.getDegree() >= 1 && other.getDegree() >= 1){
            int resultLength = this.getDegree() + other.getDegree() + 1;
            result = new int [resultLength];
        }
        else if (this.getDegree() == 0 && other.getDegree() == 0) {
            result = new int [1];
        }

        else {
            if (this.getDegree() >= other.getDegree()){
                result = new int [this.getDegree() + 1];
            }
            else {
                result = new int [other.getDegree() + 1];
            }
        }

        // perform operations:
        for (int i = 0; i < this.getDegree() + 1; i++){
            for (int j = 0; j < other.getDegree() + 1; j++){
                int position = i + j;
                int item = this.coefficients[i] * other.coefficients[j];
                item = result[position] + item;
                result[position] = item;
            }
        }

        Polynomial result1 = new Polynomial(result);
        return result1;

    }

    @Override
    public int compareTo(Polynomial other) {
        if (this.getDegree() > other.getDegree()){
            return 1;
        }
        else if (other.getDegree() > this.getDegree()){
            return -1;
        }
        else {
            int highestDegree = this.getDegree();

            for (int i = highestDegree; i != -1; i--){
                if (this.coefficients[i] > other.coefficients[i]){
                    return 1;
                }
                else if ( this.coefficients[i] < other.coefficients[i]){
                    return -1;
                }
                else{
                    continue;
                }

            }
            return 0;
        }
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Polynomial){

            Polynomial other2 = (Polynomial) other;
            if (this.getDegree() > other2.getDegree()){
                return false;
            }
            else if (other2.getDegree() > this.getDegree()){
                return false;
            }
            else {
                int highestDegree = this.getDegree();
                for (int i = highestDegree; i != 0; i--){
                    if (this.coefficients[i] == other2.coefficients[i]){
                        continue;
                    }
                    else {
                        return false;
                    }


                }
                return true;
            }
        }
        return false;


    }


    @Override public int hashCode(){
        int[] values = new int [this.getDegree() + 1];

        for (int i = 0; i < getDegree() + 1; i++){
            values[i] = this.coefficients[i];
        }

        //System.out.println(Arrays.toString(values));

        return Objects.hash(Arrays.hashCode(values));
    }




}







