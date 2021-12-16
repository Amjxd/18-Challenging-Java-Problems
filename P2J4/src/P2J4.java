import java.util.*;

public class P2J4 {


    public static List<Integer> runningMedianOfThree(List<Integer> items){
        //System.out.println(items);

        if (items.size() == 1 || items.size() == 0 || items.size() == 2){
            System.out.println(items);;
            return items;
        }

        //ArrayList with first 2 elements
        ArrayList<Integer> scrambled = new ArrayList<Integer>();
        scrambled.add(items.get(0));
        scrambled.add(items.get(1));


        int middle = 1;
        int first = 0;

        for (int i = 2;i < items.size();i++){
            // if first of three is the median 1/2
            if (items.get(first) > items.get(middle) && items.get(first) < items.get(i)){
                scrambled.add(items.get(first));
            }

            // 2/2
            else if (items.get(first) > items.get(i) && items.get(first) < items.get(middle)){
                scrambled.add(items.get(first));
            }

            // if second of three is the median 1/2
            else if (items.get(middle) > items.get(first) && items.get(middle) < items.get(i)){
                scrambled.add(items.get(middle));
            }

            // 2/2
            else if (items.get(middle) > items.get(i) && items.get(middle) < items.get(first)){
                scrambled.add(items.get(middle));
            }

            // if third of three is the median 1/2
            else if (items.get(i) > items.get(first) && items.get(i) < items.get(middle)){
                scrambled.add(items.get(i));
            }
            // 2/2
            else if (items.get(i) > items.get(middle) && items.get(i) < items.get(first)){
                scrambled.add(items.get(i));
            }

            // if there are equal numbers in the list:
            else{
                if ((int) items.get(i) == (int) items.get(first)){
                    scrambled.add(items.get(i));
                }

                else if ((int) items.get(first) == (int) items.get(middle)){
                    scrambled.add(items.get(first));
                }

                else if ((int) items.get(middle) == (int)items.get(i)){
                    scrambled.add(items.get(middle));
                }

                else{
                    System.out.println("ERROR!");
                }
            }
            middle++;
            first++;
        }
        return scrambled;

    }

    public static int firstMissingPositive(List<Integer> items){
        if (items.contains(1) == false){

            return 1;
        }
        else{
            for (int i = 1; i < items.size();i++){
                if (items.contains(i) != true){

                    return i;
                }
            }

            return items.size()+1;

        }

    }





    public static boolean isPrime(int n){

        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> factorFactorial(int n){
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        // if n == 1 or 0
        if (n == 1 || n == 0){
            return primeFactors;
        }


        int total = 1;

        // extracting prime factors from the factorial
        for (int i = 2; i <= n; i++){
            boolean primeOrNot = P2J4.isPrime(i);

            if (primeOrNot == true){
                primeFactors.add(i);
            }
            else{
                int placeholder = i;
                for (int j = 2;j <= placeholder; j++){
                    if (P2J4.isPrime(j) == true){
                        while (placeholder % j == 0){
                            primeFactors.add(j);
                            placeholder = placeholder / j;
                        }
                    }
                }
            }
        }



        // sort prime factor list before returning it
        Collections.sort(primeFactors);
        //System.out.println(primeFactors);
        return primeFactors;

    }



    public static void sortByElementFrequency(List<Integer> items){



        // Counter Map
        Map<Integer,Integer> counter = new HashMap<>();
        for (int i = 0; i < items.size();i++) {
            if (counter.containsKey(items.get(i))) {
                counter.put(items.get(i), counter.get(items.get(i)) + 1);
            } else {
                counter.put(items.get(i), 1);
            }
        }

        // Comparator Interface
        class Comp implements Comparator<Integer>{

            public int compare(Integer o1, Integer o2){
                if (counter.get(o1) > counter.get(o2)){
                    return 1;
                }
                else if (counter.get(o1) < counter.get(o2)){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }

        Set<Integer> set = new HashSet<Integer>(items); // Remove duplicate elements in items by making a set
        ArrayList<Integer> k = new ArrayList<Integer>(set); // turn that set into an arrayList so we can iterate through it

        Collections.sort(k); // sort the ArrayList containing non duplicate elements



        // Loop through the "k" non-duplicate ArrayList and then check for the one with the highest value
        // then, add it to the empty "items" list
        Comp comparator = new Comp();
        int store = 0;
        int setter = 0;

        while(k.size() > 0){
            for (int j = 1; j<k.size();j++){
                if (comparator.compare(k.get(store),k.get(j)) == 1){
                    continue;
                }
                else if (comparator.compare(k.get(store),k.get(j)) == 0){
                    continue;
                }
                else{
                    store = j;
                }
            }

            for (int p = 0; p<counter.get(k.get(store));p++){
                items.set(setter,k.get(store));
                setter += 1;
            }
            k.remove(store);
            store = 0;
        }
        System.out.println(items);
    }



    public static void main(String[] args){
        List<Integer> a1 = Arrays.asList(42, 42, 17, 42, 42, 17, 5, 5);
        List<Integer> a2 = Arrays.asList(6, 3, 6, 3, 6, 3, 6, 3, 6);
        List<Integer> a3 = Arrays.asList(42, 17, 99, -10, 5);
        List<Integer> a4 = Arrays.asList(101, 101, 101, 101, 101, 101, 101, 101, 101);
        List<Integer> a5 = Arrays.asList(67, 4, 101, 67, 67, 67, 4, 4, 4, 4, 101, 4);
        //testing sortByElementFrequency
        sortByElementFrequency(a1);
        sortByElementFrequency(a2);
        sortByElementFrequency(a3);
        sortByElementFrequency(a4);
        sortByElementFrequency(a5);

    }

}