import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            map[x][y] = 1;
            map[y][x] = 1;
        }
        visited = new boolean[N+1];
        visited[1] = true;

        dfs(1);
        int cnt = 0;
        for(boolean b : visited){
            if(b)
                cnt++;
        }

        System.out.println(cnt-1);
    }

    private static void dfs(int cur){



        for(int i = 1; i <= N; i++){
            if(map[cur][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}