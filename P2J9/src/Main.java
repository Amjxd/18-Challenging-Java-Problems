public class Main {

    public static void main(String[] args) {

        P2J9.initializeHotOrCold(100);

        for (int i = 0; i <= 30; i++){
            if (!P2J9.hotOrCold.get(i)){
            System.out.println(i +"---" + P2J9.hotOrCold.get(i));}
        }

    }
}
