import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력받기 위한 도구
        String[] input;  // 입력값을 저장하기 위한 String 배열

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        input = br.readLine().split(" ");  // 미로의 세로 길이와 가로길이를 입력받음

        int N = Integer.parseInt(input[0]);  // 미로의 세로길이
        int M = Integer.parseInt(input[1]);  // 미로의 가로길이
        int answer = 0;  // 정답을 담을 변수

        int[][] maze = new int[N][M];   // 미로의 정보를 담을 2차원 int 배열
        boolean[][] visited = new boolean[N][M]; // 재방문을 방지하기 위한 방문 체크 배열

        for(int i = 0; i < N; i++){
            input = br.readLine().split("");
            for(int j = 0; j < M; j++){
                maze[i][j] = Integer.parseInt(input[j]);  // 미로의 정보를 입력받음
            }
        }

        Queue<Maze> que = new ArrayDeque<>();  // BFS 탐색을 위한 Queue
        que.add(new Maze(0, 0, 1)); // 시작위치를 Queue에 삽입
        visited[0][0] = true; // 시작위치 방문 처리

        while(!que.isEmpty()){
            Maze m = que.poll();
            if(m.x == N-1 && m.y == M-1){ // 현재위치가 도착 위치라면
                answer = m.cnt;  // 답은 현재 이동거리 -> BFS 이기 때문에 가장 최단거리임
            }

            for(int i = 0; i < 4; i++){  // 상하좌우를 탐색하여 나아갈 수 있는 방향이 있는지 확인
                int cx = m.x + dx[i];
                int cy = m.y + dy[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= M || visited[cx][cy] || maze[cx][cy] != 1){ // 미로 밖이거나, 방문 했더나, 길이 아니라면 패스
                    continue;
                }

                que.add(new Maze(cx, cy, m.cnt+1)); // 나아갈 수 있는 길이라면 que에 삽입 ( cnt + 1 해서 )
                visited[cx][cy] = true; // 방문처리
            }
        }

        System.out.println(answer); // 답 출력
    }
}

class Maze{  // x , y 좌표값과 움직인 횟수를 갖고있는 클래스
    int x, y, cnt;
    public Maze(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}