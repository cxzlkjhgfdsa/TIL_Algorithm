import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_암호생성하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;
        StringBuilder sb = new StringBuilder();
        int [] minus = {1, 2, 3, 4, 5};  //1,2,3,4,5를 순서대로 뺴기 위함

        for(int tc=1; tc<=10; tc++){
            int T = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            Queue<Integer> que = new ArrayDeque<>();
            int min = Integer.MAX_VALUE;  // 15로 나누었을 때 묷이 가장 작은 수를 찾기위함
            for(int i=0; i<8; i++){
                min = Math.min(min, Integer.parseInt(input[i])%15);  // 가장작은 묷은 저장
            }

            for(int i=0; i<8; i++){
                que.offer(Integer.parseInt(input[i])-(15*min) + 15);  // 나머지가 0이면 안되기때문에 15*가장작은 묷을 뺴고 +15
            }
            int idx = 0;  // 1,2,3,4,5 를 순서대로 빼기위한 idx

            while (true){
                idx = idx%5;
                int n = que.poll(); // que에서 하나씩 꺼내가면 암호 생성
                n = n-minus[idx];
                if(n<=0){   // 0 이하면 0 을 마지막에넣고 종료
                    que.offer(0);
                    break;
                }else{  // 아니면 que 마지막에 넣고 다음 작업 수행
                    que.offer(n);
                    idx++;
                }

            }
            sb.append("#").append(T).append(" ");
            for(int i=0; i<8; i++){
                sb.append(que.poll()).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
