import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class SWEA_햄버거다이어트 {

    static class buger implements Comparable<buger>{  //햄버거 재료를 담기위한 클래스
        int score, cal;

        public buger(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }

        @Override
        public int compareTo(buger o) {
            return this.cal-o.cal;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);  // 제료 개수
            int maxCal = Integer.parseInt(input[1]);  // 최대 칼로리

            int [][] D = new int[N+1][maxCal+1];  // 최대 점수를 찾기 위한 2차원배열
            buger [] bg = new buger[N+1];  // 재료 담을 배열

            for(int i=1; i<=N; i++){
                input = br.readLine().split(" ");
                bg[i] = new buger(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }
            bg[0] = new buger(0, 0);
            Arrays.sort(bg);  // 정렬


            for(int i=1; i<=N; i++){   // 냅색 코드
                for(int j=0; j<=maxCal; j++){
                    if(bg[i].cal<=j){                                                   // 현재 최대 칼로리보다 낮은 칼로리면
                        D[i][j] = Math.max(D[i-1][j], D[i-1][j-bg[i].cal]+bg[i].score); // 현재 최대 스코어는 = 바로 이전 물건을
                    }else{                                                              // 사용한 최대스코어 , 현재 물건의 칼로리를 뺀  최대 점수 + 현재 물건 점수
                        D[i][j] = D[i-1][j];                                            // 즁 더 큰값
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(D[N][maxCal]).append("\n");

        }
        System.out.println(sb);
    }
}
