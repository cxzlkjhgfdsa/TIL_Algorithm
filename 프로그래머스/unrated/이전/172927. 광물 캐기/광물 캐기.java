class Solution {
    int min = 25*50+1;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int size = minerals.length;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        
        if(picks[0]>0){
            dfs(dia, iron, stone, minerals, 0, 0, 0, size);
        }
        if(picks[1]>0){
            dfs(dia, iron, stone, minerals, 1, 0, 0, size);
            
        }
        if(picks[2]>0){
            dfs(dia, iron, stone, minerals, 2, 0, 0, size);
            
        }
        
        
        answer = min;
        return answer;
        
        
    }
    
    public void dfs(int dia, int iron, int stone, String[] minerals, int pick, int score, int cnt, int size){
        int start = cnt*5;
        
        
        
        switch(pick){
            case 0:
                dia--;
                for(int i=start; i<start+5; i++){
                    if(i>=size) break;
                    score+=1;                    
                }
                break;
            case 1:
                iron--;
                for(int i=start; i<start+5; i++){
                    if(i>=size) break;
                    if(minerals[i].length()==7){
                        score+=5;
                    }else{
                        score+=1; 
                    }                   
                }
                break;
            case 2:
                stone--;
                for(int i=start; i<start+5; i++){
                    if(i>=size) break;
                    if(minerals[i].length()==7){
                        score+=25;
                    }else if(minerals[i].length()==4){
                        score+=5; 
                    }else{
                        score+=1;
                    }       
                }
                break;
           
                
        }      
        if(start+5>=size){
            min = Math.min(min, score);
            return;
        }
        if(dia == 0 && iron == 0 && stone == 0){
            min = Math.min(min, score);
            return;
        }
        
        if(dia>0){
            dfs(dia, iron, stone, minerals, 0, score, cnt+1, size);
        }
        if(iron>0){
            dfs(dia, iron, stone,minerals, 1, score, cnt+1, size);
        }
        if(stone>0){
            dfs(dia, iron, stone, minerals, 2, score, cnt+1, size);
        }
        
        return;
    }
}