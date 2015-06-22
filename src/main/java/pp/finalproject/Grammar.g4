grammar Grammar;

@header{package pp.finalproject}

program: stat+;

stat: SHARED target ID ASSIGN expr SEMI #sharedDeclStat
    | target ID ASSIGN expr SEMI #declStat
    | ID ASSIGN expr SEMI #assignStat
    | IF LPAR expr RPAR LCURLY stat* RCURLY #ifStat
    | WHILE LPAR expr RPAR LCURLY stat* RCURLY #whileStat
    | procedure #procedureStat
    ;

target: type
      | arraytype;

arraytype: type LSQ expr RSQ
         | type LSQ RSQ;

procedure: PROCEDURE ID LPAR RPAR LCURLY stat* RCURLY #procedure
         | PROCEDURE ID LPAR (target ID (COMMA target ID)*)* RPAR LCURLY stat* RCURLY #paramProcedure
         ;

expr: (NUM | TRUE | FALSE) #constExpr
    | expr AND expr #andExpr
    | expr (TIMES | DIVIDE | MODULO) expr #timesDivideExpr
    | MINUS expr #minusExpr
    | expr (PLUS | MINUS) expr #plusMinusExpr
    | expr OR expr  #orExpr
    | expr (LT | GT | LTE| | GTE | EQUAL | NOTEQUAL) expr #cmpExpr
    | LPAR expr RPAR #parExpr
    | LCURLY NUM (COMMA NUM)* RCURLY #arrayExpr
    | ID #idExpr
    ;

type: INT | BOOL;

INT: 'integer';
BOOL: 'boolean';
// Add arrays here

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