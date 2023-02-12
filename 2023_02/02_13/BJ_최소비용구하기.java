import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_최소비용구하기 {

    static class city implements Comparable<city> {
        int idx, dist;

        public city(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(city o) {
            return this.dist-o.dist;
        }
    }

    static int N, M, A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ArrayList<city>[] maps = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            maps[i] = new ArrayList();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);

            maps[start].add(new city(end, dist));
        }

        input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        int max = 100000*(N-1)+1;

        int [] D = new int[N+1];
        Arrays.fill(D, max);
        boolean [] visited = new boolean[N+1];
        PriorityQueue<city> pq = new PriorityQueue<>();
        pq.offer(new city(A, 0));
        D[A] = 0;

        while (!pq.isEmpty()){
            int current = pq.poll().idx;

            if(visited[current]){
                continue;
            }

            visited[current] = true;

            for(city next : maps[current]){
                if(D[next.idx] > D[current]+ next.dist){
                    D[next.idx] = D[current] + next.dist;
                     pq.offer(new city(next.idx, D[next.idx]));
                }
            }
        }
        System.out.println(D[B]);

    }
}
