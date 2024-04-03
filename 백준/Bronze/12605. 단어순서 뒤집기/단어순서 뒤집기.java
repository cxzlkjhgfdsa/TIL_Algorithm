import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for(int tc = 1; tc <= n; tc++){

            input = br.readLine().split(" ");

            for(String s : input){
                stack.push(s);
            }

            bw.write("Case #"+tc+": ");
            while(!stack.isEmpty()){

                bw.write(stack.pop()+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
