public class Main {

    public static void main(String[] args) {
        int[] c1 = {-10, 99, 11, 12};
        int[] c2 = {-10, 99, 11, 12};
        int[] c3 = {-10, 99, 11, 12,0,0,0};
        Polynomial p1 = new Polynomial(c1);
        Polynomial p2 = new Polynomial(c2);
        Polynomial p3 = new Polynomial(c3);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());


    }




}
