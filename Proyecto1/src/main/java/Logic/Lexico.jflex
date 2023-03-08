package Logic;
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
    yyline=1;
    yychar=1;
%init}

%%

[0-9]+ {return new Symbol(sym.TOKEN_NUMBER, yytext());}
"+" {return new Symbol(sym.TOKEN_SUMA, yytext());}
"-" {return new Symbol(sym.TOKEN_RESTA, yytext());}
"/" {return new Symbol(sym.TOKEN_DIV, yytext());}
"*" {return new Symbol(sym.TOKEN_MULT, yytext());}

[\n\r\t ]+ {}

. {Gui.MainWindow.txtconsole.setText("\nCaracter no esperado, ERROR LEXICO " + yytext());}