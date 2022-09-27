def solution(n):
    answer = 0
    myList = list(str(n))
    myList.sort(reverse=True)
    answer = int("".join(myList))

    return answer