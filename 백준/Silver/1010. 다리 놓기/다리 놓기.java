import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;
        int [][] comb = new int[30][30];

        for(int i=0; i<30; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    comb[i][j] = 1;
                }else{
                    comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            sb.append(comb[n][r]).append("\n");
        }

        System.out.println(sb);
    }
}
