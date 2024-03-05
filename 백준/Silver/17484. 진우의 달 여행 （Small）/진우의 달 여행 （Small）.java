import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ans = 1000;

        int[][] map = new int[N+1][M];

        for(int i = 1; i <= N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j ++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < M; i++){
            dfs(0, i, 0, 0, map);
        }

        System.out.println(ans);
    }

    private static void dfs(int i , int j, int dir, int cnt, int[][] map){

         cnt += map[i][j];

         if(i == map.length-1){
             ans = Math.min(ans, cnt);
             return;
         }

         if(dir == 1){
            if(j+1 < map[0].length){
                dfs(i+1, j+1, 3, cnt, map);
            }
            dfs(i+1, j, 2, cnt, map);
         }else if(dir == 2){
             if(j-1 >= 0){
                 dfs(i+1, j-1, 1, cnt, map);
             }
             if(j+1 < map[0].length ){
                 dfs(i+1, j+1, 3, cnt, map);
             }
         }else if(dir == 3){
             if(j-1 >= 0){
                 dfs(i+1, j-1, 1, cnt, map);
             }
             dfs(i+1, j, 2, cnt, map);
         }else{
             if(j-1 >= 0){
                 dfs(i+1, j-1, 1, cnt, map);
             }
             if(j+1 < map[0].length){
                 dfs(i+1, j+1, 3, cnt, map);
             }
             dfs(i+1, j, 2, cnt, map);
         }

    }

}
