import java.io.*;

public class 최고의33위치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++ ){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;

        for(int i = 0; i <= N-3; i++){
            for(int j=0; j<= N-3; j++) {
                int cnt = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (map[x][y] == 1)
                            cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(max);

    }
}