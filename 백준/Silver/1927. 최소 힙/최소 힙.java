import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> que = new PriorityQueue<>();

        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            int cur = sc.nextInt();

            if(cur == 0){
                if(que.size() == 0)
                    sb.append(0).append("\n");
                else
                    sb.append(que.poll()).append("\n");
            }else{
                que.add(cur);
            }
        }

        System.out.println(sb);
    }

}
