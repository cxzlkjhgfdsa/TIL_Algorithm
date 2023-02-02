import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_신기한소수 {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String [] last = {"1", "3", "5", "7", "9"};  // 신기한 소수의 성질상 2번째 자리부터는 1, 3, 5, 7, 9로만 이루어져 있어야함
        Queue<String> que = new ArrayDeque<>();

        int N = sc.nextInt();
        // 신기한 소수의 성질 때문에 시작 자리는 2, 3, 5, 7 중 하나
        que.offer("2");
        que.offer("3");
        que.offer("5");
        que.offer("7");

        for(int i=1; i<N; i++){  //N-1번 반복
            int size = que.size();
            for(int j=0; j<size; j++){
                for(int k=0; k<5; k++){
                    que.offer(que.peek()+last[k]); // 신기한 소수인걸 확인하기위해 i번쨰 자리까지 소수인걸 확인한 수에 + 1,3,5,7,9 를 붙여 다시확인
                }
                que.remove();
            }

            size = que.size();

            for(int j=0; j<size; j++){
                String sosu = que.poll();

                if(checkSosu(Integer.parseInt(sosu))){  // i번째 자리까지 확인했을때 소수면 다시 que에 넣음
                    que.offer(sosu);
                }

            }
        }
        while (!que.isEmpty()){
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);  // 출력
    }

    static boolean checkSosu(int num){ // 소수인지 확인하는 메소드

        for(int i=2; i<=Math.sqrt(num); i++){  // 소수의 성질 -> 2~소수의 제곱근 의 수로 나누어 떨어지지 않는다
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
