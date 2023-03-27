import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static class candidate{
        int no, cnt;
        public candidate(int no, int cnt) {
            this.no = no;
            this.cnt = cnt;
        }
    }
    static int N;
    static List<candidate> vote = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        N = Integer.parseInt(br.readLine());  // 후보 틀 수
        int S = Integer.parseInt(br.readLine());  // 학생 수

        input = br.readLine().split(" ");

        int[] n = new int[input.length];
        for(int i=0; i<input.length; i++){
            n[i] = Integer.parseInt(input[i]);
        }

        for(int v : n){
            voting(v);
        }
        int[] answer = new int[vote.size()];
        for(int i=0; i<vote.size(); i++){
            answer[i] = vote.get(i).no;
        }

        Arrays.sort(answer);

        for(int mum : answer){
            sb.append(mum+" ");
        }
        System.out.println(sb);

    }

    public static void voting(int n){
        boolean isAdd = true;
        int size = vote.size();
        if(size>=1) {
            for (int i = size-1; i >= 0; i--) {
                candidate c = vote.get(i);
                if (c.no == n) {
                    c.cnt++;
                    isAdd = false;
                    break;
                }
            }
        }
        if(isAdd){
            if(size>=N){
                delete();
            }
            vote.add(new candidate(n, 1));
        }
    }

    public static void delete(){
        int index = -1;
        int min = 10000;
        for(int i=vote.size()-1; i>=0; i--){
            if(vote.get(i).cnt<=min){
                index = i;
                min = vote.get(i).cnt;
            }
        }
        vote.remove(index);
    }
}
