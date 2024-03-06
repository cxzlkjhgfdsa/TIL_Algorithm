import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.next().split("");
        Queue<String> que = new ArrayDeque<>();

        int zero = 0;
        int one = 0;

        for(String s : str){
            if(s.equals("0"))
                zero++;
            else
                one++;
            que.add(s);
        }

        zero /= 2;
        one /= 2;

        String temp = "";

        while(!que.isEmpty()){

            String cur = que.poll();

            if(one > 0 && cur.equals("1")){
                one--;
                continue;
            }

            temp += cur;

        }

        Stack<String> stack = new Stack<>();

        String[] k = temp.split("");

        for(int i = k.length-1; i >=0; i--){
            if(zero > 0 && k[i].equals("0")){
                zero--;
                continue;
            }
            stack.add(k[i]);
        }

        String ans = "";

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        System.out.println(ans);


    }
}
