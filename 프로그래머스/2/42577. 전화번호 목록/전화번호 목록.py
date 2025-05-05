def solution(phone_book):
    answer = True
    
    len_set = set([len(i) for i in phone_book])
    
    check = {}  
    
    for phone_num in phone_book:
        for k in len_set:
            if len(phone_num) <= k:
                continue
            head = phone_num[0:k]
            check[head] = 1
    
    for phone_num in phone_book:
        if check.get(phone_num) != None:
            answer = False
            break
        
    
    return answer