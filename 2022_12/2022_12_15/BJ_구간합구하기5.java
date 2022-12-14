import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input; // 입력정보를 받아올 배열

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);  // 표 한변의 크기
        int M = Integer.parseInt(input[1]);  // 연산 횟수

        int [][] map = new int [N+1][N+1];  // 표의 정보를 받기 위한 2차원 배열

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1])+map[i][j-1]; //각 행별로 j 번째까지의 합을 저장
            }
        }

        for(int t=0; t<M; t++){
            input = br.readLine().split(" ");  // x1, y1, x2, y2 정보를 받아옴
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int ans = 0;
            for(int i=x1; i<=x2 ;i++){
                ans+=map[i][y2]-map[i][y1-1];  // x1, y1 ~ x2,y2 까지의 합은 x1~ x2 행들의 y2까지의 합 - (y1-1)까지의 합
            }
            sb.append(ans).append("\n");


        }
        System.out.println(sb);
    }
}
