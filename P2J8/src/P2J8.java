import java.math.*;

public class P2J8 {
    private static final BigInteger ZERO = new BigInteger("0");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger FOUR = new BigInteger("4");
    private static final BigInteger TEN = new BigInteger("10");



    public static BigInteger sgonalNumber(int s, BigInteger counter){
        BigInteger S = BigInteger.valueOf(s);
        BigInteger temp = (S.subtract(TWO)).multiply(counter.multiply(counter));
        BigInteger sub = (S.subtract(FOUR)).multiply(counter);
        temp = (temp.subtract(sub)).divide(TWO);
        return temp;
    }



    public static BigInteger nearestPolygonalNumber(BigInteger n, int s) {
        BigInteger b = BigInteger.valueOf(1);

        while (true){
            BigInteger temp = sgonalNumber(s,b);
            if (n.compareTo(temp) != -1){
                b = b.multiply(TEN);
            }
            else {
                break;
            }
        }
        BigInteger a = b.divide(TEN);


        while (a.compareTo(b) < 0) {

            BigInteger m = (a.add(b)).divide(TWO);


            if (sgonalNumber(s,m).compareTo(n) == 0){
                //System.out.println(sgonalNumber(s,m));
                return sgonalNumber(s,m);
            }
            else if (sgonalNumber(s,m).compareTo(n) == -1) {
                a = m.add(ONE);
            }
            else {
                b = m;
            }
        }
        a = a.subtract(ONE);

       // System.out.println(sgonalNumber(s,a));
        //System.out.println(sgonalNumber(s,b));




        if (n.subtract(sgonalNumber(s,a)).compareTo(sgonalNumber(s,b).subtract(n)) == 0){
            //System.out.println(sgonalNumber(s,a));
            return sgonalNumber(s,a);
        }
        else if (n.subtract(sgonalNumber(s,a)).compareTo(sgonalNumber(s,b).subtract(n)) == -1){
            return sgonalNumber(s,a);
        }
        else {
            //System.out.println(sgonalNumber(s,b));
            return sgonalNumber(s,b);
        }

    }


    public static void hittingIntegerPowers(int a,int b, int t, int[] out){
        // Big Integer a, b, t, copies of a and b
        // will be used as final values (will not be changed)
        BigInteger aBig = BigInteger.valueOf(a);
        BigInteger bBig = BigInteger.valueOf(b);
        BigInteger tBig = BigInteger.valueOf(t);


        BigInteger aCopy = BigInteger.valueOf(a);
        BigInteger bCopy = BigInteger.valueOf(b);

        // powers that will be returned in out[]
        int pa = 1;
        int pb = 1;

        // loop to find the right values of pa & pb
        while(true){
            // absolute difference between a and b * tolerance
            BigInteger difference = (aCopy.subtract(bCopy).abs().multiply(tBig));

            //if difference is less than or equal to  values a or b:
            if (difference.compareTo(aCopy) <= 0 || difference.compareTo(bCopy) <= 0){
                //System.out.println(pa);
                //System.out.println(pb);

                out[0] = pa;
                out[1] = pb;
                break;
            }

            else {
                // if value a is less than or equal to value b:
                if (aCopy.compareTo(bCopy) <= 0){
                    aCopy = aCopy.multiply(aBig);
                    pa += 1;
                }
                else {
                    bCopy = bCopy.multiply(bBig);
                    pb += 1;
                }

            }

        }

    }
}


