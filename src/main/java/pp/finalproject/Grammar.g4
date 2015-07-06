grammar Grammar;

@header{package pp.finalproject;}

program: stat+;

stat: SHARED target ID SEMI #sharedDeclStat
    | SHARED target ID ASSIGN expr SEMI #sharedDeclAssignStat
    | target ID SEMI #declStat
    | target ID ASSIGN expr SEMI #declAssignStat
    | ID ASSIGN expr SEMI #assignStat
    | ifcompare LCURLY ifbody RCURLY #ifStat
    | whilecompare LCURLY whilebody RCURLY #whileStat
    | procedure #procedureStat
    | ID LSQ expr RSQ ASSIGN expr SEMI #arrayAssignStat
    ;

ifcompare: IF LPAR expr RPAR;
ifbody: stat*;

whilecompare: WHILE LPAR expr RPAR;
whilebody: stat*;

target: type
      | arraytype;

arraytype: type LSQ expr RSQ
         | type LSQ RSQ;

procedure: PROCEDURE ID LPAR RPAR LCURLY stat* RCURLY #noParamProcedure
         | PROCEDURE ID LPAR (target ID (COMMA target ID)*)* RPAR LCURLY stat* RCURLY #paramProcedure
         ;

expr: (NUM | TRUE | FALSE) #constExpr
    | expr (TIMES | DIVIDE | MODULO) expr #timesDivideExpr
    | MINUS expr #minusExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | expr (LT | GT | LTE| | GTE | EQUAL | NOTEQUAL) expr #cmpExpr
    | LPAR expr RPAR #parExpr
    | LCURLY expr (COMMA expr)* RCURLY #arrayAssignExpr
    | expr OR expr  #orExpr
    | expr AND expr #andExpr
    | ID LSQ expr RSQ #arrayExpr
    | ID #idExpr
    ;

type: INT | BOOL;

INT: 'integer';
BOOL: 'boolean';

IF: 'if';
WHILE: 'while';
SHARED: 'shared';
PROCEDURE: 'procedure';

TRUE: 'true';
FALSE: 'false';

EQUAL: '==';
NOTEQUAL: '!=';
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
MODULO: '%';
COMMA: ',';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;

WS: [ \t\r\n]+ -> skip;