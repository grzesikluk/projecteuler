def getInitialChunks(array, chunk_size, n):
    """
    Get me array with initial chunks.
    """
    result_list = []
    max = len(array)

    for i in range(0, len(array) - chunk_size + 1):
        result_list.append([0] * i + [n] * chunk_size + (max - chunk_size - i) * [0])

    return result_list


def getArrayIndexesToFragment(array, chunk_size):
    """
    Return list of tuples (from, to) of indexes - indicating parts of array that can be fragmented.
    :param array:
    :param chunk_size:
    :return: Indexes tuples list [(from,to),...]
    """
    indexes = []

    for i in range(len(array)):
        if array[i:i + chunk_size] == [0] * chunk_size:
            indexes.append((i, i + chunk_size - 1))

    return indexes


def createNewArraysGeneration(array, chunk_size):
    n = max(array) + 1
    result_list = []

    for indexes in getArrayIndexesToFragment(array, chunk_size):
        new_array = array[:]
        for i in range(indexes[0], indexes[1] + 1):
            new_array[i] = n
        result_list.append(new_array)

    return result_list


def divideArrayByChunks(array, k):
    """
    This function should return list of delivered arrays by searching unfragmented paths.
    :param k: chunk size.
    :return:
    """
    result = []
    generation = createNewArraysGeneration(array, k)

    for a in generation:
        result.append(a)
        result += createNewArraysGeneration(a, k)

    return sorted(set(map(tuple, result)), reverse=True)


def divideArrayByChunksRecursive(array, k):
    result = []
    first_generation = createNewArraysGeneration(array, k)

    for a in first_generation:
        result.append(a)
        result += divideArrayByChunksRecursive(a, k)

    return sorted(set(map(tuple, result)), reverse=True)


def reduceGenerationsInArray(array):
    return map(lambda i: 1 if i > 0 else 0, array)


def solution(n, k):
    if n >= k:
        solution_with_generations = divideArrayByChunksRecursive([0] * n, k)
        # print(solution_with_generations)
        solution_without_generation = map(reduceGenerationsInArray, solution_with_generations)
        return sorted(set(map(tuple, solution_without_generation)), reverse=True)
    else:
        return []

def generatorA000071():
    a = [-1, 0]
    n = 0

    while True:
        if n > 0:
            s = a[1] + a[0] + 1
            yield s
            a[0] = a[1]
            a[1] = s
        else:
            yield 0
        n+=1

def generatorA077868():
    """
    a(n) = a(n-2) + a(n-3) + a(n-4) + 2 for n > 3.
    :return:
    """
    a = [1, 2, 3, 5]
    n = 0

    while True:
        if n < 3:
            yield 0
        elif n < 7:
            yield a[n-7]
        else:
            s = a[2] + a[1] + a[0] + 2
            yield s
            a[0] = a[1]
            a[1] = a[2]
            a[2] = a[3]
            a[3] = s
        n += 1


def generatorA098578():
    """
    a(n) = a(n-1) + a(n-4) + 1
    :return:
    """
    a = [0, 1, 2, 3, 4]
    n = 1

    while True:

        if n < 5:
            yield 0
        elif n < 9:
            yield a[n-9]
        else:
            s = a[4] + a[1] + 1
            yield s
            a[0] = a[1]
            a[1] = a[2]
            a[2] = a[3]
            a[3] = a[4]
            a[4] = s
        n += 1


if __name__ == "__main__":

    f1 = generatorA000071()
    f2 = generatorA077868()
    f3 = generatorA098578()

    for i in range(0, 51):
        # print("{} {} {} ".format(i, f1.next(), len(solution(i, 2))))
        # print("{} {} {} ".format(i, f2.next(), len(solution(i, 3))))
        # print("{} {} {} ".format(i, f3.next(), len(solution(i, 4))))
        print ("{} {}".format(i, f1.next()+f2.next()+f3.next()))