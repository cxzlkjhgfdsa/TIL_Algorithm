import java.util.*;
import java.io.*;

public class Main {

    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[][] map = new int[n][n];
        
        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int tc = 0; tc < m; tc++){

            for(int idx = 1; idx <= n*n; idx++){
                boolean ch = false;
                for(int i = 0; i < n; i++){
                    if(ch)
                        break;
                    for(int j = 0; j < n; j++){

                        if(idx == map[i][j]){
                             changePos(i, j, map, n);
                             ch = true;
                             break;
                        }

                    }
                }
            }

        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void changePos(int x, int y, int[][] map , int n){

        int max = 0;

        int maxPosX = -1;
        int maxPosY = -1;

        for(int i = 0; i < 8; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= n || cy < 0 || cy >= n)
                continue;
            
            if(map[cx][cy] > max){
                max = map[cx][cy];
                maxPosX = cx;
                maxPosY = cy;
            }


        }


        int temp = map[x][y];

        map[x][y] = max;
        map[maxPosX][maxPosY] = temp;

    }
}