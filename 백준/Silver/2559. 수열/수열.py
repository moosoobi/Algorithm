N, K = map(int, input().split())
temps = list(map(int, input().split()))

# 초기 윈도우 합
window_sum = sum(temps[:K])
max_sum = window_sum

# 슬라이딩 윈도우
for i in range(K, N):
    window_sum += temps[i] - temps[i - K]
    max_sum = max(max_sum, window_sum)

print(max_sum)
