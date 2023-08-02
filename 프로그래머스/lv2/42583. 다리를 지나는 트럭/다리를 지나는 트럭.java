import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int t_weight = 0;
        int goal = 0;
        int totalTruck = truck_weights.length;
        int idx = 0;
        Queue<Truck> que = new ArrayDeque<>();

        while(goal != totalTruck){
            time++;
            if(que.size()>0){
                int t = que.peek().start;
                int w = que.peek().weight;
                if((time - t) >= bridge_length){
                    que.poll();
                    t_weight -= w;
                    goal++;
                }
            }
            if(idx >= totalTruck)
                continue;
            if(truck_weights[idx] + t_weight > weight)
                continue;
            que.add(new Truck(truck_weights[idx] , time));
            t_weight += truck_weights[idx];
            idx++;

        }
        answer = time;
        return answer;
    }
}

class Truck{
    int weight;
    int start;

    public Truck(int w, int s){
        this.weight = w;
        this.start = s;
    }
}