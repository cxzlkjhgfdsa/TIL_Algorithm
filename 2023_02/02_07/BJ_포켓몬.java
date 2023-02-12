import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_포켓몬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> sItem = new HashMap<>();
        Map<Integer, String > Item = new HashMap<>();

        for(int i=1; i<=n; i++){
            String s = br.readLine();
            sItem.put(s, i);
            Item.put(i, s);
        }

        for(int i=1; i<=m; i++){
            String s = br.readLine();
            if(isNumber(s)){
                sb.append(Item.get(Integer.parseInt(s))+"\n");
            }else{
                sb.append(sItem.get(s)+"\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
