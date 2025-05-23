def minCoin(n, k):
    count[0]=0
    for i in range(1, k+1):
        for j in range(n):
            if i-coin[j]>=0:
                count[i]=min(count[i],count[i-coin[j]]+1)

    if count[k]==100001:
        return -1
    else:
        return count[k]

n, k = map(int, input().split())
coin=[]
count=[100001 for _ in range(k+1)]
for i in range(n):
    coin.append(int(input()))

print(minCoin(n, k))


