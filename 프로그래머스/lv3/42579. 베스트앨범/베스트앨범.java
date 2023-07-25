import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genMap = new HashMap<>();
        Map<String, PriorityQueue<Music>> musicMap = new HashMap<>();
        
        for(int i=0; i<plays.length; i++){
            String g = genres[i];
            if(genMap.get(g) == null){
                genMap.put(g, plays[i]);
                PriorityQueue<Music> pq = new PriorityQueue<>();
                pq.add(new Music(i, plays[i], g));
                musicMap.put(g, pq);
            }else{
                genMap.put(g, genMap.get(g)+plays[i]);
                musicMap.get(g).add(new Music(i, plays[i], g));
            }
        }
        
        PriorityQueue<Genre> que = new PriorityQueue<>();
        
        for(Map.Entry<String, Integer> el : genMap.entrySet()){
            que.add(new Genre(el.getKey(), el.getValue()));
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        while(!que.isEmpty()){
            String gen = que.poll().genre;
            
            for(int k=0; k<2; k++){
                if(musicMap.get(gen).size()==0){
                    break;
                }
                list.add(musicMap.get(gen).poll().idx);

            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    } 
}

class Genre implements Comparable<Genre>{
    String genre;
    int totalPlays;
    
    public Genre(String genre, int totalPlays){
        this.genre = genre;
        this.totalPlays = totalPlays;
    }
    
    @Override
    public int compareTo(Genre o){
        return o.totalPlays - this.totalPlays;
    }
    
}


class Music implements Comparable<Music>{
    int idx;
    int playCnt;
    String genres;
    
    public Music(int idx, int playCnt, String genres){
        this.idx = idx;
        this.playCnt = playCnt;
        this.genres = genres;
    }
    
    @Override
    public int compareTo(Music o){
        if(this.playCnt == o.playCnt){
            return this.idx - o.idx;
        }
        return o.playCnt - this.playCnt;
    }
}