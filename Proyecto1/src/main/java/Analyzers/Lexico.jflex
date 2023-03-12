package Analyzers;
import java_cup.runtime.*;
import Gui.*;

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

R_conj = "CONJ"

symb=[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\_\`\{\|\}]
specialsym=("\\""n" | "\\""\'" | "\\""\"")
letter=[a-zA-Z]
int=[0-9]

obracke = "{"
cbracke = "}"
semicolon = ";"
concat = "."
plus = "+"
or = "|"
dash = "-"
asterisk = "*"
question = "?"
greather = ">"
colon = ":"
accent = "~"
comma = ","

separator = "%%"[ \t\r\n\f]+"%%"

commentl=("//".*\n)|("//".*\r)
comments=("<""!"[^\!]*"!"">")

str = [\"]([\!\#\$\%\&\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\_\`\{\|\}]|{letter}|{int}|[ \t\r\n\f]|("\\""n" | "\\""\'"))*[\"]

id = {letter}({letter}|"_"|{int})*
set_er = ((({symb}|{letter}|{int})[ \t\r]*{accent}[ \t\r]*({symb}|{letter}|{int}))|({symb}|{letter}|{int})([ \t\r]*{comma}[ \t\r]*({symb}|{letter}|{int}))+)
idset_er = [\{]{id}[\}]
chr_er = ([\"][\!\#\$\%\&\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\_\`\{\|\}][\"]|[\"]{letter}[\"]|[\"]{int}[\"]|[\"][ ]*[\"]|[\"]("\\""n" | "\\""\'")[\"])
//str_er = ("\""({symb} | {letter} | {int} | [ \t\r\n\f])*"\"")
specialset_er={specialsym}

%init{
    yyline = 1;
    yychar = 1;
%init}

%%

{blanks} {}
{commentl} {}
{comments} {}

{obracke} {return new Symbol(sym.obracke,yycolumn,yyline,yytext());}
{R_conj} {return new Symbol(sym.R_conj,yycolumn,yyline,yytext());}
{colon} {return new Symbol(sym.colon,yycolumn,yyline,yytext());}
{id} {return new Symbol(sym.id,yycolumn,yyline,yytext());}
{idset_er} {return new Symbol(sym.idset_er,yycolumn,yyline,yytext());}
{chr_er} {return new Symbol (sym.chr_er,yycolumn,yyline,yytext());}
{str} {return new Symbol (sym.str,yycolumn,yyline,yytext());}
{specialset_er} {return new Symbol(sym.specialset_er,yycolumn,yyline,yytext());}
{dash} {return new Symbol(sym.dash,yycolumn,yyline,yytext());}
{greather} {return new Symbol(sym.greather,yycolumn,yyline,yytext());}
{set_er} {return new Symbol(sym.set_er,yycolumn,yyline,yytext());}
{concat} {return new Symbol(sym.concat,yycolumn,yyline,yytext());}
{plus} {return new Symbol(sym.plus,yycolumn,yyline,yytext());}
{asterisk} {return new Symbol(sym.asterisk,yycolumn,yyline,yytext());}
{or} {return new Symbol(sym.or,yycolumn,yyline,yytext());}
{question} {return new Symbol(sym.question,yycolumn,yyline,yytext());}
{semicolon} {return new Symbol(sym.semicolon,yycolumn,yyline,yytext());}
{separator} {return new Symbol(sym.separator,yycolumn,yyline,yytext());}
{cbracke} {return new Symbol(sym.cbracke,yycolumn,yyline,yytext());}


.   {
        MainWindow.txtconsole.setText(MainWindow.txtconsole.getText()+"\nERROR LEXICO: " + yytext()+" Linea: "+(yyline) + " Columna: "+(yycolumn));
    }