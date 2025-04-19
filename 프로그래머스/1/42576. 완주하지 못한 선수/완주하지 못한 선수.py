def solution(participant, completion):
    sumHash = 0
    hashDict = {}
    for part in participant:
        hashDict[hash(part)]=part
        sumHash+=hash(part)

    for comp in completion:
        sumHash-=hash(comp)
    
    answer = hashDict[sumHash]
    return answer