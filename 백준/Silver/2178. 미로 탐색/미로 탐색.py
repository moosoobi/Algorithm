from collections import deque

N,M=map(int, input().split())
matrix = [list(map(int, input().strip()))for _ in range(N)]
visited = [[False]*M for _ in range(N)]
queue=deque()
queue.append((0,0))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while queue:
    x,y=queue.popleft()

    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]

        if 0<=nx<N and 0<=ny<M:
            if matrix[nx][ny]==1 and not visited[nx][ny]:
                matrix[nx][ny]=matrix[x][y]+1
                visited[nx][ny]==True
                queue.append((nx,ny))

print(matrix[N-1][M-1])
           
