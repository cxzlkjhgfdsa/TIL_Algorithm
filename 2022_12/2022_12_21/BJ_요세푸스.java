import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_요세푸스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;
        StringBuilder sb = new StringBuilder();

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);  // 사람수
        int K = Integer.parseInt(input[1]);  // 몇번째 사람을 제거할건지

        Queue<Integer> que = new ArrayDeque<>(); // 요세푸스 원탁을 구현하기 위한 que

        for(int i=1; i<=N; i++){  // 1~N 까지의 숫자를 원탁에 앉힘
            que.offer(i);
        }

        sb.append("<");
        while (que.size()>1){  // 원탁에 1명만 남을때까지 반복

            for(int i=0; i<K-1; i++ ){  // K-1번 을 지나고
                que.offer(que.poll());
            }
            sb.append(que.poll()).append(", "); // K번째 사람을 제거하면서 수열에 추가

        }
        sb.append(que.poll()).append(">");  // 마지막 사람을 수열에 추가
        System.out.println(sb);
    }
}
