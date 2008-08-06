NAME=java_lecture
SVG_IMAGES = car1.pdf car2.pdf car3.pdf method_anatomy.pdf tortue.pdf 

%.pdf: %.svg
	#convert $< $@
	inkscape --export-pdf=$@ $<

all: $(SVG_IMAGES)
	pdflatex $(NAME).tex
#pdflatex $(NAME).tex

clean:
	rm -rf auto *.lst *.log *.d *.aux *.nav *.out *.snm *.toc *.dvi *.vrb $(NAME).pdf $(SVG_IMAGES)	
