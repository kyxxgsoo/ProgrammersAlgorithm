
def solution(n, computers):

    def bfs(x, computers):
        q = []
        q.append(x)
        visit[x] = True

        while q:
            cur = q.pop()
            for i in range(len(computers[cur])):
                if not visit[i] and computers[cur][i] is 1: #computers[cur][i] is True 했을 때 오류나었음.
                    print("i : ", i)                        #1이 True가 아닌 것 같음.
                    q.append(i)
                    visit[i] = True

    answer = 0
    visit = [False for _ in range(n)]
    for i in range(n):
        if not visit[i]:
            bfs(i, computers)
            answer += 1
            print(answer)
            print(visit)

    return answer