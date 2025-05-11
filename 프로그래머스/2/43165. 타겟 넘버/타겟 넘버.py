def solution(numbers, target):
    answer = dfs(0, 0,numbers, target)
    return answer


def dfs(cur_num, index, numbers, target):
    if index == len(numbers):
        if cur_num == target:
            return 1
        return 0
    
    return dfs(cur_num+numbers[index], index+1, numbers, target) + dfs(cur_num-numbers[index], index+1, numbers, target)
    
    