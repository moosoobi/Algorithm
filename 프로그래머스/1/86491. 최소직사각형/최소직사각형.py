def swap(a,b):
    temp=a
    a=b
    b=temp
    return a,b

def solution(sizes):
    aMax=0
    bMax=0
    for i in sizes:
        if i[0]<i[1]:
            i[0],i[1]=swap(i[0],i[1])
        if i[0]>aMax:
            aMax=i[0]
        if i[1]>bMax:
            bMax=i[1]
            
    
    answer = aMax*bMax
    return answer