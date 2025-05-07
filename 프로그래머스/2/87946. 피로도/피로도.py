import itertools

def solution(k, dungeons):
    answer = -1
    
    arr = [i for i in range(len(dungeons))]
    
    for perm in itertools.permutations(arr, len((arr))):
        count = 0;
        energy = k
        for i in perm:
            if energy < dungeons[i][0]:
                break;
            count += 1
            energy -= dungeons[i][1]
        answer = max(count, answer)
    
    
    return answer