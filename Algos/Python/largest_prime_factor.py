def largest_prime_factor(n):
    while n:
        i = 2
        while n > 1:
            if n % i == 0:
                n /= i
            else:
                i += 1
        return i


print(largest_prime_factor(600851475143))
