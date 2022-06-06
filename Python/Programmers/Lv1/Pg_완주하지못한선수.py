def solution(participant, completion):
    participant.sort()
    completion.sort()
    # zip은 인덱스 같은애들끼리 비교
    for part, com in zip(participant, completion):
        if part != com:
            return part

    return participant[len(participant)-1]  # participant[-1]이라고 해도됨(제일끝)
