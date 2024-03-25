import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int[][] ans = new int[n][m];

        Pos start = null;

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 2){
                    start = new Pos(i, j, 0);
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;
        Queue<Pos> que = new ArrayDeque<>();
        que.offer(start);


        while(!que.isEmpty()){

            Pos cur = que.poll();

            ans[cur.x][cur.y] = cur.cnt;

            for(int i = 0; i < 4; i++){
                int cx = cur.x + dx[i];
                int cy = cur.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m || visited[cx][cy] || map[cx][cy] == 0)
                    continue;

                visited[cx][cy] = true;
                que.offer(new Pos(cx, cy, cur.cnt + 1));
            }


        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && ans[i][j] == 0)
                    ans[i][j] = -1;
                bw.write(ans[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }

    private static class Pos{
        int x, y, cnt;
        public Pos(int x, int y,  int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
