import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] trees = new int[N];
        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(trees); // 정렬

        int idx = N-1;
        int total = 0;


        for (int i = trees[N-1]-1; i>=0; i--){ // 가장 높이가 높은 나무 - 1 높이부터 자르기 시작
            while(true){
                if(idx < 0 || trees[idx] <= i){
                    idx++;
                    break;
                }
                idx--;
            }
            //System.out.println(i+" == "+(N-idx) +" idx = " +idx);
            total += (N-idx);

            if(total>= M){
                System.out.println(i);
                break;
            }

        }
    }
}
