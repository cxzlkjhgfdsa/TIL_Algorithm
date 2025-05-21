def solution(array, commands):
    answer = []
    
    for arr in commands:
        sorted_arr = sorted(array[int(arr[0])-1:int(arr[1])])
        answer.append(sorted_arr[int(arr[2]-1)])
    return answer