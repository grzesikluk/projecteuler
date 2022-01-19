def solution():
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
        for j in range(len(graphArray[i])):
            weight += graphArray[i][j] if graphArray[i][j] > 0 else 0
    return weight/2



if __name__ == '__main__':
    print(True)