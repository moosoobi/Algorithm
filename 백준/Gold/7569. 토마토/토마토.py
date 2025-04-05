import sys
from collections import deque
input = sys.stdin.readline

M, N, H = map(int, input().split())
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

dz = [0, 0, 0, 0, 1, -1]
dy = [-1, 1, 0, 0, 0, 0]
dx = [0, 0, -1, 1, 0, 0]

queue = deque()

# 익은 토마토 위치를 큐에 미리 넣기
for z in range(H):
    for y in range(N):
        for x in range(M):
            if box[z][y][x] == 1:
                queue.append((z, y, x))

# BFS 수행
while queue:
    z, y, x = queue.popleft()
    for i in range(6):
        nz, ny, nx = z + dz[i], y + dy[i], x + dx[i]
        if 0 <= nz < H and 0 <= ny < N and 0 <= nx < M:
            if box[nz][ny][nx] == 0:
                box[nz][ny][nx] = box[z][y][x] + 1
                queue.append((nz, ny, nx))

# 결과 확인
res = 0
for z in range(H):
    for y in range(N):
        for x in range(M):
            if box[z][y][x] == 0:
                print(-1)
                sys.exit()
            res = max(res, box[z][y][x])

print(res - 1)  # 처음이 1이니까 하루 수는 -1
