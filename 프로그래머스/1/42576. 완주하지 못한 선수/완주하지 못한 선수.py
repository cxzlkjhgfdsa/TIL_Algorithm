def solution(participant, completion):
    answer = ''
    
    dict = {}
    
    for n in participant:
        if dict.get(n) == None:
            dict[n] = 1
        else:
            dict[n] = dict[n] + 1
    
    for comp in completion:
        dict[comp] = dict[comp] - 1

    for name in dict:
        if dict[name] > 0:
            answer = name
    
    return answer