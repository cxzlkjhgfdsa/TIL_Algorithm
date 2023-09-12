import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[][] maps = new int[N][N];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(input[j]);
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int k = maps[i][j];

                if( k == 0)
                    break;

                if( i + k < N ){
                    dp[i + k][j] += dp[i][j];
                }

                if( j + k < N){
                    dp[i][j + k] += dp[i][j];
                }

            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j= 0 ; j < N; j ++){
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N-1][N-1]);

    }
}
