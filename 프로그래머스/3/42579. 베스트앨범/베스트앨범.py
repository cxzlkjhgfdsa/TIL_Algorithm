def solution(genres, plays):
    answer = []
    
    play_cnt = {}
    by_genres_dict = {}
    
    for i in range(len(genres)):
        if play_cnt.get(genres[i]) == None:
            play_cnt[genres[i]] = plays[i]
            by_genres_dict[genres[i]] = {}
        else:
            play_cnt[genres[i]] += plays[i]
            
        by_genres_dict[genres[i]][i] = plays[i]
    
    play_cnt = sorted(play_cnt.items(), key=lambda x: x[1], reverse=True)
    
    #print(play_cnt)
    
    for (k, v) in play_cnt:
        by_genres_dict[k] = sorted(by_genres_dict[k].items(), key=lambda x:x[1], reverse=True)
        count = 0
        for (j,val) in by_genres_dict[k]:
            answer.append(j)
            count+=1
            if count == 2:
                break
            
    
    return answer