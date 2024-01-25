import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};  // 상하좌우 탐색을 위한 int 배열 2개 ( dx -> x 좌표의 값을 컨트롤,  dy -> y 좌표의 값을 컨트롤 )

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력받기 위한 도구
        StringBuilder sb = new StringBuilder();  // 출력값을 저장하기 위한 StringBuilder
        String[] input; // 입력값을 저장하기 위한 String 배열

        int T = Integer.parseInt(br.readLine());  // 테스트케이스 개수를 입력받음

        for(int tc = 0; tc < T; tc++){
            input = br.readLine().split(" "); // 배추밭의 가로길이, 세로길이, 배추의 개수를 입력받음

            int M = Integer.parseInt(input[0]); // 배추밭의 가로길이
            int N = Integer.parseInt(input[1]); // 배추밭의 세로길이
            int K = Integer.parseInt(input[2]); // 배추의 개수
            int count = 0; // 배추집단의 개수

            int[][] map = new int[N][M];  // 배추밭의 정보를 저장할 2차원 int 배열
            boolean[][] visited = new boolean[N][M]; // 재방문하는 것을 방지하기 위한 boolean 2차원 배열

            for(int i = 0; i < K; i++){
                input = br.readLine().split(" ");  // 배추의 위치를 입력받음
                map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;  // 배추가 위치하는 곳의 정보룰 1로 갱신
            }

            for(int i = 0; i < N; i ++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){  // 만약 배추가 위치하는 곳이며 , 방문하지 않았으면
                        count++;  // 새로운 배추집단이므로 count + 1;
                        bfs(i, j, N, M, map, visited);  // 배추집단을 모두 탐색하기 위해 bfs 메소드 실행
                    }
                }
            }

            sb.append(count).append("\n");  // 출력값을 저장할 StringBuilder 에 결과값을 저장

        }

        System.out.println(sb);  // 저장되어있던 출력값들을 출력
    }

    public static void bfs(int x, int y, int N, int M, int[][] map , boolean[][] visited){ // 배추집단을 모두 탐색하기 위한 bfs 메소드

        Queue<Pos> que = new ArrayDeque<>();    // bfs 탐색을 위한 queue
        que.add(new Pos(x, y));   // 배추집단의 시작 좌표를 que에 삽입
        visited[x][y] = true;  // 현재 위치를 방문 표시

        while(!que.isEmpty()){
            Pos p = que.poll();

            for(int i = 0; i < 4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= M || visited[cx][cy] || map[cx][cy] != 1){  // 배추밭을 벗어나거나, 방문했거나 , 배추가 존재하지 않는다면 스킵
                    continue;
                }
                que.add(new Pos(cx, cy)); // 여기까지 왔다면 배추집단의 일부이기 때문에 queue 에 삽입
                visited[cx][cy] = true; // 방문표시

            }

        }

    }


}

class Pos{  // 좌표값을 저장하기 위한 클래스
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

