import java.io.*;

public class 트로미노 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;

        for(int i=0; i<=N-2; i++){
            for(int j=0; j<=M-2; j++){
                int sum = map[i][j] + map[i][j+1]+ map[i+1][j] + map[i+1][j+1];

                max = Math.max(max, sum - map[i][j]);
                max = Math.max(max, sum - map[i+1][j]);
                max = Math.max(max, sum - map[i][j+1]);
                max = Math.max(max, sum - map[i+1][j+1]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<=M-3; j++){
                int sum = map[i][j] + map[i][j+1] + map[i][j+2];
                max = Math.max(sum, max);
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<=N-3; j++){
                int sum = map[j][i] + map[j+1][i] + map[j+2][i];
                max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}