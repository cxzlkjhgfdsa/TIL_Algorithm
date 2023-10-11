import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Queue<Integer> boom = new ArrayDeque<>();
        Queue<Integer> storage = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            boom.add(Integer.parseInt(br.readLine()));
        }

        boolean isExploded = true;

        while(isExploded){
            isExploded = false;

            int size = boom.size();
            int cur = -1;

            for(int i = 0; i < size; i++){
                int n = boom.poll();

                if(cur == n){
                    storage.add(n);
                }else{
                    if(storage.size() >= M){
                        storage.clear();
                        storage.add(n);
                        isExploded = true;
                    }else{
                        int stSize = storage.size();
                        for(int j = 0; j < stSize; j++){
                            boom.add(storage.poll());
                        }
                        storage.add(n);
                    }
                    cur = n;
                }

            }

            int k = storage.size();

            if(k >= M){
                storage.clear();
            }else{
                for(int x = 0; x < k; x++){
                    boom.add(storage.poll());
                }
            }
            

        }   

        int count = boom.size();

        System.out.println(count);

        for(int i = 0; i < count; i++){
            System.out.println(boom.poll());
        }
    }
}