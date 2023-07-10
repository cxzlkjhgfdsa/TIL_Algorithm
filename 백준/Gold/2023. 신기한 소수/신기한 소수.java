import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String [] last = {"1", "3", "5", "7", "9"};
        Queue<String> que = new ArrayDeque<>();

        int N = sc.nextInt();

        que.offer("2");
        que.offer("3");
        que.offer("5");
        que.offer("7");

        for(int i=1; i<N; i++){
            int size = que.size();
            for(int j=0; j<size; j++){
                for(int k=0; k<5; k++){
                    que.offer(que.peek()+last[k]);
                }
                que.remove();
            }

            size = que.size();

            for(int j=0; j<size; j++){
                String sosu = que.poll();

                if(checkSosu(Integer.parseInt(sosu))){
                    que.offer(sosu);
                }

            }
        }
        while (!que.isEmpty()){
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);
    }

    static boolean checkSosu(int num){

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
