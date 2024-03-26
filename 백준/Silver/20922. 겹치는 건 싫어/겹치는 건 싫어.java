import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        Map<String, Integer> map = new HashMap<>();

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int start = 0;
        int end = 1;
        map.put(input[start], 1);

        if(N == 1){
            System.out.println(1);
            System.exit(0);
        }

        int max = 0 ;

        while(end < N){

            if(map.get(input[end]) == null){
                map.put(input[end], 1);
            }else{

                map.put(input[end], map.get(input[end]) + 1);

                if(map.get(input[end]) > K){
                    while(start < end){

                        map.put(input[start], map.get(input[start]) - 1);
                        start++;
                        if(map.get(input[end]) <= K)
                            break;
                    }
                }

            }

            //System.out.println(start + " = " + end);

            max = Math.max(max, (end - start + 1));
            end++;
        }

        System.out.println(max);
    }
}
