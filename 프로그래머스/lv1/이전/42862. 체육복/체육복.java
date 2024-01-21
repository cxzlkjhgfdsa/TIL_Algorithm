import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] lostList = new boolean[31];
        boolean[] resvList = new boolean[31];
        boolean[] check = new boolean[31];
        for(int i : lost){
            lostList[i] = true;
        }
        int losC = 0;
        for(int i : reserve){
            if(!lostList[i]){
                resvList[i] = true;
            }else{
                losC++;
            }
            check[i] = true;
        }
        
        Arrays.sort(lost);
        int cnt = 0;
        for(int k : lost){
            if(check[k]){
                continue;
            }
            if(k==0){
               if(resvList[1]){
                   cnt++;
                   resvList[1] = false;
                } 
            }else if(k == 30){
                if(resvList[29]){
                    cnt++;
                    resvList[29] = false;
                }
            }else{
                if(resvList[k-1]){
                    cnt++;
                    resvList[k-1] = false;
                }else if(resvList[k+1]){
                    cnt++;
                    resvList[k+1] = false;
                }
            }
        }
        answer = n - lost.length + cnt + losC;
       
        return answer;
    }
}