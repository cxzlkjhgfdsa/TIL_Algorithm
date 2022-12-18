import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  //카드의 개수
        Queue<Integer> que = new ArrayDeque<>();  // 카드를 저장할 que

        for(int i=1; i<=N; i++){
            que.offer(i);   // 카드에 번호를 que에 저장
        }

        if(N==1){                   // 카드가 한장이면 그냥 1 출력
            System.out.println(1);  
            System.exit(0);   
        }

        while (true){
            que.poll();    // 맨위에 한장 버리고
            que.offer(que.poll()); // 다시 맨위에 있는 카드를 맨 밑으로 넣는 작업
            if(que.size()==1){  // 카드가 1장만 남았으면 종료
                break;
            }
        }

        System.out.println(que.poll());
    }
}
