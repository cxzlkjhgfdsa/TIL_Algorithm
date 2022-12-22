import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_사칙연산유효성검사 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;
        String check = "+-*/";

        for(int tc=1; tc<=10; tc++){
            int N = Integer.parseInt(br.readLine());
            boolean can = true;

            for(int i=0; i<N; i++){
                input = br.readLine().split(" ");

                if(check.contains(input[1])){
                    if(input.length!=4){
                        can = false;
                    }
                }else{
                    if(input.length>2){
                        can = false;
                    }
                }

            }

            if(can){
                sb.append("#").append(tc).append(" 1").append("\n");
            }else{
                sb.append("#").append(tc).append(" 0").append("\n");
            }
        }
        System.out.println(sb);

    }
}
