import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");

            if(input[0].equals("add")){
                map.put(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            }else if(input[0].equals("find")){
                if(map.get(Integer.parseInt(input[1])) == null){
                    System.out.println("None");
                }else{
                    System.out.println(map.get(Integer.parseInt(input[1])));
                }
            }else{
                map.remove(Integer.parseInt(input[1]));
            }

        }
    }
}