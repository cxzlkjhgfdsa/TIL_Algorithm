def solution(arr, divisor):
    arr.sort()
    answer = list(filter(lambda x: x%divisor == 0, arr))
    if len(answer) == 0:
        answer.append(-1)
    return answer