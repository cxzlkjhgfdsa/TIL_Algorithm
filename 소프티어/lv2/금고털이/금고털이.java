import java.util.*;
import java.io.*;


public class 금고털이
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int W = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int ans = 0;

        PriorityQueue<Gem> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            pq.add(new Gem(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        while(W > 0){
            Gem g = pq.poll();
            if(g.weight <= W){
                ans += (g.price * g.weight);
                W -= g.weight;
            }else{
                ans += (g.price * (W));
                break;
            }
        }

        System.out.println(ans);


    }
}

class Gem implements Comparable<Gem>{
    int weight;
    int price;
    public Gem(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Gem g){
        return g.price - this.price;
    }

}