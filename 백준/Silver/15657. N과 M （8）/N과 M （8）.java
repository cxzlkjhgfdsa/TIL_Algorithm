import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] nums;
    static int[] comb;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        nums = new int[N];
        comb = new int[M];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);

        combi(0, 0);
        System.out.println(sb);
    }

    static void combi(int start, int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(comb[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<N; i++){
            comb[cnt] = nums[i];
            combi(i, cnt+1);
        }
    }


}
