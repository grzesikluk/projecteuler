def getSumOfDigits(k):
    tenth = 1
    result = 0

    while tenth < k * 10:
        result += (k % (tenth * 10)) / tenth
        tenth *= 10

    return result


def checkIfEqualToPowerOfDigitSum(k):
    ds = getSumOfDigits(k)
    pow = 1
    a = 1

    if ds < 2:
        return False

    while a < k:
        a = ds ** pow

        if a == k:
            return True

        pow += 1
    return False


if __name__ == "__main__":

    k = 1
    i = 10

    while True:
        if checkIfEqualToPowerOfDigitSum(i):
            print("{}".format(i))
            k+=1
        i+=1