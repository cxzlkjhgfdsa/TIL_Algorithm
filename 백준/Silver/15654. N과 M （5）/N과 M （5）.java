import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int N, M;

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] num;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        nums = new int[N];
        visited = new boolean[N];

        for(int i=0; i<input.length; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        num = new int[M];
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(cnt==M){
            for(int i=0; i<num.length; i++){
                //sb.append(num[i]).append(" ");
                System.out.print(num[i] + " ");
            }
            System.out.println();
            //sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                num[cnt] = nums[i];
                visited[i] = true;
                perm(cnt + 1);
                visited[i] = false;
            }
        }

    }
}
