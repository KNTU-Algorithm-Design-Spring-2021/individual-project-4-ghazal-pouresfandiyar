package ir.ac.kntu;

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> w = new ArrayList<>();
        List<Integer> trucks = new ArrayList<>();
        System.out.println("Enter number of objects : ");
        int n = scanner.nextInt();
        System.out.println("Enter weight of objects : ");
        for(int i = 0 ; i < n; i++){
            w.add(scanner.nextInt());
        }
        System.out.println("Enter number of trucks : ");
        int k = scanner.nextInt();
        for(int i = 0 ; i < k; i++){
            trucks.add(0);
        }
        Collections.sort(w);
        int N = n;
        for(int i = 0; i < N ; i++) {
            int maxW = w.get(n-1);
            Collections.sort(trucks);
            trucks.set(0, trucks.get(0) + maxW);
            w.remove(n-1);
            n--;
        }
        System.out.print("The weight of trucks : [");
        for (Integer i : trucks){
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }
}
