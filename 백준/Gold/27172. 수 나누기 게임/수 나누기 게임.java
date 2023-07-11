import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[] nums = new int[N];
        int max = 0;

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
            max = Math.max(nums[i], max);
        }

        int[] pos = new int[max + 1];
        for(int i=0; i<N; i++){
            pos[nums[i]] = i+1;
        }

        for(int i : nums){
            for(int j = i * 2; j <=max; j+= i){
                if(pos[j] != 0){
                    score[pos[i]]++;
                    score[pos[j]]--;
                }
            }
        }


        for(int k=1; k<=N; k++){
            sb.append(score[k]).append(" ");
        }

        System.out.println(sb);

    }



}
