import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] group;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<Integer> groupCnt;
    static Queue<pos> blanck;
    static Queue<pos> wall;

    static int idx = 0;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        group = new int[N][M];
        blanck = new ArrayDeque<>();
        wall = new ArrayDeque<>();
        groupCnt = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                int cur = Integer.parseInt(input[j]);
                map[i][j] = cur;
                if(cur > 0 ){
                    wall.add(new pos(i, j));
                    visited[i][j] = true;
                    group[i][j] = -1;
                }else{
                    blanck.add(new pos(i, j));
                }
            }
        }

        while (!blanck.isEmpty()){
            pos p = blanck.poll();
            if(visited[p.x][p.y]){
                continue;
            }
            visited[p.x][p.y] = true;
            findWay(p.x, p.y);
        }


        int[][] ans = new int[N][M];

        while (!wall.isEmpty()){
            pos p = wall.poll();
            ans[p.x][p.y]  = check(p.x, p.y);
        }

        for(int i =0; i< N ; i++){
            for(int j=0; j<M; j++){
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int check(int x, int y){
         boolean[] same = new boolean[idx];
         int ans = 1;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] > 0){
                continue;
            }

            int groupNum = group[cx][cy];

            if(same[groupNum] )
                continue;;
            ans+= groupCnt.get(groupNum);
            same[groupNum] = true;
        }

        return ans%10;
    }

    static void findWay(int x, int y){
        Queue<pos> que = new ArrayDeque<>();
        int ans = 0;
        que.offer(new pos(x, y));

        while(!que.isEmpty()){
            pos p = que.poll();
            group[p.x][p.y] = idx;
            ans++;

            for(int i=0; i<4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= M){
                    continue;
                }
                if(visited[cx][cy] || map[cx][cy] > 0){
                    continue;
                }

                que.offer(new pos(cx, cy));
                visited[cx][cy] = true;
            }

        }
        groupCnt.add(ans);
        idx++;
    }

    static class pos {
        int x , y;
        public pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
