def solution(x):
    num_list = list(str(x))
    
    sum = 0
    
    for i in num_list:
        sum += int(i)
    
    answer = True
    if x % sum != 0:
        answer = False
    return answer