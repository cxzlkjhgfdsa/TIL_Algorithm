import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] s = sc.next().split("");

        int ans = 0;

        for(int tc = 0; tc < N-1; tc ++){

            Map<String, Integer> temp = new HashMap<>();
            for(String next : s){
                if(temp.get(next) != null){
                    temp.put(next, temp.get(next) + 1);
                }else{
                    temp.put(next, 1);
                }
            }

            String[] cur = sc.next().split("");
            int count = 0;

            for(String next : cur){
                if(temp.get(next) != null){
                    if(temp.get(next) == 1){
                        temp.remove(next);
                    }else{
                        temp.put(next, temp.get(next) -1);
                    }
                }else{
                    count++;
                }
            }

//            for(Map.Entry<String, Integer> entry : temp.entrySet()){
//                System.out.println(entry.getKey() +" : " + entry.getValue());
//            }

            //System.out.println(temp.size() +" : " + count);

            if(temp.size() < 2 && count < 2)
                ans++;

        }
        System.out.println(ans);

    }
}
