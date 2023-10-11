import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]) - 1;
        int c = Integer.parseInt(input[2]) - 1;

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean cycle = true;

        while(cycle){
            
            cycle = false;
            int k = map[r][c];

            sb.append(k).append(" ");

            for(int i = 0; i < 4; i++){
                int dr = r + dx[i];
                int dc = c + dy[i];

                if(dr >= 0 && dr < n && dc >= 0 && dc < n){
                    if(k < map[dr][dc]){
                        cycle = true;
                        r = dr;
                        c = dc;
                        break;
                    }
                }
            }
        }

        System.out.println(sb);



    }
}
