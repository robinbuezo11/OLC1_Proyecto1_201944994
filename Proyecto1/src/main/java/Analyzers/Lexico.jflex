package Analyzers;
import java_cup.runtime.*;

%%

%class Lexico
%cupsym sym
%cup
%public
%unicode
%line
%column
%ignorecase

%init{

%init}

blanks = [ \t\r\n\f]+ 

symb=[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\_\`\{\|\}]
specialSymb=("\\""n" | "\\""\'" | "\\""\"")
letters=[a-zA-Z]
ints=[0-9]

obracke = "{"
cbracke = "}"
semicolon = ";"
concat = "."
sum = "+"
or = "|"
sub = "-"
mult = "*"
question = "?"
greather = ">"

commentl=("//".*\n)|("//".*\r)
comments=("<""!"[^\!]*"!"">")

setER = ([\"]{symb}[\"]|[\"]{letters}[\"]|[\"]{ints}[\"]|[\"][\"])

specialSetER={specialSymb}

id = {letters}({letters}|"_"|{ints})*
id_setER = "{"[a-zA-Z0-9]+"}"

%init{
    yyline = 1;
    yychar = 1;
%init}

%%

{blanks} {}
{commentl} {}
{comments} {}

{concat} {return new Symbol(sym.concat,yycolumn,yyline,yytext());}
{sum} {return new Symbol(sym.sum,yycolumn,yyline,yytext());}
{mult} {return new Symbol(sym.mult,yycolumn,yyline,yytext());}
{or} {return new Symbol(sym.or,yycolumn,yyline,yytext());}
{question} {return new Symbol(sym.question,yycolumn,yyline,yytext());}
{obracke} {return new Symbol(sym.obracke,yycolumn,yyline,yytext());}
{id_setER} {return new Symbol(sym.id_setER,yycolumn,yyline,yytext());}
{id} {return new Symbol(sym.id,yycolumn,yyline,yytext());}
{setER} {return new Symbol(sym.setER,yycolumn,yyline,yytext());}
{specialSetER} {return new Symbol(sym.specialSetER,yycolumn,yyline,yytext());}
{semicolon} {return new Symbol(sym.semicolon,yycolumn,yyline,yytext());}
{sub} {return new Symbol(sym.sub,yycolumn,yyline,yytext());}
{greather} {return new Symbol(sym.greather,yycolumn,yyline,yytext());}
{cbracke} {return new Symbol(sym.cbracke,yycolumn,yyline,yytext());}


.   {
        Gui.MainWindow.txtconsole.setText(Gui.MainWindow.txtconsole.getText()+"\nERROR LEXICO: " + yytext()+" Linea: "+(yyline) + " Columna: "+(yycolumn));
    }