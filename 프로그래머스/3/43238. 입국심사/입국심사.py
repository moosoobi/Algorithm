def solution(n, times):
    minTime, maxTime = 1, n * max(times)
    answer = maxTime  # 초기 값은 최대 시간으로 설정
    while minTime <= maxTime:
        midTime = (minTime + maxTime) // 2
        sumCounter = 0
        for time in times:
            sumCounter += midTime // time  # 각 심사대에서 처리할 수 있는 사람 수
        if sumCounter >= n:
            answer = midTime
            maxTime = midTime - 1  # 최소 시간을 찾아가기 위해 maxTime을 줄여줌
        else:
            minTime = midTime + 1  # 처리할 수 있는 사람이 부족하면 minTime을 늘려줌
    return answer