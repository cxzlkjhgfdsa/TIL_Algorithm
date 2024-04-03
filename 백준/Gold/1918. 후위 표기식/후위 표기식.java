import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input;

        Map<Character , Integer> map = new HashMap<>();

        init(map);

        input = br.readLine();
        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < input.length(); i++){

            char c = input.charAt(i);

            if(map.get(c) == null){
                sb.append(c);
            }else{
                if(map.get(c) == 0){
                    operator.push(c);
                    continue;
                }


                if(operator.isEmpty()){
                    operator.push(c);
                }else{

                    if(map.get(c) == 3){
                        while(true){
                            if(operator.peek() =='('){
                                operator.pop();
                                break;
                            }else{
                                sb.append(operator.pop());
                            }

                            if(operator.isEmpty())
                                break;
                        }
                        continue;
                    }

                    if(map.get(c) > map.get(operator.peek())){
                        operator.push(c);
                    }else{
                        while(map.get(c) <= map.get(operator.peek())){
                            if(operator.peek()== '('){
                                break;
                            }
                            sb.append(operator.pop());
                            if(operator.isEmpty())
                                break;
                        }
                        operator.push(c);
                    }

                }
            }

        }
        while (!operator.isEmpty()){
            sb.append(operator.pop());
        }
        System.out.println(sb.toString());

    }
    private static void init(Map<Character, Integer> map){
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put(')', 3);
    }
}
