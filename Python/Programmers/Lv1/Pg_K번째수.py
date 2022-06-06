def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        froms = commands[i][0]
        to = commands[i][1]
        num = commands[i][2]
        arr = array[froms-1:to]
        arr.sort()
        answer.append(arr[num-1])
    return answer
