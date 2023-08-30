import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] Rgraph;
    static int [] cost;
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            cost = new int[N+1]; // 건물 건설시간 저장

            input = br.readLine().split(" ");
            for(int i = 1; i <= N; i++){
                cost[i] = Integer.parseInt(input[i-1]);
            }

            Rgraph = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                Rgraph[i] = new ArrayList<>();
            }

            for(int i = 0; i < K; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                Rgraph[b].add(a);
            }

            int W = Integer.parseInt(br.readLine());
            dp = new int[N+1];
            Arrays.fill(dp , -1);
            dfs(W);
            int ans = dp[W];

            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }

    static int dfs(int cur){
        if(dp[cur] != -1)
            return dp[cur];

        int max = cost[cur];

        for(int next : Rgraph[cur]){
            max = Math.max(max, dfs(next) + cost[cur]);
        }

        dp[cur]  = max;
        return max;
    }
}
