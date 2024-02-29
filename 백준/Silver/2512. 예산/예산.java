import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        input = br.readLine().split(" ");

        int sum = 0; // 지방 예산 요청 총합
        int max = 0; // 가장 큰 예산 요청

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        if(sum <= M){
            System.out.println(max);
        }else{
            int start = 0;
            int end = max;

            while(start < end){

                int middle = (start + end) / 2;
                int total = 0;


                for(int i = 0; i < N; i++){
                    if(arr[i] < middle){
                        total += arr[i];
                    }else{
                        total += middle;
                    }
                }

                //System.out.println(middle + " " + total);

                if(total > M){
                    end = middle;
                }else {
                    start = middle + 1;
                }

            }

            System.out.println(start-1);

        }

    }
}
