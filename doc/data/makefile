
GRAPHVIZ = dot
PNG = -Tpng
OUT = -o

file1 = activity
file2 = umlsimple

run:
	$(GRAPHVIZ) $(file1).dot $(PNG) $(OUT) $(file1).png
	$(GRAPHVIZ) $(file2).dot $(PNG) $(OUT) $(file2).png
	open $(file1).png
	open $(file2).png