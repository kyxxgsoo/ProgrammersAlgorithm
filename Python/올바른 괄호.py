def solution(s):
    stack = []

    # if s.count('(') != s.count(')') or s[-1] == '(' or len(s) % 2 != 0:
    #     return False;

    for item in s:
        if item == '(':
            stack.append(item)
        else:
            if stack:
                stack.pop()
            else:
                return False

    if not stack:
        return True
    else:
        return False