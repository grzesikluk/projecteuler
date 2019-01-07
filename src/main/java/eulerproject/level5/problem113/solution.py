import scipy.special as scipy

from eulerproject.level5.problem112.solution import isBouncyNumber


def countBouncyNumbers():
    bouncy = 0
    i = 1

    while True:
        if isBouncyNumber(i):
            bouncy += 1
        yield (i, bouncy)
        i += 1


def numberOfNotBouncyNumbers(n):
    return scipy.comb(n + 10, 10) + scipy.comb(n + 9, 9) - 2 - 10 * n


if __name__ == "__main__":
    print(format(numberOfNotBouncyNumbers(100),'f'))
