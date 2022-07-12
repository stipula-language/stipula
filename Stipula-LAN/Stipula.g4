grammar Stipula;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   //I will leave it like this for now just becasue it is quick
   //but it doesn't work well
   public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
prog :  STIPULA id CLPAR (declist)* (agreement)? (fun)+ CRPAR ; 

id : ID ;

agreement : (AGREEMENT LPAR disputer (COMMA disputer)* RPAR LPAR vardec (COMMA vardec)* RPAR CLPAR (assign)+ CRPAR IMPL AT state);

fun	:  ((AT state)* disputer (COMMA disputer)* COLON id LPAR (vardec ( COMMA vardec)* )? RPAR SLPAR (assetdec ( COMMA assetdec)* )? SRPAR (LPAR prec RPAR)? CLPAR (stat)+ SEMIC (events)+ CRPAR IMPL AT state )   ;
		
assign : (disputer (COMMA disputer)* COLON vardec (COMMA vardec)*);

declist : type strings  ;

type :  ASSET | FIELD | INTEGER | DOUBLE | BOOLEAN | PARTY | INIT | STRING;

state : strings;

disputer : strings;

vardec  : strings ;

assetdec  : strings ;

varasm     : vardec ASM expr ;
 
stat 	:      EMPTY
			|  ( left=value operator=ASSETUP right=value (COMMA rightPlus=value)? ) 
			|  ( left=value operator=FIELDUP right=value (COMMA rightPlus=value)?) 
		 	| ifelse
			
			;
			
ifelse : (IF LPAR cond=expr RPAR CLPAR ifBranch+=stat (ifBranch+=stat)* CRPAR (ELSEIF condElseIf+=expr CLPAR elseIfBranch+=stat (elseIfBranch+=stat)* CRPAR)* (ELSE CLPAR elseBranch+=stat (elseBranch+=stat)* CRPAR )?);

events	:     EMPTY
			| ( expr TRIGGER AT ID CLPAR stat+ CRPAR IMPL AT ID )
			;
			
prec  : expr 
	  ;			
			
expr 	:  ('-')? left=term (operator=(PLUS | MINUS | OR) right=expr)?
      ;
   
term   : left=factor (operator=(TIMES | DIV  | AND) right=term)?
      ;
      
factor : left=value (operator = (EQ | LE | GE | LEQ | GEQ | NEQ ) right=value)?
      ;       
      
value  :  number    
	  | NOW
      | LPAR expr RPAR                      
      | strings
      | EMPTY
      | (TRUE | FALSE)				
      ;      

strings :  SINGLE_STRING | DOUBLE_STRING | ID ;


real
 : number DOT number
 ; 
      
/*string
    : ID ;*/

number
 : INT
 | REAL
 ;

   
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC  	: ';' ;
COLON  	: ':' ;
COMMA  	: ',' ;
DOT    	: '.' ;
EQ     	: '==' ;
NEQ     : '!=' ;
IMPL   	: '==>' ;
ASM    	: '=' ;
ASSETUP :  '-o' ;
FIELDUP : '->' ;
PLUS   	: '+' ;
MINUS  	: '-' ;
TIMES  	: '*' ;
DIV    	: '/' ;
AT	   	: '@' ;
TRUE   	: 'true' ;
FALSE  	: 'false' ;
LPAR   	: '(' ;
RPAR   	: ')' ;
SLPAR   : '[' ;
SRPAR   : ']' ;
CLPAR  	: '{' ;
CRPAR  	: '}' ;
LEQ		: '<=';
GEQ		: '>=';
LE		: '<';
GE		: '>';
OR		: '||';
AND		: '&&';
NOT		: '!';
EMPTY 	: '_' ;
NOW 	: 'now' ;
TRIGGER : '>>';
IF     : 'if' ;
ELSEIF   : 'else if' ;
ELSE   : 'else' ;
STIPULA : 'stipula';
ASSET : 'asset' ;
FIELD : 'field' ;
AGREEMENT : 'agreement';
INTEGER : 'int' ;
DOUBLE : 'real' ;
BOOLEAN : 'bool' ;
PARTY : 'party' ;
STRING : 'string';
INIT : 'init' ;

SINGLE_STRING
    : '\'' ~('\'')+ '\''
    ;

DOUBLE_STRING
    : '"' ~('"')+ '"'
    ;


INT
 : '0'
 | [1-9] [0-9]*
 ;

REAL
 : [0-9]* '.' [0-9]+
 ;

WS
 : [ \t\r\n] -> skip
 ;

//IDs
fragment CHAR  : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | INT | EMPTY)* ;

OTHER
 : .
 ;

//ESCAPED SEQUENCES
LINECOMENTS    : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

 //VERY SIMPLISTIC ERROR CHECK FOR THE LEXING PROCESS, THE OUTPUT GOES DIRECTLY TO THE TERMINAL
 //THIS IS WRONG!!!!
ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 