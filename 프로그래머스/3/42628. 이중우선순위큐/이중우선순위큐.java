import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Dpq dpq = new Dpq(new ArrayList<Integer>());
        
        for(String s : operations){
            String[] doing = s.split(" ");
            
            switch(doing[0]){
                case "I" :
                    dpq.list.add(Integer.parseInt(doing[1]));
                    break;
                case "D" :
                    if(doing[1].equals("1")){
                        if(dpq.list.size() != 0)
                            dpq.deleteMax();
                    }else{
                        if(dpq.list.size() != 0)
                            dpq.deleteMin();
                    }
                    break;
            }
        }
        
        if(dpq.list.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            int[] ans = dpq.minMax();
            answer[0] = ans[0];
            answer[1] = ans[1];
        }
        return answer;
    }
}

class Dpq{
    ArrayList<Integer> list;
    
    public Dpq(ArrayList<Integer> list){
        this.list = list;
    }
    
    public void insert(int i){
        this.list.add(i);
    }
    
    public void deleteMax(){
        Collections.sort(this.list);
        int size = this.list.size() - 1;
        this.list.remove(size);
    }
    
    public void deleteMin(){
        Collections.sort(this.list);
        this.list.remove(0);
    }
    
    public int[] minMax(){
        Collections.sort(this.list);
        int size = this.list.size() -1;
        int[] ans = {this.list.get(size), this.list.get(0)};
        return ans;
    }
}