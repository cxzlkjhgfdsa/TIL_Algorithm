import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_한빈이와SpotMart {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for(int tc=1; tc<=T;tc++){
            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);  // 과자 봉지 수
            int M = Integer.parseInt(input[1]);  // 최대로 들 수 있는 무게
            int [] snack = new int [N];          // 과자 봉지를 담을 배열

            input = br.readLine().split(" ");
            for(int i=0; i<N; i++){     //과자봉지 무게 입력
                snack[i] = Integer.parseInt(input[i]);
            }

            int max = -1;        // 최대값을 -1 로 설정  -> 최대값을 가지지 못한 경우 -1을 출력해야하기 때문

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j) {   // i==j 일시 같은 과자봉지이기 때문에 패스
                        continue;
                    }

                    if(snack[i]+snack[j]<=M){   // 과자봉지 2개의 무게합이 최대로 들 수 있는 무게보다 작다면
                        max = Math.max(max, snack[i]+snack[j]);  // 최대값 갱신
                    }

                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");  // 스트링 빌더에 결과값 저장

        }
        System.out.println(sb);  // 스트링 빌더 출력

    }
}
