import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class tomato{
        int x, y, z, time;

        public tomato(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];
        int dx[] = {-1, 0, 1, 0, 0, 0};
        int dy[] = {0, 1, 0, -1, 0, 0};
        int dz[] = {0, 0, 0, 0, 1, -1};

        input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int H = Integer.parseInt(input[2]);

        int[][][] map = new int[N][M][H];
        boolean[][][] visited = new boolean[N][M][H];
        int cnt = 0;
        Queue<tomato> que = new ArrayDeque<>();
        for(int z = 0; z<H; z++) {
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j][z] = Integer.parseInt(input[j]);
                    if (map[i][j][z] == 1) {
                        que.offer(new tomato(i, j, z, 0));
                        visited[i][j][z] = true;
                    } else if (map[i][j][z] == 0) {
                        cnt++;
                    }
                }
            }
        }
        if (cnt == 0) {
            System.out.println(0);
            System.exit(0);
        }
        tomato t=que.peek();
        while (!que.isEmpty()) {
            t = que.poll();
            //System.out.println(t.x+" "+t.y+" "+t.z);

            for (int i = 0; i < 6; i++) {
                int cx = t.x + dx[i];
                int cy = t.y + dy[i];
                int cz = t.z + dz[i];
                if (cx < 0 || cx >= N || cy < 0 || cy >= M || cz < 0 || cz >= H || visited[cx][cy][cz] || map[cx][cy][cz] == 1 || map[cx][cy][cz] == -1)
                    continue;
                que.offer(new tomato(cx, cy, cz, t.time + 1));
                visited[cx][cy][cz] = true;
                map[cx][cy][cz] = 1;

            }
        }
        boolean tg = true;
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y][z] == 0) {
                        tg = false;
                    }
                    //System.out.print(map[x][y][z]+" ");
                }
                //System.out.println();
            }
            //System.out.println();
        }
        if(tg){
            System.out.println(t.time);
        }else{
            System.out.println(-1);
        }

    }
}
