import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] numArr;
    static int[] combArr;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        numArr = new int[N];
        combArr = new int[M];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            numArr[i] = Integer.parseInt(input[i]);
        }

        visited = new boolean[N];
        Arrays.sort(numArr);
        perm(0);
        for(String s : ans){
            System.out.println(s);
        }

    }
    static void perm(int cnt){
        if(cnt >= M){

            String s = "";
            for(int i=0 ;i<M; i++){
                s+=combArr[i]+" ";
            }
            ans.add(s);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]){
                continue;
            }
            combArr[cnt] = numArr[i];
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
