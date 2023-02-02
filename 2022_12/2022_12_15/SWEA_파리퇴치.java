import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_파리퇴치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);   //맵 크기
            int M = Integer.parseInt(input[1]);   // 파리채 크기

            int [][] fly = new int [N+1][N+1];

            for(int i=1; i<=N; i++){
                input = br.readLine().split(" ");
                for(int j=1; j<=N; j++){
                    fly[i][j] = Integer.parseInt(input[j-1])+fly[i][j-1]; // 각 행별로 구간합을 저장
                }
            }
            int max = 0;  // 최대로 잡을 수 있는 파리의 마리수를 저장하기 위한 변수

            for(int i=1; i<=N-M+1; i++){   // M*M 크기의 파리채로 잡는거기 때문에 행은 N-M+1 행까지만 탐색
                for(int j=M; j<=N; j++){   // 열은 M~ N까지 탑색한다
                    int sum=0;
                    for(int k=0; k<M; k++){  // M*M 크기로 잡을 수 있는 파리수를 탐색
                        sum+=fly[i+k][j]-fly[i+k][j-M];  // 각 행마다 j번째까지의 합 - j-M번째까지의 합을 구하면 된다
                    }
                    max = Math.max(max, sum);   // max 값을 갱신
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");  // 스트링 빌더에 결과값을 저장



        }
        System.out.println(sb);  // 스트링 빌더 출력
    }
}
