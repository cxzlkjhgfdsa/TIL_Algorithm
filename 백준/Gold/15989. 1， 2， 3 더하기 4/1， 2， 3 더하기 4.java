import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[10001][4];  // dp [ 숫자 ] [ 구성 숫자 (ex -> 1,2,3 ) ]

        /**
         *  1 -> [1]  : 1은 1로밖에 구성이 안됨 따라서 dp[1][1] = 1 , dp[1][2] = 0, dp[1][3] = 0
         *  2 -> [1, 1] , [2] : 2 는 1 1 또는 2 로 구성됨 따라서 dp[2][1] = 1 , dp[2][2] = 1, dp[2][3] = 0
         *  3 -> [1, 1, 1], [2, 1], [3] : 3은 1 1 1, 2 1 , 3 으로 구성된다 따라서 dp[3][1] = 1, dp[3][2] = 1, dp[3][3] = 1
         *
         *  4 -> 1 + [1, 1, 1]
         *       2 + [1, 1] , 2 + [2]
         *       3 + [1]
         *       4는 위와 같이 표현될 수 4가지로 표현될 수 있다 5 를 한번 보도록 하자
         *
         *  5 -> 1 + [1, 1, 1, 1]
         *       2 + [1, 1, 1 ] , [2, 1]
         *       3 + [1, 1], [2]
         *
         *       여기까지 봤으면 점화식을 하나 떠올릴 수 있다
         *  A[n][1] = A[n-1][1];
         *  A[n][2] = A[n-2][1] + A[n-2][2];
         *  A[n][3] = A[n-3][1] + A[n-3][2] + A[n-3][1];
         *
         *  n 번째에서 나올 수 있는 가지수는 A[n][1] + A[n][2] + A[n][3]
         *
         *  왜 이런 식이 나올 수 있는 것일까?
         *  N 번째 숫자가 가지는 구성요소를 생각해보자
         *  1만을 구성요소로  N을 만드는 방법은 1을 N 번 쓰는것 즉 A[N-1][1] 에 1을 추가해서 만든 것과 같다
         *  2 를 구성요로소 포함하고 있는 N을 만드는 방법은 A[N-2] 번 째의 A[N-2][1] 과 A[N-2][2] 로 표현 가능함 ( 이미 2가 있기 때문에 1, 2 둘다 가능 )
         *  3 을 구성요소로 포함하고 있는 N을 만드는 방법은 마찬가지로 A[N-3][1] + A[N-3][2] + A[N-3][3] 이 된다
         */
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < 10001; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            sb.append(dp[n][1]+dp[n][2]+dp[n][3]+"\n");
        }
        System.out.println(sb);
    }
}
