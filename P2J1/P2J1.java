import java.util.*;
import java.text.*;

public class P2J1 {

    public static long fallingPower(int n, int k){
        long result;
        if (k == 0){
            result = 1;
            return result;
        }
        else if (k == 1){
            result = n;
            return result;
        }
        else {
            result = n;
            int store = n;
            for (int i=1; i < k; i++){
                store = store - 1;
                result = result * store;
            }
            return result;
        }

    }
    
    public static int[] everyOther(int[] arr){
        int[] result = {};
        int count = 0;
        int value;
        if (arr.length == 0){
            return result;
        }
        else if (arr.length == 1){
            return arr;
        }
        else {
            if (arr.length % 2 == 0) {
                value = arr.length / 2;
            }
            else {
                value = (arr.length / 2);
                value++;
            }
            int[] newResult = new int[value];
            for (int i = 0; i < arr.length; i++){
                if (i % 2 == 0){
                    newResult[count] = arr[i];
                    count++;
                }
            }
            return newResult;
        }
    }
    
    public static int[][] createZigZag (int rows, int cols, int start){
        int row = rows;
        int col = cols;
        boolean subtract = false;

        int [][] arr = new int [row][col];

        for (int i = 0; i < row; i++){
            if (i % 2 == 0){
                for (int j = 0; j < col; j++){
                    arr[i][j] = start;
                    start++;
            }
            }
            else {
                for (int j = col-1;j >= 0; j--){
                    arr[i][j] = start;
                    start++;
                }
            }
        }
        String t = Arrays.deepToString(arr);
        System.out.println(t);
        return arr;
    }
    
    public static int countInversions(int[] arr){
        int count = 0;
        int length = arr.length;
        if (length <= 1) {
            return count;
        }
        else {
            for (int i = 0; i < length; i++){
                for (int j = 0; j <length; j++){
                    if (j > i && arr[i] > arr[j]){
                        count++;
                    }

                }
            }
        }
        return count;
    }

    public static void main (String[] args){
    }

}