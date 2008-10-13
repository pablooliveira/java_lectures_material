NAME=java_lecture1
SVG_IMAGES = car1.pdf car2.pdf car3.pdf method_anatomy.pdf tortue.pdf cc-logo.pdf 

%.pdf: %.svg
	#convert $< $@
	inkscape --export-pdf=$@ $<

all: $(SVG_IMAGES)
	pdflatex $(NAME).tex
#pdflatex $(NAME).tex

clean:
	rm -rf auto *.lst *.log *.d *.aux *.nav *.out *.snm *.toc *.dvi *.vrb *.xmpi $(NAME).pdf $(SVG_IMAGES)	
