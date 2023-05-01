import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        long ans = pow((long)A, (long)B);

        System.out.println((int)ans);


    }
    static long pow(long a, long b){
        if(b==1){
            return A%C;
        }

        long mid = pow(a , b/2);

        if(b%2==0){
            return mid %C * mid % C;
        }else{
            return mid %C * mid %C * a % C;
        }


    }
}
