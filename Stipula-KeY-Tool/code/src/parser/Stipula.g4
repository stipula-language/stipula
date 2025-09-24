grammar Stipula;

program : 'stipula' contract_definition EOF;

contract_definition
    : contract_name '{' variable_definition agreement_definiton (method_definition)* '}'
    ;

variable_definition
    : ('assets' asset_variables)? ('fields' field_variables)? ('init' init_state)?
    ;

agreement_definiton
    : agreement_name '(' contractParties=party ')' '(' params ')' '{' party  ':' params '}' '=>' state
    ;

method_definition
    : state* party ':' method_name '(' params? ')' '[' asset_input? ']' condition? '{' method_body (';' underscroll)? logical_expression* '}' '=>' next_state
    ;

method_body
    : (operation)*
    ;

operation
    : asset_transfer
    | variable_assignment
    | conditional_function
    ;

asset_transfer
    : asset_input '-o' asset_target
    | asset_input '-o' asset_input ',' asset_target
    | INT '-o' asset_target
    | expression '-o' asset_target
    | INT '-o' asset_input ',' asset_target
    | expression '-o' asset_input ',' asset_target
    ;

variable_assignment
    : expression '->' expression
    | STRING '->' VARIABLE
    | VARIABLE '->' VARIABLE
    | INT '->' VARIABLE
    ;

conditional_function
    : 'if' condition '{' operation* underscroll? '}'
    | 'else if' condition '{' operation* underscroll? '}'
    | 'else' '{' operation* underscroll? '}'
    ;

logical_expression
    : expression '>>' state '{' (operation)* '}' '=>' state
    ;

params
    : param (',' param)*
    ;

param
    : VARIABLE
    ;

asset_input
    : VARIABLE
    ;

asset_target
    : VARIABLE
    ;

asset_variables
    : VARIABLE (',' VARIABLE)*
    ;

field_variables
    : VARIABLE (',' VARIABLE)*
    ;

variable
    : VARIABLE
    ;

expression
    : expression '*' expression
    | expression '/' expression
    | expression '+' expression
    | expression '-' expression
    | '(' expression ')'
    | VARIABLE
    | INT
    ;

factor
    : VARIABLE
    | INT
    ;

condition
    : '(' logical_condition (logic_operators logical_condition)* ')'
    ;

logical_condition
    : expression logic_operators expression
    | VARIABLE
    ;

party
    : VARIABLE (',' VARIABLE)*
    ;

airthmetic_operators
    : '+'
    | '-'
    | '*'
    | '/'
    ;

logic_operators
    : '=='
    | '!='
    | '&&'
    | '||'
    | '<'
    | '>'
    | ('=>'|'>=')
    | ('=<'|'<=')
    ;
method_name
    : VARIABLE
    ;

agreement_name
    : VARIABLE
    ;

contract_name
    : VARIABLE
    ;

state
    : '@' VARIABLE
    ;

init_state
    : VARIABLE
    ;

next_state
    : '@' VARIABLE
    ;

underscroll
    : '_'
    ;

VARIABLE
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

STRING
    : '"'? [a-zA-Z_][a-zA-Z0-9_]* '"'?
    ;

INT
    : [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
