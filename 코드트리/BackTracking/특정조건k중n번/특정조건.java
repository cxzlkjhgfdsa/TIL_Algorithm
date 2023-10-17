import java.util.*;
import java.io.*;

public class Main {

    static int k, n;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        sb = new StringBuilder();
        int[] arr = new int[n];

        perm(0, 0, 0, arr);

        System.out.println(sb);


    }

    private static void perm(int cur, int stack, int cnt, int[] arr){

        if(stack == 3){
            return;
        }

        if(cnt == n){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= k; i++){
            if(cur == i){
                arr[cnt] = i;
                perm(i, stack+1, cnt+1, arr);
            }else{
                arr[cnt] = i;
                perm(i, 1, cnt+1, arr);
            }
        }
    }
}