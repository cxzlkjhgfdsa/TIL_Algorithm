def solution(n, wires):
    answer = 1000
    
    graph = {}
    
    for s,e in wires:
        if s in graph:
            graph[s].append(e)
        else:
            graph[s]=[e]
        if e in graph:
            graph[e].append(s)
        else:
            graph[e]=[s]
    
    print(graph)
    
    for s1, s2 in wires:
        visited = [0]*101
        visited[s1] = 1
        visited[s2] = 1
        a = bfs(s1, s2,graph, visited)
        b =bfs(s2, s1,graph, visited)
        answer = min(answer, abs(a - b))  
    
    return answer

def bfs(node, cut, graph, visited):
    
    count = 1
    
    que = [node]
    
    while(len(que) > 0):
        
        n = que.pop()
        
        for i in graph[n]:
            if not visited[i]:
                visited[i] = 1
                count += 1
                que.append(i)
    
    
    return count