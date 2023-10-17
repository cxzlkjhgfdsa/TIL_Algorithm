import java.util.*;
import java.io.*;

public class Main {

    static int[] nums = {1, 2, 3, 4};
    static int n;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        find(0);

        System.out.println(ans);

    }

    private static void find(int sum){
        
        if(sum > n){
            return;
        }
        if(sum == n){
            ans++;
            return;
        }

        for(int i = 0; i < 4; i++){
            find(sum+nums[i]);
        }
    }
}