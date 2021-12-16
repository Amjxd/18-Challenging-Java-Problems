public class P2J10
{

    private static int[][] helperMethod(boolean[] v1, boolean[] v2){
        int[][] result = new int[2][2];

        // n00 - number of "false" in both arrays:
        result[0][0] = 0;
        // n01 - count of v1's false && v2's true
        result[0][1] = 0;
        // n10 - count of v1's true && v2's false
        result[1][0] = 0;
        // n11 -  number of "true" in both arrays:
        result[1][1] = 0;


        for (int i = 0; i < v2.length; i++){

            // both false:
            if (v1[i] == false && v2[i] == false){
                result[0][0]++;
            }

            // v1 false && v2 true
            else if (v1[i] == false && v2[i] == true){
                result[0][1]++;
            }

            // both true:
            else if (v1[i] == true && v2[i] == false){
                result[1][0]++;
            }

            // v1 true && v2 false
            else {
                result[1][1]++;
            }
        }

        return result;
    }

    public static Fraction matchingDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(temp[1][0] + temp[0][1],v1.length);
    }

    public static Fraction jaccardDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(temp[1][0] + temp[0][1],temp[1][1]+ temp[1][0] + temp[0][1]);

    }

    public static Fraction diceDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(temp[1][0] + temp[0][1],2*temp[1][1] + temp[1][0] + temp[0][1]);

    }

    public static Fraction rogersTanimonoDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(2*(temp[1][0] + temp[0][1]),temp[1][1] + 2*(temp[1][0]+temp[0][1]) + temp[0][0]);

    }

    public static Fraction russellRaoDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(temp[1][0] + temp[0][1] + temp[0][0],v1.length);

    }

    public static Fraction sokalSneathDissimilarity(boolean[] v1, boolean[] v2){
        int[][] temp = helperMethod(v1,v2);
        return new Fraction(2*(temp[1][0] + temp[0][1]),temp[1][1] + 2*(temp[1][0]+temp[0][1]));

    }

}