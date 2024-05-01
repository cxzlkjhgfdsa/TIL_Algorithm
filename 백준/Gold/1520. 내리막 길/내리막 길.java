import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n, m;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));


    }

    static int dfs(int x, int y){


        if(x == n - 1 && y == m - 1){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        
        for(int i = 0; i < 4; i++){

            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
            if(map[cx][cy] < map[x][y]){

                dp[x][y] += dfs(cx, cy);
            }
        }

        return dp[x][y];
    }

}