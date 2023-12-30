import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        for(int tc = 1; tc<=10; tc++){
            int n = Integer.parseInt(br.readLine());

            int[] buildings = new int[n];

            input = br.readLine().split(" ");

            for(int i = 0; i < n; i++){
                buildings[i] = Integer.parseInt(input[i]);
            }

            int ans = 0;

            for(int i = 2; i < n-2; i++){

                int cur = buildings[i];

                int top1 = Math.max(buildings[i-1], buildings[i+1]);
                int top2 = Math.max(buildings[i-2], buildings[i+2]);

                int top = Math.max(top1, top2);

                if(cur - top > 0){
                    ans+= (cur-top);
                }

            }

            System.out.println("#"+tc+" "+ans);

        }

    }
}
