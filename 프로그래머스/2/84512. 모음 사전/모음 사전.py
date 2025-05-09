def solution(word):
    words_list = []
    dfs(0, "", words_list)
    return words_list.index(word)

def dfs(depth, word, words_list):
    
    words_list.append(word)
    
    if depth == 5:
        return
    for c in "AEIOU":
        dfs(depth+1, word+c, words_list)
        