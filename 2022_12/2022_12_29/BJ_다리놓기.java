import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;
        int [][] comb = new int[30][30];  // nCr의 값을 저장하는 2차원 배열

        for(int i=0; i<30; i++){  // 0C0 ~ nCn 까지의 값을 점화식을 통해 얻는 반복문
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){  // nCr 에서 r이 0 이거나 n 이면 그 값이 1
                    comb[i][j] = 1;
                }else{
                    comb[i][j] = comb[i-1][j-1] + comb[i-1][j];  // nCr = n-1Cr + n-1Cr-1
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){  // 값 저장
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            sb.append(comb[n][r]).append("\n");
        }

        System.out.println(sb);
    }
}
