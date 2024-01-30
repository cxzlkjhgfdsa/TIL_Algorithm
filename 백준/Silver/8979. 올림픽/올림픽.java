import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 국가의 수
        int K = Integer.parseInt(input[1]); // 등 수를 알고싶은 국가

        PriorityQueue<Medal> pq = new PriorityQueue<>(); // 국가의 등수를 알기위한 우선순위큐

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze =  Integer.parseInt(input[3]);
            pq.add(new Medal(idx, gold, silver, bronze)); // 국가의 메달정보를 입력받아 우선순위큐에 삽입
        }

        int no = 1; // 등수체크를 위한 변수
        int dup = 1; // 동 등수를 체크해서 등수에 더해주기위한 변수
        Medal before = pq.poll();

        if(before.idx == K){
            System.out.println(1);
        }else{
            while(!pq.isEmpty()){
                Medal cur = pq.poll();

                if(check(cur, before)){
                    dup++;
                }else{
                    no += dup;
                    dup = 1;
                }

                if(cur.idx == K){
                    System.out.println(no);
                    break;
                }

                before = cur;
            }
        }
    }

    private static boolean check(Medal m1, Medal m2){
        if(m1.g == m2.g && m1.s == m2.s && m1.b == m2.b)
            return true;
        return false;
    }
}

class Medal implements Comparable<Medal>{
    int idx, g, s, b; // 몇번째인지, 금, 은, 동 메달 개수
    public Medal(int idx, int g, int s, int b){
        this.idx = idx;
        this.g = g;
        this.s = s;
        this.b = b;
    }

    @Override
    public int compareTo(Medal o) {
        if(o.g == this.g){
            if(this.s == o.s)
                return o.b - this.b;
            return o.s - this.s;
        }
        return o.g - this.g;
    }
}



