import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Oil> que = new PriorityQueue<>();
        int[] distance = new int[N];
        int[] price = new int[N];
        input = br.readLine().split(" ");

        for(int i = 0; i < N-1; i++){
            distance[i+1] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(input[i]);
            que.add(new Oil(i, price[i]));
        }

        boolean[] visited = new boolean[N];

        long ans = 0;

        while(!que.isEmpty()){

            Oil o = que.poll();

            if(o.idx == N-1)
                continue;

            long sum = 0;

            for(int i = o.idx+1; i < N; i++){
                if(visited[i])
                    continue;
                sum += distance[i];
                visited[i] = true;
            }

            //System.out.println(sum + " : " + o.price);

            ans += (sum * o.price);

        }

        System.out.println(ans);

    }

    static class Oil implements Comparable<Oil>{
        int idx, price;
        public Oil(int idx, int price){
            this.idx =idx;
            this.price = price;
        }

        @Override
        public int compareTo(Oil o) {
            if(o.price == this.price){
                return this.idx - o.idx;
            }
            return this.price - o.price;
        }
    }
}
