import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];
        boolean destroyed[] = new boolean[10];

        int target = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int ans = Math.abs(100-target);

        if(N==0){
            if(Integer.toString(target).length()<ans)
                System.out.println(Integer.toString(target).length());
            else{
                System.out.println(ans);
            }
            System.exit(0);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            destroyed[Integer.parseInt(input[i])] = true;
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<=999999; i++){
            String s = Integer.toString(i);
            boolean tg=true;

            for(int j=0; j<s.length(); j++){
                if(destroyed[s.charAt(j)-'0']){
                    tg=false;
                    break;
                }
            }

            if(!tg)
                continue;

            int cnt = s.length() + Math.abs(i-target);

            if(cnt<min)
                min = cnt;

        }
        //System.out.println(min);
        if(min < ans){
            ans = min;
        }

        System.out.println(ans);

    }

}
