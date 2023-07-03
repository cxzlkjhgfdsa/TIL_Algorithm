import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        int ans = 0;
        int[] dp = new int[N];

        for(int i=0; i<N; i++){

            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

        }

        for(int n : dp) {
            ans = Math.max(n, ans);
        }

        System.out.println(ans);
    }
}
