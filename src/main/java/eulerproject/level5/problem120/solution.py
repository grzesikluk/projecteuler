def function(a, n):
    return ((a - 1) ** n + (a + 1) ** n) % (a ** 2)


def getMaxFunction(a):
    max = 0
    n_max = 0
    for n in range(a / 3, 2 * a):
        f = function(a, n)
        if f > max:
            max = f
            n_max = n
    return max, n_max


def getMaxSum():
    sum = 0
    for a in range(3, 1000 + 1):
        l, n_max = getMaxFunction(a)
        sum += l

    return sum


if __name__ == "__main__":
    print(getMaxSum())
