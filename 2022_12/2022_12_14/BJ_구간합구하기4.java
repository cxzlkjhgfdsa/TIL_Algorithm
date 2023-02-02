import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_구간합구하기4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int [] sum = new int[N+1];  // 구간합을 구하기 위한 배열
        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1]+Integer.parseInt(input[i-1]); // i번째가지의 합을 저장
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" "); // 구간을 입력받음
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            // x~y 구간의 합은 1~y번째 까지의합 - 1~x-1번쨰의합과 같다
            int ans = sum[y]-sum[x-1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);


    }
}
