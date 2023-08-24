import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;

        int[][] rgb = new int[N+1][3];
        int[][] dpR = new int[N+1][3];
        int[][] dpG = new int[N+1][3];
        int[][] dpB = new int[N+1][3];

        for(int i = 1; i<= N; i++){
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            rgb[i][0] = r;
            rgb[i][1] = g;
            rgb[i][2] = b;
        }

        /**
         * 첫 집을 빨강으로 칠했을 때
         */
        dpR[2][0] = 3000;
        dpR[2][1] = rgb[1][0] + rgb[2][1];
        dpR[2][2] = rgb[1][0] + rgb[2][2];

        for(int i=3; i<=N; i++){
            dpR[i][0] = rgb[i][0] + Math.min(dpR[i-1][1], dpR[i-1][2]);
            dpR[i][1] = rgb[i][1] + Math.min(dpR[i-1][0], dpR[i-1][2]);
            dpR[i][2] = rgb[i][2] + Math.min(dpR[i-1][0], dpR[i-1][1]);
        }

        ans = Math.min(dpR[N][1], dpR[N][2]);

        /**
         *  첫 집을 초록으로 칠했을 때
         */
        dpG[2][0] = rgb[1][1] + rgb[2][0];
        dpG[2][1] = 3000;
        dpG[2][2] = rgb[1][1] + rgb[2][2];

        for(int i=3; i<=N; i++){
            dpG[i][0] = rgb[i][0] + Math.min(dpG[i-1][1], dpG[i-1][2]);
            dpG[i][1] = rgb[i][1] + Math.min(dpG[i-1][0], dpG[i-1][2]);
            dpG[i][2] = rgb[i][2] + Math.min(dpG[i-1][0], dpG[i-1][1]);
        }

        ans = Math.min(dpG[N][0], ans);
        ans = Math.min(dpG[N][2], ans);

        /**
         *  첫 집을 파랑으로 칠했을 때
         */

        dpB[2][0] = rgb[1][2] + rgb[2][0];
        dpB[2][1] = rgb[1][2] + rgb[2][1];
        dpB[2][2] = 3000;

        for(int i=3; i<=N; i++){
            dpB[i][0] = rgb[i][0] + Math.min(dpB[i-1][1], dpB[i-1][2]);
            dpB[i][1] = rgb[i][1] + Math.min(dpB[i-1][0], dpB[i-1][2]);
            dpB[i][2] = rgb[i][2] + Math.min(dpB[i-1][0], dpB[i-1][1]);
        }

        ans = Math.min(dpB[N][0], ans);
        ans = Math.min(dpB[N][1], ans);

        System.out.println(ans);


    }
}
