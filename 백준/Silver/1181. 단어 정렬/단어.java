import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        PriorityQueue<Word> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        for(String s : set){
            pq.add(new Word(s));
        }

        while (!pq.isEmpty()){
            sb.append(pq.poll().w).append("\n");
        }
        System.out.println(sb);


    }

    private static class Word implements Comparable<Word>{
        String w;
        public Word(String s){
            this.w = s;
        }

        @Override
        public int compareTo(Word w){
            if(this.w.length() == w.w.length()){
                for(int i=0; i<this.w.length(); i++){
                    int a = this.w.charAt(i) - 'a';
                    int b = w.w.charAt(i) - 'a';

                    if(a != b){
                        return a - b;
                    }
                }
            }
            return this.w.length() - w.w.length();
        }


    }
}
