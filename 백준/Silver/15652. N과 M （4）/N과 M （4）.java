import java.util.Scanner;

public class Main {
    static int N, M;

    static StringBuilder sb = new StringBuilder();
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        num = new int[M];
        combi(1,0);
        System.out.println(sb);
    }

    private static void combi( int start, int cnt) {
        if(cnt==M){
            for(int i=0; i<num.length; i++){
                System.out.print(num[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<=N; i++){
            num[cnt] = i;
            combi(i, cnt + 1);

        }

    }
}
