import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(64);
        int sum = 64;

        while(sum != N){
            int cur = pq.poll();
            int half = cur/2;

            if(sum - half >= N){
                sum -= half;
                pq.add(half);
            }else{
                pq.add(half);
                pq.add(half);
            }
        }


        System.out.println(pq.size());
    }
}
