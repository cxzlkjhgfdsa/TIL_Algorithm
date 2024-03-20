import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] nums;
    static int N;
    static int[] role;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        role = new int[N];
        visited = new boolean[N+1];

        for(int i = 0; i < N; i++){
            role[i] = sc.nextInt();
        }

        perm(0);

    }

    private static void perm(int cnt){

        if(cnt == N){
            if(check()){
                for(int i = 0; i < N; i++){
                    System.out.print(nums[i]+" ");
                }
                System.exit(0);
            }
            return;
        }


        for(int i = 1; i <=N; i++){

            if(visited[i])
                continue;

            nums[cnt] = i;
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;

        }
    }

    private static boolean check(){

        boolean ch = true;
        for(int i = 0; i < N; i++){
            int cur = nums[i];

            if(i == 0){
                if(role[cur-1] != 0){
                    ch = false;
                    break;
                }
            }
            int cnt = 0;
            for(int j = i-1; j >=0; j--){
                if(nums[j] > cur)
                    cnt++;
            }
            if(cnt != role[cur-1]){
                ch = false;
                break;
            }
        }

        return ch;
    }

}
