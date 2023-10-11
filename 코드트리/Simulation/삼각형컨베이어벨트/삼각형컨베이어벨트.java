import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);
        int lastIdx = n * 3 - 1;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(input[j]));
            }
        }

        for(int i = 0; i < t; i++){
            int temp = list.get(lastIdx);
            list.remove(lastIdx);
            list.add(0, temp);

        }

        list.add(0, 0);

        for(int i=1; i<=3*n; i++){
            System.out.print(list.get(i)+" ");
            if(i%n == 0 && i!= 0){
                System.out.println();
            }
        }

    }
}