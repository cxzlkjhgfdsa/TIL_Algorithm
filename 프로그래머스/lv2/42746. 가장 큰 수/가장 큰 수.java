import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<bigNum> que = new PriorityQueue<bigNum>();
        for(int n : numbers){
            que.add(new bigNum(n));
        }
        
        String answer = "";
        if(que.peek().num == 0){
            answer += "0";
        }else{
           while(!que.isEmpty()){
            answer += que.poll().num+"";
            }      
        }
        
        return answer;
    }
}

class bigNum implements Comparable<bigNum> {
    int num;

    public bigNum(int num) {
        this.num = num;

    }


    @Override
    public int compareTo(bigNum o) {
        String a = o.num + "";
        a+=this.num;
        String b = this.num + "";
        b+=o.num;
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        if(x < y){
            return -1;
        }else{
            return 1;
        }

    }
}
