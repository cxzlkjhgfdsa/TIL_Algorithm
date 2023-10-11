import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        ArrayList<Integer> list = new ArrayList<>();

        input = br.readLine().split(" ");

        for(int j=0; j<n; j++){
            list.add(Integer.parseInt(input[j]));
        }
        
        input = br.readLine().split(" ");

        for(int j=0; j<n; j++){
            list.add(Integer.parseInt(input[j]));
        }

        for(int tc = 0; tc < t; tc++){
            int temp = list.get(n*2-1);
            list.remove(n*2-1);
            list.add(0, temp);
        }

        for(int i=0; i<n; i++){
            System.out.print(list.get(i)+" ");
        }

        System.out.println();

        for(int i=n; i<2*n; i++){
            System.out.print(list.get(i)+" ");
        }

    
    }
}