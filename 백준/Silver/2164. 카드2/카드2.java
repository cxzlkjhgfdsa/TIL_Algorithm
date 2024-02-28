import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        Queue<Integer> que = new ArrayDeque<>(); // 로직을 수행하기 위한 큐
        for(int i = 1; i<=N; i++){
            que.add(i);
        }
        
        while(que.size() > 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.poll());
        
        
    }
}
