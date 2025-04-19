def solution(answers):
    answer1=0
    answer2=0
    answer3=0
    
    answers1=[1,2,3,4,5]
    answers2=[2,1,2,3,2,4,2,5]
    answers3=[3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        i1=i%5
        if answers[i]==answers1[i1]:
            answer1+=1
        i2=i%8
        if answers[i]==answers2[i2]:
            answer2+=1
        i3=i%10
        if answers[i]==answers3[i3]:
            answer3+=1
    answer=[]        
    maxAnswer = max(answer1,answer2,answer3)
    if answer1== maxAnswer:
        answer.append(1)
    
    if answer2 == maxAnswer:
        answer.append(2)
    
    if answer3 == maxAnswer:
        answer.append(3)
    
    return answer