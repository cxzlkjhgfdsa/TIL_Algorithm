import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Num> que = new ArrayDeque<>();
        que.offer(new Num(y, 0));
        while(!que.isEmpty()){
            Num c = que.poll();
            
            if(c.cur == x){
                answer = c.cnt;
                break;
            }
            
            if(c.cur - n >= x){
                que.offer(new Num(c.cur - n , c.cnt + 1));
            }
            if(c.cur % 2 == 0 && c.cur / 2 >= x){
                que.offer(new Num(c.cur /2  , c.cnt + 1));
            }
            if(c.cur % 3 == 0 && c.cur / 3 >= x){
                que.offer(new Num(c.cur /3  , c.cnt + 1));
            }
            
        }
        return answer;
    }
}

class Num{
    int cur, cnt;
    public Num(int cur, int cnt){
        this.cur = cur;
        this.cnt = cnt;
    }
}