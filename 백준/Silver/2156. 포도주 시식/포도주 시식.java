import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] juice = new int[n];

        for(int i = 0; i < n; i++){
            juice[i] = sc.nextInt();
        }

        int[][] D = new int[n][3];
        D[0][1] = juice[0];

        for(int i = 1; i < n; i++){

            D[i][0] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][2]);
            D[i][1] = D[i-1][0] + juice[i];
            D[i][2] = D[i-1][1] + juice[i];

        }


        System.out.println(Math.max(Math.max(D[n-1][0], D[n-1][1]), D[n-1][2]));

    }
}
