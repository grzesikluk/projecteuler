if __name__ == "__main__":
    import cProfile
    from solution import getSumOfPalindromes
    cProfile.run('getSumOfPalindromes(10e7)')
