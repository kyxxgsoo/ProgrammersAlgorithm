def solution(s):
    answer = []
    cnt = 0
    numberOfZero = 0
    print("TEST :", s)
    while s != "1":
        cnt += 1
        numberOfZero += s.count("0")
        s = format(len(s.replace("0", "")), "b")
    return [cnt, numberOfZero]