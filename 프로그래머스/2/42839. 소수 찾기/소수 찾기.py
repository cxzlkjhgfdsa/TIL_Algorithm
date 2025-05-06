import math
import itertools

def isDecimal(num):
    
    if(num <= 1):
        return False
    
    for i in range(2, int(math.sqrt(num))+1):
        if(num % i == 0):
            return False
    return True


def solution(numbers):
    answer = 0
    
    all_nums = []
    elements = [c for c in numbers]
    
    for i in range(1, len(numbers)+1):
        for li in itertools.permutations(elements, i):
            k = int(''.join(li))
            all_nums.append(k)
    
    all_nums = set(all_nums)
    
    print(all_nums)
    
    for n in all_nums:
        if(isDecimal(n)):
            answer += 1
    
    return answer

