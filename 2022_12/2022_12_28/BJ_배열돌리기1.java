import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_배열돌리기1 {
    static int [] dx = {0, 1, 0, -1}; // 우->하->좌->상 이동을 위한 배열
    static int [] dy = {1, 0, -1, 0};  // 우->하->좌->상 이동을 위한 배열
    static int [][] map; // 돌릴 배열의 정보
    static int N, M;  // 배열의 행, 열 크기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);  //열 크기
        M = Integer.parseInt(input[1]);  // 행 크기
        int R = Integer.parseInt(input[2]);  // 배열 돌리기를 반복할 횟수

        map = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        int spinIdx = (Math.min(N, M) /2 );  // 배열돌리기의 시작점 알기 위한 변수 (0, 0), (1, 1) ... (k, k)에서 시작해야하는데 k<spinIdx 여야함

        for(int i=0; i<R; i++){
            for(int j=0; j<spinIdx; j++){  // 배열을 전체적으로 한번 돌림
                spin(j, j);  // 배열돌리기
            }

        }

        for(int i=0; i<N; i++){      // 다 돌린 배열출력
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void spin(int startX, int startY) {   // 배열을 돌리는 메소드
        int x = startX;   // 시작점 x좌표
        int y = startY;   // 시작점 y좌표
        int idx = 0;      // 돌리기 위한 인덱스
        int save = map[startX][startY];  // 첫번째 값은 돌리기 시작하자마자 변경되기 때문에 따로 저장해놓고 나중에 넣어주어야함ㄴ

        while (idx<4){  // idx 가 4가되면 다시 제자리로 온 것이므로 중단
            int cx = x+dx[idx];
            int cy = y+dy[idx];

            if(cx<startX || cx >=N-startX || cy<startY || cy>=M-startY){  // 범위밖이면 idx++ 하고 건너뜀
                idx++;
                continue;
            }

            map[x][y] =map[cx][cy];
            x = cx;
            y = cy;
        }

        map[startX+1][startY]=save;  // map[startX][startY]가 이동한것을 넣음

    }
}
