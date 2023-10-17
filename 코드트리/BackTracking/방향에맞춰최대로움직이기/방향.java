import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] dis;

    static int max = 0;

    static int n;

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dis = new int[n][n];

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                dis[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;

        move(x , y, 0);
    
        System.out.println(max);

        
    }

    private static void move(int x, int y, int cnt){

        max = Math.max(cnt, max);

        int cx = x;
        int cy = y;

        while(true){

            cx += dx[dis[x][y]];
            cy += dy[dis[x][y]];

            if( cx < 0 || cx >= n || cy < 0 || cy >= n){
                break;
            }

            if(map[cx][cy] > map[x][y]){
                move(cx, cy, cnt+1);
            }
        }

        return;

    }
}