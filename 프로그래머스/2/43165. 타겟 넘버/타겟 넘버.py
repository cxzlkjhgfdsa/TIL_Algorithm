answer = 0

def solution(numbers, target):
    global answer
    dfs(0, 0,numbers, target)
    return answer


def dfs(cur_num, index, numbers, target):
    global answer
    if index == len(numbers):
        if cur_num == target:
            answer += 1
        return 0
    
    dfs(cur_num+numbers[index], index+1, numbers, target)
    dfs(cur_num-numbers[index], index+1, numbers, target)
    