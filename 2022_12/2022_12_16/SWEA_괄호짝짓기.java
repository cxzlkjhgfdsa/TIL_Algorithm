import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_괄호짝짓기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            input = br.readLine().split("");
            Stack<String> stack = new Stack<>();  //괄호 짝 여부 확인을 위한 스택
            for(int i=0; i<T; i++){
                if(stack.isEmpty()){  // 스택이 비어있으면 집어넣고 패스
                    stack.push(input[i]);
                    continue;
                }
                if(check(stack.peek(), input[i])){ // 짝이 맞는지 확인 맞을시
                    stack.pop();   // 스택에서 제거
                }else{  // 아닐시
                    stack.push(input[i]);  // 스택에 추가
                }

            }

            if(stack.size()==0){  // 스택이 비어있으면 전부 짝이 맞는거
                sb.append("#").append(tc).append(" 1\n");
            }else{  // 스택이 비어있지 않으면 짝이 맞지 않는것
                sb.append("#").append(tc).append(" 0\n");
            }

        }
        System.out.println(sb);
    }

    public static boolean check(String a, String b){  // 짝이 맞는지 확인하는 메소드

        if(a.equals("[")){
            if(b.equals("]")){
                return true;
            }else{
                return false;
            }
        }else if(a.equals("{")){
            if(b.equals("}")){
                return true;
            }else{
                return false;
            }
        }else if(a.equals("(")){
            if(b.equals(")")){
                return true;
            }else{
                return false;
            }
        }else if(a.equals("<")){
            if(b.equals(">")){
                return true;
            }else{
                return false;
            }

        }

        return false;
    }
}
