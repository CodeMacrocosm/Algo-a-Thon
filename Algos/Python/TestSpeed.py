from speedtest import Speedtest
from tkinter import *

def update_text():
    st = Speedtest()
    download = st.download()
    upload = st.upload()
    download_speed = round(download / (10**6), 2)
    upload_speed = round(upload / (10**6), 2)
    down_label.config(text = "Download Speed: " + str(download_speed) + "MBps")
    up_label.config(text = "Upload Speed: " + str(upload_speed) + "MBps")
#print("Download speed: ", st.download(), "bytes/s")
#print("Upload speed: ", st.upload(), "bytes/s")
root = Tk()
root.title("Internet Speed Tester")
root.geometry("400x200")
Label(root, text="Internet Speed Tester", font=("Arial 22 italic")).pack(pady=10)


button = Button(root, text="Check speed", font=("Helvetica 18") ,command=update_text)
button.pack()
down_label = Label(root, text="", font=("Arial 15"))
down_label.pack()
up_label = Label(root, text="", font=("Arial 15"))
up_label.pack()
root.mainloop()

