from collections import deque

def solution(progresses, speeds):
    answer = []
    pdq = deque(progresses)
    sdq = deque(speeds)

    while len(pdq) != 0:
        count = 0
        for i in range(len(pdq)):
            pdq[i] += sdq[i]

        while pdq[0] >= 100:
            pdq.popleft()
            sdq.popleft()
            count += 1
            if not pdq:
                break

        if count != 0:
            answer.append(count)

    return answer