from collections import deque

def solution(maps):
    answer = 0
    
    dq = deque()
    dq.append((0,0,1))
    
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    
    visited = [[0]*len(maps[0]) for _ in range(len(maps))]
    
    while len(dq) > 0 :
        
        x, y, count = dq.popleft()
        if x == len(maps)-1 and y == len(maps[0])-1:
            answer = count
            break
            
        
        for i in range(4):
            cx = x + dx[i]
            cy = y + dy[i]
            if cx < 0 or cx >= len(maps) or cy < 0 or cy >= len(maps[0]) or visited[cx][cy] or maps[cx][cy] == 0:
                continue
            dq.append((cx, cy, count+1))
            visited[cx][cy] = 1
            
        
    return answer if answer > 0 else -1