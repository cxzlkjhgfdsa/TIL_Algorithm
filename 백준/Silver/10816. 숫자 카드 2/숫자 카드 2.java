
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>(); // 숫자 카드의 개수를 저장할 HashMap

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){  // 카드의 정보를 HashMap에 입력
            int k = Integer.parseInt(input[i]);

            if(map.get(k) != null){  // 이미 map에 들어가있는 카드라면 개수를 갱신
                map.put(k, map.get(k)+1);
            }else{
                map.put(k, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for(int i = 0; i < M; i++){
            int find = Integer.parseInt(input[i]);

            if(map.get(find) != null){ // 찾아야한느 숫자카드가 존재한다면 개수를 입력
                 sb.append(map.get(find)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);


    }
}
