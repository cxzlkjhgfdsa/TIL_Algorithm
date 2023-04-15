import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int T = Integer.parseInt(br.readLine());
        int[] stairs = new int[T];

        for (int i = 0; i < T; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 1 -> 전 계단을 밟음, 0-> 전계단을 밟지 않음

        if(T == 1){
            System.out.println(stairs[0]);
            System.exit(0);
        }else if(T ==2){
            System.out.println(stairs[0] + stairs[1]);
            System.exit(0);
        }

        int[][] D = new int[T][2];
        D[0][0] = stairs[0];
        D[0][1] = stairs[0];
        D[1][0] = stairs[1];
        D[1][1] = stairs[1] + stairs[0];

        for(int i=2; i<T; i++){
            D[i][0] = Math.max(D[i-2][0], D[i-2][1]) + stairs[i];
            D[i][1] = D[i-1][0] + stairs[i];
        }


        int answer = Math.max(D[T-1][0], D[T-1][1]);

        System.out.println(answer);

    }
}
