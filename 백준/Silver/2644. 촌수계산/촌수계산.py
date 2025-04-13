from collections import deque

def bfs(start, target, n, graph):
    visited = [-1] * (n + 1)  # 방문 여부를 저장, -1이면 방문하지 않은 상태
    queue = deque([start])
    visited[start] = 0  # 시작점의 촌수는 0

    while queue:
        current = queue.popleft()
        
        # 목표 지점에 도달하면 촌수 반환
        if current == target:
            return visited[current]

        # 인접한 사람들을 탐색
        for neighbor in graph[current]:
            if visited[neighbor] == -1:  # 아직 방문하지 않은 사람
                visited[neighbor] = visited[current] + 1
                queue.append(neighbor)
    
    return -1  # 두 사람이 연결되어 있지 않으면 -1 반환

def main():
    n = int(input())  # 사람 수
    # 촌수를 구할 두 사람 입력받기
    x, y = map(int, input().split())
    m = int(input())  # 관계의 수
    graph = [[] for _ in range(n + 1)]  # 그래프 초기화 (1부터 n까지)

    # 관계 입력받기
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # BFS를 통해 두 사람 간의 촌수 구하기
    result = bfs(x, y, n, graph)
    print(result)

if __name__ == "__main__":
    main()