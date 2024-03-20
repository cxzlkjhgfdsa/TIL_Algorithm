import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        List<Pillar> list = new ArrayList<>();

        int maxH = 0;  // 가장 높은 기둥의 높이
        int maxIdx = 0; // 가장 높은 기둥이 몇번 째 기둥인지

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            Pillar p = new Pillar(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            list.add(p);
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++){
            if(list.get(i).height >= maxH){
                maxH = list.get(i).height;
                maxIdx = i;
            }
        }

        int ans = 0;

        int curIdx = list.get(0).left;
        int curH = list.get(0).height;


        if(maxIdx != 0){

            for(int i = 1; i <= maxIdx; i++){

                if(list.get(i).height >= curH){

                    ans += ((list.get(i).left - curIdx) * curH);
                    curH = list.get(i).height;
                    curIdx = list.get(i).left;

                }

            }

        }

        curIdx = list.get(N-1).left;
        curH = list.get(N-1).height;

        if(maxIdx != N-1){

            for(int i = N-2; i>= maxIdx; i--){
                if(list.get(i).height >= curH){

                    ans += ((curIdx - list.get(i).left) * curH);
                    curH = list.get(i).height;
                    curIdx = list.get(i).left;

                }

            }

        }

        ans += maxH;

        System.out.println(ans);



    }

    static class Pillar implements Comparable<Pillar>{
        int height, left;
        public Pillar(int left, int height){
            this.left = left;
            this.height = height;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.left - o.left;
        }
    }
}
