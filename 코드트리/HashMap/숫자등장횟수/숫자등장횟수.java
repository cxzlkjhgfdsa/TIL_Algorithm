import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int k = sc.nextInt();
            if(map.get(k) == null){
                map.put(k, 1);
            }else{
                map.put(k, map.get(k)+1);
            }
        }

        for(int i = 0; i < m; i++){
            int k = sc.nextInt();
            if(map.get(k) == null){
                System.out.print(0+" ");
            }else{
                System.out.print(map.get(k)+" ");
            }
        }


    }
}