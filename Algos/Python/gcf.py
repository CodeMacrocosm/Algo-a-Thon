import numpy as np
from matplotlib.backends.backend_agg import FigureCanvasAgg
import matplotlib.pyplot as plot

plot.plot([2, 3, 4])

# implementation of the
# matplotlib.pyplot.gcf()
# function
figure = plot.gcf().canvas

ag = figure.switch_backends(FigureCanvasAgg)
ag.draw()
A = np.asarray(ag.buffer_rgba())

# Pass off to PIL.
from PIL import Image
img = Image.fromarray(A)

# show image
img.show()
