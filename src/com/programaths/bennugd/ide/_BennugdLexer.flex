package com.programaths.bennugd.ide;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.programaths.bennugd.psi.BgdTypes.*;

%%

%{
  public _BennugdLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _BennugdLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

COMMENT=("//".*|"/"\*.*\*"/")
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\\"|\\'|\\)*\")
ELIF=(elif|elseif)
FRAME=(frame|yield)
NUMBER=[0-9]+
ID=[a-zA-Z0-9_]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "begin"            { return BEGIN; }
  "break"            { return BREAK; }
  ","                { return COMMA; }
  "case"             { return CASE; }
  "const"            { return CONST; }
  "continue"         { return CONTINUE; }
  "debug"            { return DEBUG; }
  "declare"          { return DECLARE; }
  "dup"              { return DUP; }
  "else"             { return ELSE; }
  "end"              { return END; }
  "="                { return EQ; }
  "for"              { return FOR; }
  "from"             { return FROM; }
  "function"         { return FUNCTION; }
  "if"               { return IF; }
  "import"           { return IMPORT; }
  "include"          { return INCLUDE; }
  "["                { return LBRACKET; }
  "local"            { return LOCAL; }
  "loop"             { return LOOP; }
  "("                { return LPAR; }
  "onexit"           { return ONEXIT; }
  "&&"               { return OP_AND; }
  "/"                { return OP_DIV; }
  ">"                { return OP_GT; }
  ">="               { return OP_GTE; }
  "<"                { return OP_LT; }
  "<="               { return OP_LTE; }
  "-"                { return OP_MINUS; }
  "*"                { return OP_MUL; }
  "||"               { return OP_OR; }
  "+"                { return OP_PLUS; }
  "private"          { return PRIVATE; }
  "process"          { return PROCESS; }
  "program"          { return PROGRAM; }
  "public"           { return PUBLIC; }
  "]"                { return RBRACKET; }
  "repeat"           { return REPEAT; }
  "return"           { return RETURN; }
  ")"                { return RPAR; }
  ";"                { return SEMI; }
  "sizeof"           { return SIZEOF; }
  "step"             { return STEP; }
  "struct"           { return STRUCT; }
  "switch"           { return SWITCH; }
  "to"               { return TO; }
  "type"             { return TYPE; }
  "until"            { return UNTIL; }
  "while"            { return WHILE; }

  {COMMENT}          { return COMMENT; }
  {STRING}           { return STRING; }
  {ELIF}             { return ELIF; }
  {FRAME}            { return FRAME; }
  {NUMBER}           { return NUMBER; }
  {ID}               { return ID; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
