import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    static class meet implements Comparable<meet> {
        int start, end;

        public meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(meet meet) {
            if (meet.end == this.end)
                return this.start - meet.start;
            return this.end - meet.end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<meet> pq = new PriorityQueue<meet>();
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            pq.add(new meet(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Stack<meet> stack = new Stack<>();
        stack.add(pq.poll());
        while(!pq.isEmpty()){
            meet m = pq.poll();
            if(m.start>=stack.peek().end){
                stack.add(m);
            }else{
                continue;
            }
        }
        System.out.println(stack.size());


    }

}
