import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] input;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            stack.clear();
            input = br.readLine().split("");
            for(String s : input){
                if(s.equals("(")){
                    stack.add("(");
                }else if(s.equals(")")){
                    if(stack.size()>0){
                        if(stack.peek().equals("(")){
                            stack.pop();
                        }else {
                            stack.add(")");
                            break;
                        }
                    }else{
                        stack.add(")");
                        break;
                    }

                }

            }

            if(stack.size() > 0){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }

        }
        System.out.println(sb);
    }
}
