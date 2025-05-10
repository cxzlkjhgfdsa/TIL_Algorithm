from math import ceil

def solution(progresses, speeds):
    answer = []
    
    times = []
    
    for i in range(len(speeds)):
        work = 100 - progresses[i]
        
        times.append(ceil(work/speeds[i]))
    
    while(len(times) > 0):
        count = count_release(times)
        answer.append(count)
    
    return answer

def count_release(times):
    count = 1
    
    cur = times.pop(0)
    
    while(len(times)>0):
        if times[0] > cur:
            break
        times.pop(0)
        count+=1
    return count
    