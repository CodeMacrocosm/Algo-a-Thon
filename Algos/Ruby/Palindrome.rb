def Palindrome(str)
    str = str.downcase
	i = 0
	j = str.size-1
	while i < j do
		while (i<j && !((str[i] >= '0' &&  str[i] <= '9') || (str[i].ord >= 97 &&  str[i].ord <= 122))) do
			i = i+1
		end
		while (i<j && !((str[j] >= '0' &&  str[j] <= '9') || (str[j].ord >= 97 &&  str[j].ord <= 122))) do
			j = j-1
		end
		if str[i] != str[j]
			return false
		end	
		i = i+1
		j = j-1
	end
	true
end

string = 'MADAM'

check = Palindrome(string)
if check == true
    print("Palindrome")
else
    print("Not Palindrome")
end