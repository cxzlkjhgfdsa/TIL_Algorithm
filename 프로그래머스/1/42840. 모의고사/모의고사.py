def solution(answers):
    a = [1,2,3,4,5] * 2000
    b = [2,1,2,3,2,4,2,5] * 1250
    c = [3,3,1,1,2,2,4,4,5,5] * 1000
    answer = []
    score = [0,0,0]
    
    for idx, val in enumerate(answers):
        if a[idx] == val:
            score[0] += 1
        if b[idx] == val:
            score[1] += 1
        if c[idx] == val:
            score[2] += 1
    
    max_score = max(score)
    
    for i,v in enumerate(score):
        if max_score == v:
            answer.append(i+1)
    
    return answer