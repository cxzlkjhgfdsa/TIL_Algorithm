import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class thing implements Comparable<thing>{
        int weight, value;

        public thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(thing o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        thing [] things = new thing[N+1];
        int [][] D = new int[N+1][K+1];


        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            things[i] = new thing(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(things[i].weight<=j){
                    D[i][j] = Math.max(D[i-1][j], D[i-1][j-things[i].weight]+things[i].value);
                }else{
                    D[i][j] = D[i-1][j];
                }
            }
        }

        System.out.println(D[N][K]);
    }
}
