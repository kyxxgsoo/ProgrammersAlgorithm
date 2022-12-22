def solution(s):
    answer = []
    alphabet = [-1 for i in range(26)]

    for i in range(len(s)):
        index = ord(s[i]) - ord('a')  # s[i]의 문자 a~z를 0~25로 표현한 index
        if alphabet[index] == -1:
            answer.append(-1)
            alphabet[index] = i
        else:
            answer.append(i - alphabet[index])
            alphabet[index] = i

    return answer