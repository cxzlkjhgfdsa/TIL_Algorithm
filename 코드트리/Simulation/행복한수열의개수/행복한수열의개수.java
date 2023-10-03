import java.io.*;

public class 행복한수열의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            int curX = -1;
            int curY = -1;
            int happyX = 1;
            int maxHappyX = 1;
            int happyY = 1;
            int maxHappyY = 1;
            for(int j=0; j<N; j++){
                if(curX == map[i][j]){
                    happyX++;
                    maxHappyX = Math.max(happyX, maxHappyX);
                }else{
                    happyX= 1;
                    curX = map[i][j];
                }

                if(curY == map[j][i]){
                    happyY++;
                    maxHappyY = Math.max(happyY, maxHappyY);
                }else{
                    happyY = 1;
                    curY = map[j][i];
                }

            }

            if(maxHappyX >= M){
                ans++;
            }
            if(maxHappyY >= M){
                ans++;
            }
        }

        System.out.println(ans);
    }
}