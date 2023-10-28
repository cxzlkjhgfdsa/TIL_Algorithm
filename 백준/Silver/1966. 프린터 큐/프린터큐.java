import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{

    static class paper{
        int index, important;

        public paper(int index, int important){
            this.index = index;
            this.important = important;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){

            input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");

            Queue<paper> que = new ArrayDeque<>();
            int[] counts = new int[10];

            for(int i=0; i<N; i++){
                int impo = Integer.parseInt(input[i]);
                que.add(new paper(i, impo));
                counts[impo]++;
            }
            int answer = 0;

            while(!que.isEmpty()){
                paper p = que.poll();
                boolean check = true;
                for(int i=p.important+1; i<=9; i++){
                    if(counts[i]>0){
                        check = false;
                    }
                }

                if(check){
                    answer ++;
                    counts[p.important]--;
                    if(p.index == M){
                        break;
                    }
                }else{
                    que.add(p);
                }


            }
            System.out.println(answer);
        }
    }
}
