import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int idx = 0;
        int num = 1;

        while(num <= 30000){


            String cur = String.valueOf(num);

            for(int i = 0; i < cur.length(); i++){
                if(s.charAt(idx) == cur.charAt(i)){
                    idx++;
                }

                if(idx == s.length()){
                    System.out.println(num);
                    System.exit(0);
                }
            }

            num++;
        }
    }
}
