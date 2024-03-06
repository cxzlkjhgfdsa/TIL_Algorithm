
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map =new HashMap<>();

        for(int i = 0; i < N; i++){
            map.put(br.readLine(), 1);
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(",");
            for(String s : input){
                if(map.get(s) != null){
                    map.remove(s);
                }
            }
            sb.append(map.size()).append("\n");
        }

        System.out.println(sb);

    }
}
