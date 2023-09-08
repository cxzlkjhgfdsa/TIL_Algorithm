import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int len = b.length() - a.length();
        int min = Integer.MAX_VALUE;

        for(int i=0; i<=len; i++){
            int sum = 0;
            for(int j=i; j<i+a.length(); j++){
                if(a.charAt(j-i) != b.charAt(j))
                    sum++;
            }

            min = Math.min(min, sum);
        }

        System.out.println(min);

    }
}
