import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_정사각형방 {

    static int max, minSize, N;  //최대로 갈 수 있는 방수, 가장 작은 시작 번호, 방의 한 변의 길이
    static int [] dx = {-1, 0, 1, 0};  // 상 하 좌 우 탐색을 위한 배열
    static int [] dy = {0, 1, 0, -1};  // 상 하 좌 우 탐색을 위한 배열

    static int [][] map;  // 방 정보를 담을 배열
    static class pos{  // 해당 방 위치, 번호를 나타내는 클래스
        int x, y, size;
        public pos(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for(int tc=1; tc<=T; tc++){

            N = Integer.parseInt(br.readLine());  // 한 변의 길이
            map = new int[N][N];

            for(int i=0; i<N; i++){   // 방 정보 넣는 반복문
                input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            max = 0;   // 갈수 있는 방의 최대 개수
            minSize = 1000000;  // 시작 방의 최소 번호

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    check(new pos(i, j, map[i][j]));  // 모든 점에서 체크
                }
            }
            sb.append("#").append(tc).append(" ").append(minSize).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }

    private static void check(pos pos) {
        Queue<pos> que = new ArrayDeque<>();  // BFS 탐색을 위한 큐
        que.offer(pos);

        int canGo= 0;  // 많이 갈 수 있는 방

        while (!que.isEmpty()){  //BFS 탐색으로 갈 수 있는 최대 방 수 탐색
            pos p = que.poll();

            canGo++;  // 방 도착 했으면 ++

            for(int i=0; i<4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];

                if(cx<0 || cx>=N || cy<0 || cy>=N) { // 범위 밖이면 패스
                    continue;
                }
                if(p.size != map[cx][cy]-1) {  // 1 큰게 아니면 패스
                    continue;
                }
                que.offer(new pos(cx, cy, map[cx][cy]));

            }

        }

        if(canGo>max){ // 최대 보다 크면 갱신
            max = canGo;
            minSize = pos.size;
        }else if(canGo==max){  // 같으면 작은 값 갱신
            minSize = Math.min(minSize, pos.size);
        }

    }
}
