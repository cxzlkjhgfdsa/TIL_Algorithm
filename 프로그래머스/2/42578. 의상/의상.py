from itertools import combinations

def solution(clothes):
    answer = 1
    
    closet = {}
    
    for c in clothes:
        if closet.get(c[1]) == None:
            closet[c[1]] = 1
        else:
            closet[c[1]] +=1
    
    for i in closet.values():
        answer *= (i+1)
    
    answer -= 1
       
    return answer