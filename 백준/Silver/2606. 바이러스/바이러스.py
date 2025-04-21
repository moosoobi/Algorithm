from collections import deque

Network=deque()
Virus=deque()
N=input()
M=int(input())
for _ in range(M):
    A, B= input().split(" ")
    Network.append((A,B))

Virus.append("1")
VirusSet=set()
VirusSet.add("1")
while len(Virus)>0:
    x=Virus.popleft()
    for i in range(M):
        A,B = Network[i]
        if A==x and B not in VirusSet:
            Virus.append(B)
            VirusSet.add(B)
        if B==x and A not in VirusSet:
            Virus.append(A)
            VirusSet.add(A)
result=len(VirusSet)-1
print(result)