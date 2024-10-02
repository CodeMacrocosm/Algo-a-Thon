import tkinter as tk
import ttkbootstrap as ttk

def convert():
	mile_input = entry_int.get()
	km_output = mile_input * 1.61
	output_string.set(km_output)
# window
window = ttk.Window(themename = "cyborg")
window.title("Demo")
window.geometry("400x250")

# title
title_label = tk.Label(
	master = window,
	text = "Miles to Kilometers",
	font = "Calibri 20 bold"
)
title_label.pack()

# input


input_frame = ttk.Frame(
	master = window
)

input_label = tk.Label(
	master = input_frame,
	text = "Enter a value:"
)

input_label.pack()

entry_int = tk.IntVar()
entry = ttk.Entry(
	master = input_frame,
	textvariable = entry_int
)

button = ttk.Button(
	master = input_frame,
	text = "Convert",
	command = convert
)

entry.pack(side = "left", padx = 0.5)
button.pack(side = "right", padx = 0.5)
input_frame.pack(pady = 10)

# output
output_string = tk.StringVar()
output_label = ttk.Label(
	master = window,
	text = "Output",
	font = "Calibri 20",
	textvariable = output_string
)

output_label.pack(pady = 10)

# run
window.mainloop()