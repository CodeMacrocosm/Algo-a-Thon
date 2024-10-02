def isPalindrome(str,rev_str):
    x = str == rev_str
    return x

while True:
    print("\n####################\tPalindrome Checker by Cyber-Mukherjee\t####################\n")
    try:
        choice = int(input("Press the number corresponding to the option to select it\n0.\tExit\n1.\tCheck for Palindrome\n"))

        if choice == 1:
            string = input("Enter the string you want to check: ")
            low_str = string.lower()
            rev_str = low_str[-1::-1]

            result = isPalindrome(low_str,rev_str)
            if result == True:
                print(f"\n{string} is a palindrome!")
            elif result == False:
                print(f"\n{string} is not a palindrome as it spells {rev_str} when reversed.")
            else:
                print("invalid input")

        elif choice == 0:
            print("\n####################\tThank you for using my program\t####################")
            break
        else:
            print("\nInvalid input")

    except:
        print("\nEnter an integer value corresponding to your choice!")
        