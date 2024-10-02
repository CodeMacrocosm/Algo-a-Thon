choice = int(input("Enter maximum range: "))
choice = choice + 1

def FizzBuzz(choice):
    for num in range(1,choice):
        if num % 3 == 0 and num % 5 == 0:
            print("fizzbuzz")
        elif num % 5 == 0:
            print("buzz")
        elif num % 3 == 0:
            print("fizz")
        else:
            print(num)

FizzBuzz(choice)