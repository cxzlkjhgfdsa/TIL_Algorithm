import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(input[i]));
        }

        int M = Integer.parseInt(br.readLine());

        input  = br.readLine().split(" ");

        for(int i = 0; i < M; i++){
            if(set.contains(Integer.parseInt(input[i])))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");

        }

        System.out.println(sb);

    }
}
