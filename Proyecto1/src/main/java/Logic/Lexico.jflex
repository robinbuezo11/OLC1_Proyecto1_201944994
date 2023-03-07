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
"push" {return new Symbol(sym.TOKEN_PUSH, yytext());}
"add" {return new Symbol(sym.TOKEN_ADD, yytext());}
"sub" {return new Symbol(sym.TOKEN_SUB, yytext());}
"div" {return new Symbol(sym.TOKEN_DIV, yytext());}
"mult" {return new Symbol(sym.TOKEN_MULT, yytext());}
"print" {return new Symbol(sym.TOKEN_PRINT, yytext());}

[\n\r\t ]+ {}

. {Gui.MainWindow.txtconsole.setText("\nCaracter no esperado, ERROR LEXICO " + yytext());}