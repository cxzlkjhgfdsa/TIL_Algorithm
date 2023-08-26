import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static String[] dir = {"D", "L", "U", "R"};

    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        String[][] map =  new String[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            input = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = input[j];
            }
        }

        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j])
                    continue;
                checkZone(i, j, map, visited);
                ans++;
            }
        }

        System.out.println(ans);

    }

    static void checkZone(int x, int y, String[][] map, boolean[][] visited){
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            Pos p = que.poll();

            for(int i=0; i<4; i++){
                int cx = p.x+dx[i];
                int cy = p.y+dy[i];

                if(cx < 0 || cx >=N || cy < 0 || cy >= M)
                    continue;
                if(visited[cx][cy] || !map[cx][cy].equals(dir[i]))
                    continue;
                visited[cx][cy] = true;
                que.add(new Pos(cx,cy));
            }
            if(map[p.x][p.y].equals("U")){
                int cx = p.x+dx[0];
                int cy = p.y+dy[0];
                if(cx < 0 || cx >=N || cy < 0 || cy >= M || visited[cx][cy])
                    continue;
                que.add(new Pos(cx, cy));
                visited[cx][cy] = true;
            }else if(map[p.x][p.y].equals("R")){
                int cx = p.x+dx[1];
                int cy = p.y+dy[1];
                if(cx < 0 || cx >=N || cy < 0 || cy >= M || visited[cx][cy])
                    continue;
                que.add(new Pos(cx, cy));
                visited[cx][cy] = true;
            }else if(map[p.x][p.y].equals("D")){
                int cx = p.x+dx[2];
                int cy = p.y+dy[2];
                if(cx < 0 || cx >=N || cy < 0 || cy >= M || visited[cx][cy])
                    continue;
                que.add(new Pos(cx, cy));
                visited[cx][cy] = true;
            }else if(map[p.x][p.y].equals("L")){
                int cx = p.x+dx[3];
                int cy = p.y+dy[3];
                if(cx < 0 || cx >=N || cy < 0 || cy >= M || visited[cx][cy])
                    continue;
                que.add(new Pos(cx, cy));
                visited[cx][cy] = true;
            }
        }
    }


}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}