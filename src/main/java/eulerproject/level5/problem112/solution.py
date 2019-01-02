def isBouncyNumber(k):
    arrayNumber = get_digit(k)
    converted = []

    for i in range(0, len(arrayNumber) - 1):
        converted.append(arrayNumber[i + 1] - arrayNumber[i])

    up_zero = False
    sub_zero = False

    for d in converted:
        if d < 0:
            sub_zero = True
        elif d > 0:
            up_zero = True

    return sub_zero and up_zero


def get_digit(number):
    result = []

    while (number >= 10):
        digit = number % 10
        number = number / 10
        result.append(digit)

    result.append(number % 10)

    return result


def numberProportionOfBouncyNumbers(proportionPercent=50):
    i = 1
    counter = 0
    while True:
        if isBouncyNumber(i):
            counter += 1
        if counter * 100 / float(i) >= proportionPercent:
            break
        i += 1
    return i


if __name__ == "__main__":
    print(numberProportionOfBouncyNumbers(50))
    print(numberProportionOfBouncyNumbers(90))
    print(numberProportionOfBouncyNumbers(99))
