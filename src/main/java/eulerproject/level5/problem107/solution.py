import itertools


def readFile(filename):
    graphArray = []
    file = open(filename, "r")
    for line in file.readlines():
        numbers = [-1 if strNumber == "-" else int(strNumber) for strNumber in line.strip().split(",")]
        graphArray.append(numbers)
    file.close()
    return graphArray


def writeFile(filename, array):
    with open(filename, 'w') as f:
        for item in array:
            f.write("%s\n" % item)


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


def copyArray(x):
    return [row[:] for row in x]


def addEdge(edge, array):
    array[edge[0][0]][edge[0][1]] = edge[1]


def getSublistsWithSameWeight(sortedEdges):
    lastWeight = -1
    beginning = 0
    indexes = []

    for i in range(len(sortedEdges) - 1):
        if sortedEdges[i][1] == sortedEdges[i + 1][1]:
            if lastWeight != sortedEdges[i]:
                beginning = i
                lastWeight = sortedEdges[i][1]
        else:
            if lastWeight != -1:
                indexes.append([beginning, i])
            beginning = 0
            lastWeight = -1

    return indexes


def allEdgesVariants(sortedEdges):
    edgesVariants = [sortedEdges]
    sublistIndexes = getSublistsWithSameWeight(sortedEdges)

    for sublistIndex in sublistIndexes:
        newPermutedEdges = []
        permutations = list(itertools.permutations(sortedEdges[sublistIndex[0]:sublistIndex[1] + 1]))

        for permutedSublist in permutations:

            for existingEdges in edgesVariants:
                copy = existingEdges[:]
                copy[sublistIndex[0]:sublistIndex[1] + 1] = permutedSublist
                newPermutedEdges.append(copy[:])

        edgesVariants = newPermutedEdges[:]

    return edgesVariants


def solution(file):
    graphArray = readFile(file)
    initWeight = countWeight(graphArray)
    sortedEdges = sortEdgesByWeight(createEdges(graphArray))
    allSortedEdgesVariants = allEdgesVariants(sortedEdges)
    allSolutions = []

    for sortedEdgesVariant in allSortedEdgesVariants:

        forestArray = [[-1] * len(graphArray)] * len(graphArray)

        for edge in sortedEdgesVariant:
            forestCopy = copyArray(forestArray)
            addEdge(edge, forestCopy)
            if not hasCycles(forestCopy):
                forestArray = forestCopy
        allSolutions.append(initWeight - countWeight(forestArray))

    return min(allSolutions)


if __name__ == '__main__':
    print(solution("network.txt"))
