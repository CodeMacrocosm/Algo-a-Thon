from datetime import datetime, timedelta
import time
from tqdm import tqdm

print('Choose 1 for Blocking sites and 2 for Unblocking: \n')

print('1. Blocking. \n2. Unblocking')
choice = int(input("\nMake your choice 1 or 2: "))

if choice == 1:
	print("Enter time and date details for blocking the sites upto desired time.")
	year = int(input("Enter year: "))
	mon = int(input("Enter month: "))
	day = int(input("Enter day: "))
	hour = int(input("Enter hour: "))
	min = int(input("Enter minutes: "))
	end_time = datetime(year, mon, day, hour, min) # y, m, d, h, min

	sites_to_block = list(map(str,input("Enter sites to be blocked using spaces: ").split()))
	print("List of sites entered to be blocked: ", sites_to_block)
elif choice == 2:
	ini_time_for_now = datetime.now()
	end_time = ini_time_for_now - timedelta(days = 1) # y, m, d, h, min
	sites_to_block = list(map(str,input("Enter sites to unblocked using spaces: ").split()))

else:
	print("Invalid input")
	
print("Initiating...")
for i in tqdm (range (100),
               ascii=False, ncols=75):
    time.sleep(0.03)
print("Almost here!")
for i in tqdm (range (100),
               ascii=False, ncols=75):
    time.sleep(0.03)

hosts_path = '/etc/hosts'

redirect = "127.0.0.1"

#Block sites till the end time
def block_websites():
    if datetime.now() < end_time: 
       	with open(hosts_path, 'r+') as hostfile:
            hosts_content = hostfile.read()
            for site in  sites_to_block:
                if site not in hosts_content:
                   hostfile.write(redirect + ' ' + site + '\n')
        print('Site(s) Blocked!')
    
    else:
        #Removing the blocked list
        with open(hosts_path, 'r+') as hostfile:
            lines = hostfile.readlines()
            hostfile.seek(0)
            for line in lines:
                if not any(site in line for site in sites_to_block):
                    hostfile.write(line)
            hostfile.truncate() # This removes all the rest remaining portion
            print('Site(s) Unblocked')

# sudo python main.py
if __name__ == '__main__':
    block_websites()