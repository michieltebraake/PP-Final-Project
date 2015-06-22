grammar Grammar;

@header{package pp.finalproject}

program: stat+;

stat: SHARED target ID ASSIGN expr SEMI #sharedDeclStat
    | target ID ASSIGN expr SEMI #declStat
    | ID ASSIGN expr SEMI #assignStat
    | IF LPAR expr RPAR LCURLY stat* RCURLY #ifStat
    | WHILE LPAR expr RPAR LCURLY stat* RCURLY #whileStat
    ;

target: type
      | arraytype;

arraytype: type LSQ expr RSQ
         | type LSQ RSQ;

expr: (NUM | TRUE | FALSE) #constExpr
    | expr AND expr #andExpr
    | expr (TIMES | DIVIDE | MODULO) expr #timesDivideExpr
    | MINUS expr #minusExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | expr OR expr  #orExpr
    | expr (LT | GT | LTE| | GTE | EQUAL | NOTEQUAL) expr #cmpExpr
    | LPAR expr RPAR #parExpr
    | ID #idExpr
    ;

type: INT | BOOL;

INT: 'integer';
BOOL: 'boolean';
// Add arrays here

IF: 'if';
WHILE: 'while';
SHARED: 'shared';

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

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;

WS: [ \t\r\n]+ -> skip;