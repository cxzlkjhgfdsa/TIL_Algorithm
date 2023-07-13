import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int N, M;

    static int find(int n){
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);

    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        if( x == y )
            return false;

        if(x <= y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
        return true;
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        int ans = 0;

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(!union(a, b)){
                ans = i+1;
                break;
            }
        }

        System.out.println(ans);
    }
}
