import time


def start():
    return time.time_ns()


def stop(start):
    return (time.time_ns() - start) / (1e9)
