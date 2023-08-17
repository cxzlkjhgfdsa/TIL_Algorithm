import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int[] answer = new int[2]; // 정답이 들어갈 배열

        int N = Integer.parseInt(br.readLine()); // 용약의 수
        int[] water = new int[N]; // 용액들의 특성값이 들어갈 배열

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
           water[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = N-1;
        int min = Math.abs(water[start] + water[end]);
        int a_idx = 0;
        int b_idx = N-1;

        while(start < end){
            int cur = water[start] + water[end];
            int abs = Math.abs(cur);

            if(abs < min){
                a_idx = start;
                b_idx = end;
                min = abs;
            }

            if(cur < 0){
                 start++;
            }else{
                end--;
            }
        }

        System.out.println(water[a_idx]+" "+water[b_idx]);
    }
}
