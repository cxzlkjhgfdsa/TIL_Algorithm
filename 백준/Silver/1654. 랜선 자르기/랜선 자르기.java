import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] cables = new int[K];

        long min = 0;
        long max = 0; // 최장 케이블 길이

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        max++; //

        while (min < max) {

            long mid = (min + max) / 2;
            long sum = 0;

            for(int c : cables){
                sum += (c/mid);
            }

            if(sum < N){
                max = mid;
            }else{
                min = mid+1;
            }

        }

        System.out.println(min-1);
    }
}
