def solution(s):
    
    answer = True
    
    stack = []
    
    for ch in s:
        if len(stack) == 0 and ch == ')':
            answer = False
            break
        if ch == '(':
            stack.append(ch)
        else:
            stack.pop()
    
    if len(stack) > 0:
        answer = False
    
    return answer