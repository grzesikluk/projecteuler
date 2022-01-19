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


def createEdges(graphArray):
    edges = {}
    for i in range(len(graphArray)):
        for j in range(i, len(graphArray[i])):
            edges[i, j] = graphArray[i][j]

    return dict(filter(lambda edge: edge[1] > 0, edges.items()))


def sortEdgesByWeight(edgesMap):
    return sorted(edgesMap.items(), key=lambda kv: kv[1])


def hasCycles(graphArray):
    def getNeighbours(graphArray, vertex):
        return ([i for i, e in enumerate(graphArray[vertex]) if e > 0])

    def dfs(vertex):
        visited[vertex] = True
        for neighbour in getNeighbours(graphArray, vertex):
            if visited[neighbour] == False:
                if dfs(neighbour) == True:
                    return True
            elif recstack[neighbour] == True:
                return True
        recstack[vertex] = True
        return False

    # main function starts here
    visited = [False] * len(graphArray)
    recstack = [False] * len(graphArray)

    for i in range(len(graphArray)):
        if visited[i] == False:
            if dfs(i) == True:
                return True

    return False


if __name__ == '__main__':
    print(True)
