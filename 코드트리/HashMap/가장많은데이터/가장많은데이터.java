import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        int max = 1;

        for(int i = 0; i < n; i++){
            String s = sc.next();
            if(map.get(s) == null){
                map.put(s, 1);
            }else{
                max = Math.max(max, map.get(s)+1);
                map.put(s, map.get(s)+1);
            }

        }

        System.out.println(max);
    }
}