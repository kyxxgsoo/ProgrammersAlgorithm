def solution(s):
    answer = ''
    str = s.split(" ")
    for i in range(len(str)):
        str[i] = str[i].capitalize()
    answer = " ".join(str)
    return answer