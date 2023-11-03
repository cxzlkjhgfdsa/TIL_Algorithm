import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    static int[][] map;

    static int n , ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }

        }

        for(int i = 2; i < n; i++){
            for(int j = 1; j < n-1; j++){
                ans = Math.max(ans, cal(i, j));
            }
        }


        System.out.println(ans);
        
        
    }

    private static int cal(int x, int y){
        int max = 0;


        for(int posX = 1; posX < x; posX++){

            if(y + posX >= n)
                continue;

            for(int posY = 1; posY < x  - posX + 1; posY++){

                if(y - posY < 0)
                    continue;


                int cx = x;
                int cy = y;

                int sum = 0;


                for(int i = 0; i < posX; i++){

                    cx += dx[0];
                    cy += dy[0];

                    sum += map[cx][cy];
                }

                for(int i = 0; i < posY; i++){

                    cx += dx[1];
                    cy += dy[1];

                    sum += map[cx][cy];
                }

                for(int i = 0; i < posX; i++){

                    cx += dx[2];
                    cy += dy[2];

                    sum += map[cx][cy];
                }

                for(int i = 0; i < posY; i++){

                    cx += dx[3];
                    cy += dy[3];

                    sum += map[cx][cy];
                }

                max = Math.max(max, sum);

            }
        }
        
        return max;
    }
}