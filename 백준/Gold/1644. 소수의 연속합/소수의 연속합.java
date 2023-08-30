import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numbers = new int[4000001];

        for(int i=0; i<4000001; i++){
            numbers[i] = i;
        }

        for(int i=2; i<2000001; i++){
            if(numbers[i] ==0)
                continue;

            for(int j=i*2; j<4000001; j+=i){
                numbers[j] = 0;
            }
        }

        ArrayList<Integer> decimal = new ArrayList<>();
        for(int i=2; i<4000001; i++){
            if(numbers[i] != 0)
                decimal.add(i);
        }

        int start = 0;
        int end = 1;

        int ans = 0;
        //int sum = decimal.get(start) + decimal.get(end);

        for(int i=0; i<decimal.size(); i++){
            int sum = 0;
            for(int j=i; j<decimal.size(); j++){
                sum += decimal.get(j);
                if(sum > N)
                    break;
                if(sum == N) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}
