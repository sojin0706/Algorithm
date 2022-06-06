def solution(x):
    number = str(x)
    sum = 0
    for i in range(0, len(str(x))):
        sum += int(number[i])
    if x % sum == 0:
        return True
    else:
        return False
