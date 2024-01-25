import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};  // 상하좌우 탐색을 위한 int 배열 2개 ( dx -> x 좌표의 값을 컨트롤,  dy -> y 좌표의 값을 컨트롤 )

    static int n, m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력받기 위한 도구
        String[] input;   // 입력값을 저장하기 위한 문자 배열

        input = br.readLine().split(" ");  // 도화지의 가로와 세로 크기를 입력받음

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]); // n -> 도화지의 세로 길이 , m ->  도화지의 가로길이
        int count = 0;  // 그림의 개수
        int maxSize = 0;  // 그림의 최대 사이즈

        int[][] map = new int[n][m]; // 도화지의 정보를 받을 2차원 int 배열

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);  // 도화지의 정보를 입력
            }
        }

        boolean[][] visited = new boolean[n][m];  // 이미 탐색했던 그림을 재 탐색하는 것을 방지하기 위한 boolean 2차원 배열

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){  // 도화지를 ( 0, 0 ) -> ( n -1 , m - 1 ) 좌표까지 전부 탐색하며 그림을 찾는다
                if(map[i][j] == 1 && !visited[i][j]){ // ( i , j ) 좌표가 1이며 방문하지 않았다면 새로운 그림이다
                    count++;   // 그림의 개수 + 1
                    maxSize = Math.max(maxSize , bfs(i, j, map, visited));  // 그림의 사이즈를 리턴받아 최대사이즈를 갱신
                }

            }
        }

        System.out.println(count);
        System.out.println(maxSize);

    }

    /**
     *
     * @param x  그림의 시작 x 좌표
     * @param y  그림의 시작 y 좌표
     * @param map  도화지의 정보가 담겨있는 int 2차원 배열
     * @param visited 이미 방문한 곳인지 확인하기 위한 boolean 2차원 배열
     * @return
     */
    public static int bfs(int x, int y, int[][] map , boolean[][] visited){  //  bfs 로 그림을 탐색하기 위한 메소드 . 그림의 크기를 리턴한다

        int size = 0;

        Queue<Pos> que = new ArrayDeque<>(); // bfs 탐색을 위한 Queue
        que.add(new Pos(x, y));  // 그림의 시작 좌표를 Queue에 저장
        visited[x][y] = true;  // 현재 좌표를 방문처리

        while(!que.isEmpty()){ // queue 가 비어있지 않을 동안 반복 -> queue가 비어있다면 반복 종료

            Pos p = que.poll();  // 좌표를 queue 에서 꺼낸다
            size++;  // 좌표한번을 방문할 때마다 그림의 사이즈 + 1

            for(int i = 0; i < 4; i++){  // 상하좌우를 탐색 ( dx , dy 의 0번째값은 위를 탐색 , 1번째 값은 오른쪽을 탐색 ... )
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m || visited[cx][cy] || map[cx][cy] != 1){ // 도화지의 범위를 벗어나거나 , 1이 아니거나 , 이미 방문한 곳이라면 스킵
                    continue;
                }

                que.add(new Pos(cx, cy)); // 여기까지 왔다면 정상적으로 탐색 가능한 곳
                visited[cx][cy] = true;  // 탐색한 곳이기 때문에 방문 표시

            }

        }

        return size;
    }
}

class Pos{  // 좌표값을 저장하기 위한 클래스
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

