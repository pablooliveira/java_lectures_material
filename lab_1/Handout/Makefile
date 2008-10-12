NAME=lab1-java-2008
TABLES=

%.table: %.gnuplot
	gnuplot $<

all: ${TABLES}
	pdflatex $(NAME).tex
	pdflatex $(NAME).tex

clean:
	rm -f *.lst *.log *.d *.aux *.nav *.out *.snm *.toc *.dvi *.vrb $(NAME).pdf *.table	
	rm -rf auto
