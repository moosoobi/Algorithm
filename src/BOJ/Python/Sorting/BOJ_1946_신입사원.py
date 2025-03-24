import sys

def select_candidates(test_cases):
    results = []
    for _ in range(test_cases):
        n = int(sys.stdin.readline().strip())
        candidates = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]

        # 서류 심사 기준 오름차순 정렬
        candidates.sort()


        count = 1  # 첫 번째 사람은 무조건 선발
        min_interview_rank = candidates[0][1]  # 첫 번째 지원자의 면접 순위

        for i in range(1, n):
            # 면접 순위가 현재 최소보다 높으면 선발 가능
            if candidates[i][1] < min_interview_rank:
                count += 1
                min_interview_rank = candidates[i][1]  # 최소 면접 등수 업데이트

        results.append(count)

    return results

# 입력 처리
if __name__ == "__main__":
    test_cases = int(sys.stdin.readline().strip())
    results = select_candidates(test_cases)
    for res in results:
        print(res)
