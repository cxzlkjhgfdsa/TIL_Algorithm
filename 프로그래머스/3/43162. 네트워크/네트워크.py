def solution(n, computers):
    answer = 0
    visited = [0] * n
    
    for node in range(n):
        if visited[node]:
            continue
        dfs(node, visited, computers)
        answer+=1
        
    return answer


def dfs(cur_node, visited, computers):
    visited[cur_node] = 1
    
    for next_node, is_connected in enumerate(computers[cur_node]):
        if visited[next_node] or next_node == cur_node or not is_connected:
            continue
        dfs(next_node, visited, computers)