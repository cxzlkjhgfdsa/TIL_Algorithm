import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_123더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int [] D = new int[12];

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for(int i=4; i<=11; i++){
            D[i] = D[i-1]+D[i-2]+D[i-3];
        }

        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(D[N]+"\n");

        }

        System.out.println(sb);

    }
}
