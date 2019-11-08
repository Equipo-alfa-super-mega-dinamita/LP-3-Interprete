grammar edder;

START: RESOURCE START
     | GLOBAL START
     | BODY START;
//RESOURCE GLOBAL BODY
RESOURCE : {tk_resource} {tk_id} PAREN SOMETHING {tk_end};
GLOBAL: {tk_global} GLOBAL_BODY_ID SOMETHING {tk_end} GLOBAL_BODY_END ;
BODY:   {tk_body} GLOBAL_BODY_ID SOMETHING {tk_end} GLOBAL_BODY_END ;
G_B_TYPE: {tk_global}
        | {tk_body};
GLOBAL_BODY_ID: {tk_id}
              | {tk_file};
GLOBAL_BODY_END: {tk_id}
              | ¿;
//========================================
//Las formas que una setencia puede tener
SOMETHING: VAR_CONST SOMETHING
   | ASSIGNMENTS SOMETHING
   | Y SOMETHING
   | IMPORT SOMETHING
   | {tk_id} PAREN SOMETHING
   | {tk_stop} SOMETHING
   | {tk_semicolon} SOMETHING
   | IF SOMETHING
   | FOR SOMETHING
   | DO SOMETHING
   | {tk_exit} SOMETHING
   | OPERATOR SOMETHING
   | PROC SOMETHING
   | OPTYPE SOMETHING
   | TK_TYPE SOMETHING
   | EXTEND SOMETHING
   | IN SOMETHING
   | WRITE SOMETHING
   | ¿
   ;
//==================================================
//optype
OPTYPE: {tk_optype} OPERATOR;
TK_TYPE: {tk_type} {tk_id} {tk_eq} {tk_id} PAREN;
EXTEND: {tk_extend} {tk_id} NEXT_IMPORT_EX;
EMP_IDENT: IDENT
         | ¿;
//in
IN: {tk_in} {tk_id} PAREN R_WORD {tk_arrow} SOMETHING MORE_IN {tk_ni};
R_WORD: {tk_and} K
      | {tk_by} IDENT
      | ¿;
MORE_IN: {tk_square} IDENT {tk_arrow} SOMETHING MORE_IN
       | ¿;

//Import
IMPORT     : {tk_import} {tk_id} NEXT_IMPORT_EX;
NEXT_IMPORT_EX: POINT {tk_id} NEXT_IMPORT_EX
              | COMMA {tk_id} NEXT_IMPORT_EX
              | ¿;
//FOR
FOR: {tk_fa} {tk_id} B {tk_to} A1 {tk_arrow} SOMETHING {tk_af};

//DO
DO: {tk_do} K {tk_arrow} SOMETHING {tk_od};

//Operator
OPERATOR: {tk_id} N_OPERA NE_OPERA;
N_OPERA: PAREN
       | {tk_colon} {tk_id} N_OPERA;
NE_OPERA: {tk_returns} {tk_id} {tk_colon} DAT
       | ¿;

//PROC
PROC: {tk_proc} {tk_id} {tk_lparen} PAR_FUN {tk_rparen} SOMETHING {tk_end};
PAR_FUN:  {tk_id} N_PAR_FUN
       | ¿;
N_PAR_FUN: {tk_comma} {tk_id} N_PAR_FUN
         | ¿;

//OP
TK_OP: {tk_op} {tk_id} PRO_NEXT PAREN CALL_SEND;
//write
WRITE: {tk_write} PAREN;
//IF
IF: {tk_if} K {tk_arrow} SOMETHING ELSE {tk_fi};
ELSE: {tk_square} NEXT_ELSE
    | ¿;
NEXT_ELSE: {tk_else} {tk_arrow} SOMETHING
         | K {tk_arrow} SOMETHING NEXT_ELSE;
POINT: {tk_period};
COMMA: {tk_comma};

//====================================================
//Declaracion de variables y constantes
VAR_CONST : TYPE {tk_id} ARRAY ASSIG CON V_C_END;
TYPE : {tk_var}
   | {tk_const};
//En caso que sea un arreglo [a,...,b]
ARRAY : {tk_lbracket} ARR_DAT VAL
     | ¿;
VAL : {tk_comma} ARR_DAT VAL
    | {tk_colon} ARR_DAT {tk_rbracket}
    | {tk_rbracket};
ARR_DAT : A1
;
//En caso que se haga una asignacion "dospuntos="


ASSIG : B
     | ¿;
//En caso que se sigan declarando identificadores
CON : {tk_comma} {tk_id} ARRAY ASSIG CON
   | {tk_colon} {tk_id} ARRAY ASSIG CON
   | ¿;
//El final de la declaracion
V_C_END : {tk_colon} DAT SEMICOLON;
DAT : {tk_int}
    | {tk_bool}
    | {tk_real}
    | {tk_char}
    | {tk_string} ANY_STRING
    | {tk_file}
    | {tk_ptr}
    | IDENT;
ANY_STRING : {tk_lbracket} {tk_aster} {tk_rbracket}
       | ¿;
SEMICOLON : {tk_semicolon}
          | ¿;

// Manejo de las asignaciones especiales.
ASSIGNMENTS :  {tk_id} NEXT_ASS AUG;
NEXT_ASS : POINT {tk_id} NEXT_ASS
         | ¿;
AUG : A
 | B
 | C
 | E
 | G
 | I;
//======================================================
//Assignment operators
//swap
A : {tk_swap} IDENT;
// assign
B  : {tk_assign} CREATE WHEN B1 CALL_SEND EMP_IDENT ON;
B1 : K;
ON : {tk_on} {tk_id}
   | ¿;
CREATE : {tk_create}
       | ¿;
WHEN : {tk_when}
     | ¿;
// int/real
C : {tk_aug_plus} D
  | {tk_aug_minus} D
  | {tk_aug_expon} D
  | {tk_aug_div} D
  | {tk_aug_aster} D;
D : K;

//Assignment bool or and
E : {tk_aug_or} F
  | {tk_aug_and} F;
F : K;

//Assignment concat
G : {tk_aug_concat} H;
H : K;

//Assignment shift
I : {tk_aug_lshift} J
  | {tk_aug_rshift} J
  ;
J : K;
//====================================================
//Call y send
CALL: {tk_call} {tk_id} PRO_NEXT PAREN;
PRO_NEXT: {tk_period} {tk_id} PRO_NEXT
             | ¿;
SEND: {tk_send} {tk_id} PRO_NEXT PAREN;

CALL_OR_SEND: {tk_lbrace} CALL_SEND {tk_rbrace}
            | ¿;
CALL_SEND: {tk_send}
         | {tk_call}
         | ¿;
//Identificadores dado que puede ser id1.id2.id3.fun()
IDENT      : {tk_id} NEXT_IDENT;
NEXT_IDENT : {tk_period} {tk_id} NEXT_IDENT
           | PAREN
           | {tk_lbracket} {tk_aster} {tk_rbracket}
           | ¿;
//se toma que se tiene un identidicador o palabra reservada y lo siguiente solo se encarga del parentesis (a,...,b)
//paren
PAREN      : {tk_lparen} PAREN_POS NEXT_F {tk_rparen};
NEXT_F     : {tk_comma} PAREN_POS_OB NEXT_F
           | ¿;
PAREN_POS   : K
           | VAR_CONST
           | {tk_id} PAREN_N
           | ¿;
PAREN_POS_OB: K
            | VAR_CONST
            | {tk_id} PAREN_N;
PAREN_N    : PAREN
           | {tk_colon} DAT SEMICOLON;
//====================================================
//////////Operators
K : L KP;
KP : {tk_or} L KP
   | {tk_xor} L KP
   | ¿;
L  : O LP;
LP :  {tk_and} O LP
   | ¿;

//real str
O  : Q OP;
OP : {tk_le} Q OP
   | {tk_ge} Q OP
   | {tk_lt} Q OP
   | {tk_gt} Q OP
   | {tk_ne} Q OP
   | {tk_eq} Q OP
   | ¿;

//int
Q  : S QP;
QP : {tk_rshift} S QP
   | {tk_lshift} S QP
   | ¿;

S  : U SP;
SP : {tk_concat} U SP
   | ¿;

// int real
U  : V UP;
UP : {tk_minus} V UP
   | {tk_plus} V UP
   | ¿;

V  : W VP;
VP :{tk_mod} W VP
   | {tk_remdr} W VP
   | {tk_div} W VP
   | {tk_aster} W VP
   | ¿;
W  : Y {tk_expon} W
   | Y;
 ////////////
Y  : {tk_qmark} Y
   | {tk_addr} Y
   | {tk_decr} Y
   | {tk_incr} Y
   | {tk_minus} Y
   | {tk_plus} Y
   | {tk_not} Y
   | Z;
Z  : A1 ZP;
ZP : {tk_hat} ZP
   | {tk_decr} ZP
   | {tk_incr} ZP
   | ¿;

A1 : IDENT
   | {tk_num_int_oct}
   | {tk_num_int_dec}
   | {tk_num_int_hex}
   | {tk_true}
   | {tk_false}
   | {tk_cadena}
   | {tk_caracter}
   | {tk_num_real}
   | PAREN;
//======================================== new grammar
GLOBAL: {tk_global} IDENT CONST_OR_TYPE {tk_end};
CONST_OR_TYPE: CONSTANT
                              |TYPE;
RESOURCE_SPECIFICATION:
RESOURCE_BODY:
PROC: {tk_proc}
CONSTANT: {tk_const} IDENT {tk_eq} EXPRESSION;
TYPE: {tk_type} {tk_id} {tk_eq} TYPE_SPECIFICATION;
OPTYPE: {tk_optype} IDENT  {tk_eq} //parametros o returns
VARIABLE: {tk_var} {tk_id}  VAR_SUBSCRIP {tk_colon} DAT
OPERATION:  {tk_op} IDENT  //subscripsts PARENTS //RETURNS
IDENT: {tk_id} NEXT_IDENT;
NEXT_IDENT: {tk_period} {tk_id} NEXT_IDENT
                        |¿;

