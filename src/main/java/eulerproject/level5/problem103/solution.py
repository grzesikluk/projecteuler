import logging

from eulerproject.pyeuler.sets import optimum_special_sum_set
from eulerproject.pyeuler.timing import start, stop

logging.basicConfig(level=logging.INFO, format='%(relativeCreated)6d %(threadName)s %(message)s')

if __name__ == '__main__':
    start = start()
    print(optimum_special_sum_set(7))
    print(stop(start))
