import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        Map<String, Integer> map = new LinkedHashMap<>(); // 단어들의 정보를 저장할 맵

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.length() < M)
                continue;
            if(map.get(s) != null){
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }

        }

        PriorityQueue<Word> que = new PriorityQueue<Word>(); // 단어의 우선순위를 매길 PQ

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            que.add(new Word(entry.getKey(), entry.getKey().length() ,entry.getValue()));
        }

        while(!que.isEmpty()){
            sb.append(que.poll().word).append("\n");
        }

        System.out.println(sb);
    }

    static class Word implements Comparable<Word>{ // 단어의 우선순위를 매김
        String word;
        int length, count;

        public Word(String word, int length, int count) {
            this.word = word;
            this.count = count;
            this.length = length;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count == o.count){
                if(this.length == o.length){
                    for(int i = 0; i < this.length; i++){
                        if(this.word.charAt(i) == o.word.charAt(i))
                            continue;
                        return this.word.charAt(i) - o.word.charAt(i);
                    }
                    return 0;
                }
                return o.length - this.length;
            }
            return o.count - this.count;
        }
    }
}
