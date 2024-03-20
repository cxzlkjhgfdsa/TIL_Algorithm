import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(String next : input){
                pq.add(Integer.parseInt(next));
            }

        }

        for(int i = 0; i < N-1; i++){
            pq.remove();
        }

        System.out.println(pq.poll());
    }
}
