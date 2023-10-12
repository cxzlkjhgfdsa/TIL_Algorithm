import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int k, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n];

        choose(0, arr);

        System.out.println(sb);
        
    }

    private static void choose(int cnt , int[] nums){

        if(cnt == n){
            for(int i : nums){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=k; i++){
            nums[cnt] = i;
            choose(cnt+1, nums);
        }

    }
}