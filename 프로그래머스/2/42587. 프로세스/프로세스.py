class process:
    def __init__(self, idx, prior):
        self.idx = idx
        self.prior = prior
        
    def __str__(self):
        return str(self.idx) + ' ' + str(self.prior)

def solution(priorities, location):
    
    que = []
    
    answer = 0
    
    for i in range(len(priorities)):
        que.append(process(i, priorities[i]))
    
    while len(que) > 0:
        
        p = que.pop(0)
        
        if p.prior == max(priorities):
            answer += 1
            if p.idx == location:
                break
            priorities.remove(p.prior)
        else:
            que.append(p)
            
        
    
    return answer