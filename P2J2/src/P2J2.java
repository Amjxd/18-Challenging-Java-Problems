import java.util.*;

public class P2J2 {


    public static String removeDuplicates(String text) {
        int textLength = text.length();
        if (textLength == 0) {
            return "";
        }
        String result = "";
        char start = text.charAt(0);
        result += start;

        for (int i = 1; i < textLength; i++){

            if (start != text.charAt(i)){
                result += text.charAt(i);
                start = text.charAt(i);
            }
        }
        return result;
    }

    public static String uniqueCharacters(String text){
        String result = "";
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < text.length(); i++){
            if (!seen.contains(text.charAt(i))){
                result += text.charAt(i);
                seen.add((char) text.charAt(i));
            }
        }
        return result;
    }



    public static int countSafeSquaresRooks(int n, boolean [][] rooks){

        int total = n*n;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (rooks[i][j] == true){
                    row.add(i);
                    col.add(j);
                }

            }
        }
        return total - (((row.size()) * n) + ((n - row.size()) * col.size()));
    }

    public static int recaman(int n) {
        int hop = 1;
        boolean[] used = new boolean[10*n];
        int i = 0;
        int number = 0;
        used[0] = true;
        while (i < n){
            if (number - hop > 0 && used[number - hop] == false){
                number -= hop;
                used[number] = true;
            }
            else {
                number += hop;
                used[number] = true;
            }
            hop++;
            i++;
        }
        return number;
    }

}