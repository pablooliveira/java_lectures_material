% Documentclass LICENCE.cls


\NeedsTeXFormat{LaTeX2e}

\ProvidesClass{exercices}[2008/10/10]
\LoadClass[a4paper,11pt]{article}

\DeclareOption{correction}{\@correctiontrue}
\newif\if@correction
\@correctionfalse
\ProcessOptions

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Packages
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\RequirePackage[utf8]{inputenc}
\RequirePackage{verbatim}
\RequirePackage[T1]{fontenc}
%\RequirePackage[francais]{babel}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Correction
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\if@correction
        \newenvironment{correction}%
                {\par\noindent\begin{small} ~\\ \textbf{Correction :}}%
                {\end{small}\par\smallskip}
\else
        \let\correction\comment
        \let\endcorrection\endcomment
\fi
\if@correction
\newcommand{\sujet}[1]
{\begin{center}{\LARGE{\bf Solutions - #1}}\end{center}\bigskip}

\newcommand{\correct}[1]{\item{\textbf{#1}}} 
\else
\newcommand{\sujet}[1]
{\begin{center}{\LARGE{\bf #1}}\end{center}\bigskip}

\newcommand{\correct}[1]{\item{#1}} 
\fi
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% PAGE LAYOUT
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\setlength{\textwidth}{17cm}
\setlength{\textheight}{26cm}
\setlength{\topmargin}{-2.5cm}
%\setlength{\evensidemargin}{-1cm}
\setlength{\oddsidemargin}{0cm}
\setlength{\parindent}{0.0cm}
\setlength{\parskip}{0.2cm}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Header
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\newcommand{\entete}[4]{\begin{center}
MSC \hfill Introduction du Java - Year #4\\
\vspace{0.5cm}
% {\Large #1 #2 n$^\circ$ #3}\\
 {\Large #1 #2 n\textsuperscript{o} #3}\\
\if@correction (Correction)\else\relax\fi
\end{center}
\bigskip}


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Sections
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\renewcommand{\thesection}{\Roman{section})}
\renewcommand{\thesubsection}{\alph{subsection})}


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Environnement exercice
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\newtheorem{exo}{Exercice}
\newenvironment{exercice}{\begin{exo}\upshape\par}{\end{exo}}

\newtheorem{qus}{Question}
\newenvironment{question}{\begin{qus}\upshape\par}{\end{qus}}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Details...
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
\AtBeginDocument{%
\renewcommand{\labelitemi}{$\bullet$}
\sloppy
\hbadness=5000
}
