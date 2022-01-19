def solution(filename):
    return 1;


def readFile(filename):
    graphArray = []
    file = open(filename, "r")
    for line in file.readlines():
        numbers = [-1 if strNumber == "-" else int(strNumber) for strNumber in line.strip().split(",")]
        graphArray.append(numbers)
    file.close()
    return graphArray


def countWeight(graphArray):
    weight = 0
    for i in range(len(graphArray)):
        for j in range(i, len(graphArray[i])):
            weight += graphArray[i][j] if graphArray[i][j] > 0 else 0
    return weight

def isBidirectionalWeighted(graphArray):
    for i in range(len(graphArray)):
        for j in range(i, len(graphArray[i])):
            if graphArray[i][j] != graphArray[j][i]:
                return False
    return True

if __name__ == '__main__':
    print(True)