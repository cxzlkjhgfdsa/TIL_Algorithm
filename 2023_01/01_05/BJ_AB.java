import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_AB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;

        input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int ans =1;

        while (true){
            if(A==B){
                break;
            }
            if(A>B){
                ans = -1;
                break;
            }
            if(B%2!=0 && B%10!=1){
                ans = -1;
                break;
            }
            if(B%2==0){
                B=B/2;
            }else{
                B = (B-1)/10;
            }
            ans++;
        }
        System.out.println(ans);
    }

}
