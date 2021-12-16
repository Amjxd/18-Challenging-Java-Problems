import java.util.*;

public class P2J3 {

    public static void reverseAscendingSubarrays(int[] items) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        int start = 0;
        boolean allow = true;
        int iterValue = 0;


        temp.add(items[0]);
        for (int i = 1; i < items.length; i++) {

            if (items[current] < items[i]) {
                if (temp.size() == 0) {
                    temp.add(items[current]);
                    temp.add(items[i]);
                    current++;
                } else {
                    temp.add(items[i]);
                    current++;
                }
            } else if (temp.size() == 0) {
                current++;
                start = current;

            } else {
                if (temp.size() > 0) {
                    Collections.reverse(temp);

                    for (int j = start; j < current + 1; j++) {
                        items[j] = temp.get(iterValue);
                        iterValue++;
                    }
                    current++;
                    start = current;
                    temp.clear();
                    iterValue = 0;


                }
            }

            if (i == items.length - 1 && temp.size() > 0) {
                Collections.reverse(temp);

                for (int j = start; j < current + 1; j++) {
                    items[j] = temp.get(iterValue);
                    iterValue++;

                }


            }


            System.out.println(Arrays.toString(items));

        }

    }

    public static String pancakeScramble(String text){


        // add exception for size == 1 or 2 only
        String str = new StringBuilder(text).reverse().toString();
        String pancaked = "";


        for (int i = 0; i < text.length(); i++){
            char t = text.charAt(i);
            pancaked += t;

            if (i >= 1){
                pancaked = new StringBuilder(pancaked).reverse().toString();
            }
        }
        return pancaked;
    }

    public static String reverseVowels (String text){
        ArrayList<Character> temp = new ArrayList<Character>();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++){
            char t = text.charAt(i);
            if (vowels.indexOf(t) != -1){
                t = Character.toLowerCase(t);
                temp.add(t);
            }
        }

        Collections.reverse(temp);

        String reversed = "";

        int vowelsViewed = 0;

        for (int i = 0; i < text.length(); i++){
            char t = text.charAt(i);
            if (vowels.indexOf(t) != -1){
                if (Character.isLowerCase(t) == false){
                    t = Character.toUpperCase(temp.get(vowelsViewed));
                    reversed += t;
                    vowelsViewed++;
                }
                else {
                    t = temp.get(vowelsViewed);
                    reversed += t;
                    vowelsViewed++;
                }
            }
            else {
                reversed += t;
            }
        }

        return reversed;
    }


    public static void main (String[] args){
    }

}
