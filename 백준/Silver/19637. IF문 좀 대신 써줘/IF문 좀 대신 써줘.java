import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        Map<Integer, String> map = new HashMap<>();

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] score = new int[N];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            score[i] = Integer.parseInt(input[1]);

            if(map.get(Integer.parseInt(input[1]))!= null)
                continue;

            map.put(Integer.parseInt(input[1]), input[0]);
        }

        for(int i = 0; i < M; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append(binarySearch(k, score, map)).append("\n");
        }
        System.out.println(sb);
    }

    private static String binarySearch(int cur, int[] score, Map<Integer, String> map){

        int left = 0;
        int right = score.length;

        while(left < right){

            int mid = (left+right) /2;

            if(cur <= score[mid] ){
                right = mid;
            }else{
                left = mid+1;
            }

        }


        return map.get(score[left]);
    }
}
