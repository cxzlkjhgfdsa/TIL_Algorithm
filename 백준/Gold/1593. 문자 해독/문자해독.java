import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        String W;
        String S;
        int[] WArr = new int[58];
        int[] SArr = new int[58];
        int answer = 0;

        input = br.readLine().split(" ");
        int g = Integer.parseInt(input[0]);
        int sLen = Integer.parseInt(input[1]);

        W = br.readLine();
        for(int i=0; i<g; i++){
            int a = W.charAt(i) - 'A';
            WArr[a]++;
        }

        S = br.readLine();

        for(int i=0; i<g; i++){
            int a = S.charAt(i) - 'A';
            SArr[a]++;
        }

        if(Arrays.equals(SArr, WArr))
            answer++;

        for(int i=g; i<sLen; i++){
            int before = S.charAt(i-g) - 'A';
            int after = S.charAt(i) - 'A';

            SArr[before]--;
            SArr[after]++;

            if(Arrays.equals(SArr, WArr))
                answer++;
        }

        System.out.println(answer);
    }
}
