def solution(brown, yellow):
    answer = []
    
    brown = brown - 4
    
    for i in range(yellow, 0, -1):
        if(yellow % i != 0):
            continue
        col = i
        row = yellow / i
        
        if (row+col)*2 == brown:
            answer = [col+2 , row+2]
            break
        
    
    return answer