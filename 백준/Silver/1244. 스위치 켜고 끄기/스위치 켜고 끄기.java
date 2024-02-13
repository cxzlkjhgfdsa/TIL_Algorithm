import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];

        int N = Integer.parseInt(br.readLine());

        int sw[] = new int[N+1];
        input = br.readLine().split(" ");
        for (int i=1; i<=N; i++){
            sw[i]=Integer.parseInt(input[i-1]);
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            int sex = Integer.parseInt(input[0]);
            int idx = Integer.parseInt(input[1]);

            switch (sex){
                case 1:
                    for(int j=1; j<=N; j++){
                        if(j%idx==0){
                            sw[j]^=1;
                        }
                    }
                    break;
                case 2:
                    sw[idx]^=1;
                    int cnt=1;
                    while(true){
                        if(idx+cnt>N || idx-cnt<=0 || sw[idx-cnt]!=sw[idx+cnt])
                            break;

                        sw[idx-cnt]^=1;
                        sw[idx+cnt]^=1;
                        cnt++;

                    }
                    break;
            }
        }
        for(int i=1; i<=N; i++){
            System.out.print(sw[i]+" ");
            if((i)%20==0) {
                System.out.println("");
            }
        }

    }
}
