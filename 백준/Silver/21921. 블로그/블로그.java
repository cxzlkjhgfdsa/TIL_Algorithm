import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int[] visitors = new int[N];

        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            visitors[i] = Integer.parseInt(input[i]);
        }

        int total = 0;

        for(int i = 0; i < X; i++){
            total += visitors[i];
        }

        int max = total;
        int maxCount = 1;
        int start = 0;
        int end = X;

        for(int i = 0; i < (N-X); i++){

            //System.out.println(total);

            total -= visitors[start];
            total += visitors[end];

            if(total > max){
                max = total;
                maxCount = 1;

            }else if(total == max){
                maxCount++;
            }

            start++;
            end++;

        }
        if(max == 0){
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(maxCount);
        }

    }
}
