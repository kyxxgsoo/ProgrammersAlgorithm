def solution(s):
    strLen = len(s)
    if strLen % 2 == 1:
        return s[strLen // 2]
    else:
        return s[strLen // 2 - 1] + s[strLen // 2]