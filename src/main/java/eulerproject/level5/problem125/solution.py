import math


def findConsecutives(S, k, max):
    result = []

    for i in range(0, len(S) + 1 - k):
        consecutive = S[i:i + k]
        if sumOfSquares(consecutive) >= max:
            break
        result.append(S[i:i + k])

    return result


def findAllConsecutives(S, max):
    result = []
    for i in range(2, len(S) + 1):
        result.append(findConsecutives(S, i, max))

    return result


def getMaxLimit(max):
    # return int((math.sqrt(2 * max) + 1.0) / 2.0) + 1
    return int((math.sqrt(max))) + 1


def allConsecutives(max):
    return findAllConsecutives(range(1, getMaxLimit(max)), max)


def sumOfSquares(array):
    sum = 0
    for i in array:
        sum += i ** 2
    return sum


def allSquaresFromConsecutives(max):
    result = []

    for c in allConsecutives(max):
        for d in c:
            result.append(sumOfSquares(d))

    return result


def isPalindromeNumber(k):
    s = str(k)
    l = len(s)
    i = 0
    while i < l / 2:
        if s[i] != s[l - i - 1]:
            return False
        i += 1

    return True


def getSumAndCountOfPalindromes(max):
    palindromes = set(filter(isPalindromeNumber, allSquaresFromConsecutives(max)))
    return sum(palindromes), len(palindromes)


if __name__ == "__main__":
    print(getSumAndCountOfPalindromes(1e8))
