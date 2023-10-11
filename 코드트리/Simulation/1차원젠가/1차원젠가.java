import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            list.add(sc.nextInt());
        }

        for(int i = 0; i < 2; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int k = 0; k<= b - a; k++){
                list.remove(a-1);
            }
        }

        System.out.println(list.size());
        for(int n : list){
            System.out.println(n);
        }
    }
}