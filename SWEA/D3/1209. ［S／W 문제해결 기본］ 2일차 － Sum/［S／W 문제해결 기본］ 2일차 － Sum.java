import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        for(int tc = 1; tc <= 10; tc++){
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++){
                input = br.readLine().split(" ");
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }
            int ans = 0;
            
            for(int i = 0; i < 100; i++){
                int sum1 = 0;
                int sum2 = 0;
                
                for(int j = 0; j < 100; j++){
                    sum1+= arr[i][j];
                    sum2+= arr[j][i];
                }
                
                ans = Math.max(sum1, ans);
                ans = Math.max(sum2, ans);
            }
            
            int a = 0; 
            int b = 0;
            int c = 99;
            int d = 0;
            int sum1 = 0;
            int sum2 = 0;
            
            for(int i = 0; i < 100; i++){
                sum1+= arr[a][b];
                sum2+= arr[c][d];
                
                a++;
                b++;
                c--;
                d++;
                
            }
            
            ans = Math.max(ans, sum1);
            ans = Math.max(ans, sum2);

            System.out.println("#"+tc+" "+ans);
        }

    }
}
