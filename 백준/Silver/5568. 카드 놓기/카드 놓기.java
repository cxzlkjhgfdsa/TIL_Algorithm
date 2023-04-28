import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int[] arr;
    static int n, k;
    static int answer;
    static Map<String, String> map;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        answer = 0;
        map = new HashMap<>();

        arr = new int[n];
        nums = new int[k];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        perm( 0);

        System.out.println(answer);

    }

    public static void perm(int cnt){
        if(cnt == k){
            String s = "";
            for(int i=0; i<k; i++){
                s += nums[i];
            }
            if(map.get(s)== null){
                map.put(s, s);
                answer++;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            nums[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
