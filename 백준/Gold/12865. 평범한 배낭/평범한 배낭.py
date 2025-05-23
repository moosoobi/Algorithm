def maxValue(n, k):

    for i in range(1, n+1):
        for w in range(k+1):
            if w-weight[i]>=0:
                result[i][w]=max(result[i-1][w],result[i-1][w-weight[i]]+value[i])
            else:
                result[i][w]=result[i-1][w]
    return result[n][k]
                


n, k = map(int, input().split())
weight=[0 for _ in range(n+1)]
value=[0 for _ in range(n+1)]
result=[[0]*(k+1)for _ in range(n+1)]
for i in range(1,n+1):
    weight[i], value[i]=map(int, input().split())
print(maxValue(n, k))
