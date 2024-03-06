import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 팀의 개수
            int k = Integer.parseInt(input[1]); // 문제의 개수
            int t = Integer.parseInt(input[2]); // 팀 아이디
            int m = Integer.parseInt(input[3]); // 로그의 수

            int[][] score = new int[n + 1][k + 2]; // 1번째 인덱스 부터 시작하기 위해 배열의 사이즈를 1씩 크게 잡아준다 각 행 ( 1차원 배열 ) 의 0번째 인덱스는 마지막 제출 시간을 저장한다
            // 각 1차원 배열의 마지막 인덱스에는 제출한 횟수를 저장한다

            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int id = Integer.parseInt(input[0]);  // 팀 아이디
                int idx = Integer.parseInt(input[1]); // 문제 번호
                int answer = Integer.parseInt(input[2]); // 점수

                score[id][idx] = Math.max(score[id][idx], answer); // 점수 갱신 ( 더 높은 점수로 )
                score[id][0] = i; // 최종 제출 시간
                score[id][k+1]++; // 제출 횟수
            }

            Team[] rank = new Team[n];

            for (int i = 1; i <= n; i++) {

                int sum = 0;

                for(int j = 1; j <= k; j++){
                    sum += score[i][j];
                }

                rank[i-1] = new Team(i, sum, score[i][k+1], score[i][0] );

            }

            Arrays.sort(rank);

//            for(int i = 0; i < n; i++){
//                System.out.print(rank[i].id+" ");
//            }
//            System.out.println();

            for(int i = 0; i < n; i++){
                if(rank[i].id == t){
                    sb.append(i+1).append("\n");
                    break;
                }
            }

        }

        System.out.println(sb);
    }

    static class Team implements Comparable<Team> {
        int id, score, submit_count, last_submit;

        public Team(int id, int score, int submit_count, int last_submit) {
            this.id = id;
            this.score = score;
            this.submit_count = submit_count;
            this.last_submit = last_submit;
        }

        @Override
        public int compareTo(Team o) {
            if (o.score == this.score) {
                if (this.submit_count == o.submit_count) {
                    return this.last_submit - o.last_submit;
                }
                return this.submit_count - o.submit_count;
            }
            return o.score - this.score;
        }
    }
}
