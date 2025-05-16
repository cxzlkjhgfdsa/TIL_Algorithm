from collections import deque

def solution(bridge_length, weight, truck_weights):
    cur_time = 0
    
    dq = deque()
    
    total_w = 0
    
    for t_w in truck_weights:
        
        cur_time += 1
        
        if len(dq) == bridge_length:
            t = dq.popleft()
            cur_time += max(0, bridge_length-(cur_time - t[1]))
            total_w -= t[0]
        
        if total_w + t_w <= weight:
            total_w += t_w
            dq.append((t_w, cur_time))
        else:
            while(total_w + t_w > weight):
                t = dq.popleft()
                cur_time += max(0, bridge_length-(cur_time - t[1]))
                total_w -= t[0]
            total_w += t_w
            dq.append((t_w, cur_time))
    
    if len(dq)>0:
        t = dq.pop()
        cur_time += max(0, bridge_length-(cur_time - t[1]))
        total_w -= t[0]
    
    return cur_time