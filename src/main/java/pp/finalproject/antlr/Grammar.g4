grammar Grammar;

@header{package pp.finalproject.antlr;}

program: stat+;

stat: (SHARED target | target) ID ASSIGN expr SEMI #declAssignStat
    | (SHARED target | target) ID SEMI #declStat
    | ID ASSIGN expr SEMI #assignStat
    | ifcompare LCURLY ifbody RCURLY #ifStat
    | whilecompare LCURLY whilebody RCURLY #whileStat
    | SYNCHRONIZED LCURLY synchronizedbody RCURLY #synchronizedStat
    | ID LSQ expr RSQ ASSIGN expr SEMI #arrayAssignStat
    | OUT LPAR expr RPAR SEMI #outStat
    ;

ifcompare: IF LPAR expr RPAR;
ifbody: stat*;

whilecompare: WHILE LPAR expr RPAR;
whilebody: stat*;

synchronizedbody: stat*;

target: type
      | arraytype;

arraytype: type LSQ expr RSQ
         | type LSQ RSQ;

expr: (NUM | TRUE | FALSE) #constExpr
    | expr (TIMES | DIVIDE) expr #timesDivideExpr
    | MINUS expr #minusExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | expr (LT | GT | LTE| | GTE | EQUAL) expr #cmpExpr
    | LPAR expr RPAR #parExpr
    | LCURLY expr (COMMA expr)* RCURLY #arrayAssignExpr
    | expr OR expr  #orExpr
    | expr AND expr #andExpr
    | ID LSQ expr RSQ #arrayExpr
    | SPID #spidExpr
    | ID #idExpr
    ;

type: INT | BOOL;

OUT: 'out';

INT: 'integer';
BOOL: 'boolean';

IF: 'if';
WHILE: 'while';
SHARED: 'shared';
SYNCHRONIZED: 'synchronized';

TRUE: 'true';
FALSE: 'false';

EQUAL: '==';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';

ASSIGN: '=';
OR: '||';
AND: '&&';
SEMI: ';';
LPAR: '(';
RPAR: ')';
LCURLY: '{';
RCURLY: '}';
LSQ: '[';
RSQ: ']';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';
COMMA: ',';
SPID: 'spid';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;

WS: [ \t\r\n]+ -> skip;