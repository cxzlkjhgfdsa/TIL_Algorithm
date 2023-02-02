import java.util.ArrayList;
import java.util.Scanner;

public class BJ_NQueen {
    static int ans, N;
    static int [] queen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = 0;
        queen = new int[N];  // queen[N] = i  퀸의 좌표가 (x, y)라고했을때  N = x , i = y
        
        NQueen(0);  // NQueen 개수를 구하기 위한 함수
        System.out.println(ans);
    }

    private static void NQueen(int cnt) {
        if(cnt == N){  // 퀸을 N개 놓았으면 답 ++ 
            ans++;
            return;
        }

        for(int i=0; i<N; i++){
            queen[cnt] = i;  // (cnt, i) 에 퀸을 놓음

            if(isCan(cnt)){  // 다음 퀸을 놓을 수 있는지 확인
                NQueen(cnt+1);
            }
        }
    }

    private static boolean isCan(int cnt) {  // 퀸을 놓을 수 있는지 확인하는 함수

        for(int i=0; i<cnt; i++){
            if(queen[cnt]==queen[i]){  // 0 열부터 cnt-1행까지 놓은 퀸들과 열이 겹치치 않는지 확인
                return false;
            }
            if(Math.abs(cnt-i) == Math.abs(queen[cnt]-queen[i])){  // 대각선에 놓여있지 않은지 확인
                return false;
            }

        }
        return true;
    }


}
