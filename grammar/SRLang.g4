/** SR Language Grammar
* The University of Arizona - 2005
*
* Adaptado por:
*Alberto Nicolai Romero Martínez
*Julián David Rodríguez Ruiz
*Edder Hernandez Forero
*
*Para el curso "Lenguajes de Programación - 1"
*Universidad Nacional de Colombia - 2019-3
*/
grammar SRLang;
//PARSER

/*Hola persona del futuro

La gramática ya sirve (o al menos está muy cerca),
sin embargo creo que aún se pueden hacer
optimizaciones. (Les ahorrará trabajo casi seguro)

Las reglas que dicen List/LP/Optional al final son usadas para repetir
producciones progresivamente.

Como ANTLR permite el uso de expresiones regulares en sus producciones
sintácticas, esto puede eliminar a la larga bastantes reglas.




*/
//PARSER RULES
components: component*| TK_SEPARATOR component*;

component:
	specificComponent
	|   combinedComponent
	|   separateBody
	;

specificComponent:
	    componentLabel specificStatementList specificBody	
	;

combinedComponent:
	    combinedspecificPart bodyStatementList endId ;

combinedspecificPart:
	    componentLabel componentParams		;

componentLabel:
	    componentKeyword TK_ID			;

componentKeyword:
	    TK_GLOBAL
	|   TK_RESOURCE
	;


specificBody:
	     endId	/* No explicit body */
	|   TK_BODY TK_ID optionalParams  bodyStatementList endId
	|   TK_BODY TK_ID optionalParams  TK_SEPARATE
	;

optionalParams:
	    /* epsilon (Empty production) */
	|   componentParams
	;

componentParams:
	    parameters
	;

separateBody:
	    TK_BODY TK_ID bodyStatementList endId
	;



/*************************  Specific/body contents  *************************/

specificStatementList:
	    specificStatement
	|   specificStatementList TK_SEPARATOR specificStatement
	;

specificStatement:
	    commonStatement
	|   extendClause
	|   bodyOnly
	;


bodyStatementList:
	    bodyStatement
	|   bodyStatementList TK_SEPARATOR bodyStatement
	;

bodyStatement:
	    commonStatement
	|   expression 
	|   bodyOnly
	|   extendClause  ;

bodyOnly:
	    statement
	|   proc
	|   process
	|   procedure
	|   initialBlock
	|   finalBlock
	;


commonStatement:
	    /* epsilon (Empty production) */
	|   declaration
	|   importClause
	;


importClause:
	    TK_IMPORT
	;

extendClause:
	    TK_EXTEND  importList

	;

importList:
	    importName
	|   importList TK_COMMA importName
	;

importName:
	    TK_ID
	;


/*************************  top-level body statementents  *************************/

opDeclaration:
	    opOrExternal operDefLP
	;

opOrExternal:
	    TK_OP
	|   TK_EXTERNAL
	;

operDefLP:
	    operDef
	|   operDefLP TK_COMMA operDef
	;

operDef:
	    idSubsLP opPrototype
	|   idSubsLP colonOpt qualifiedID
	;

colonOpt:
	    /* epsilon (Empty production) */
	|   TK_COLON
	;


semDeclaration:
	    TK_SEM semDefLP
	;

semDefLP:
	    semDef
	|   semDefLP TK_COMMA semDef
	;

semDef:
	    idSubs semPrototype semInit		;

semPrototype:
	    returnSpecificNull			;

semInit:
	    /* epsilon (Empty production) */
	|   TK_ASSIGN expression
	;



proc:
	    TK_PROC TK_ID paramNames
	        block
	    endId
	;


procedure:
	    TK_PROCEDURE TK_ID prototype
		block
	    endId
	;


process:
	    TK_PROCESS TK_ID returnSpecificNull quantifiersOptional
		block
	    endId
	;


initialBlock:					/* for compatibility */
	    TK_INITIAL block TK_END initialOptional
	;

initialOptional:
	    /* epsilon (Empty production) */
	|   TK_INITIAL
	;


finalBlock:
	    TK_FINAL
	        block
	    TK_END finalOptional
	;

finalOptional:
	    /* epsilon (Empty production) */
	|   TK_FINAL
	;



/******************************  parameters  ******************************/



prototype:
	    parameters returnSpecificOptional
	;

parameters:
	    TK_LPAREN paramSpecificList TK_RPAREN
	;

paramSpecificList:
	    /* epsilon (Empty production) */
	|   paramSpecificLP
	;

paramSpecificLP:
	    paramSpecific
	|   paramSpecific TK_SEPARATOR
	|   paramSpecific TK_SEPARATOR paramSpecificLP
	;

paramSpecific:
	    paramKindOptional type
	|   paramKindOptional idSubsLP TK_COLON type
	;

paramKindOptional:
	    /* epsilon (Empty production) */
	|   TK_VAL
	|   TK_VAR
	|   TK_RES
	|   TK_REF
	;


returnSpecificOptional:
	    returnSpecificNull

	|   TK_RETURNS type
	|   TK_RETURNS idSubs TK_COLON type
	|   TK_RETURNS TK_ID TK_BOGUS	/* never possible, prevents r/r confl */
	;

returnSpecificNull:
	    /* epsilon (Empty production) */
	;



/* param list without types, with optional return */
paramNames:
	    TK_LPAREN idList TK_RPAREN returnNameOptional;

returnNameOptional:
	    /* epsilon (Empty production) */
	|   TK_RETURNS TK_ID
	;



/******************************  declaration  ******************************/

declaration:
	 typeDeclaration
	|   objDeclaration
	|   optypeDeclaration
	|   semDeclaration
	|   opDeclaration
	;


typeDeclaration:
	    TK_TYPE TK_ID TK_EQ type typeRestriction

	;

typeRestriction:		/* to give decent err msg for v1 construct */
	    /* epsilon (Empty production) */
	|   TK_LBRACE TK_ID TK_RBRACE
	;

objDeclaration:
	    varOrConst varDefLP
	;

varOrConst:
	    TK_VAR	/* illegal in specific */
	|   TK_CONST
	;

varDefLP:
	    varDef
	|   varDefLP TK_COMMA varDef
	;

varDef:
	    idSubsLP varAtt
	;

varAtt:
	    TK_COLON type
	|   TK_COLON type TK_ASSIGN expression
	|                 TK_ASSIGN expression
	|   TK_SEPARATOR
	;



/*************************  type specification  *************************/

type:
	    subscripts unsubType
	|   unsubType
	;

unsubType:
	    basicType
	|   stringDef
	|   enumDef
	|   pointerDef
	|   recordDef
	|   unionDef
	|   capabilityDef
	|   qualifiedID
	;

basicType:
	    TK_BOOL
	|   TK_CHAR
	|   TK_INT
	|   TK_FILE
	|   TK_REAL
	;

stringDef:
	    TK_STRING TK_LBRACKET stringLim TK_RBRACKET

	|   TK_STRING TK_LPAREN stringLim TK_RPAREN
	;

stringLim:
	    expression
	|   TK_ASTER
	;

enumDef:
	    TK_ENUM TK_LPAREN idLP TK_RPAREN
	;

pointerDef:
	    TK_PTR type
	|   TK_PTR TK_ANY
	;

recordDef:
	    TK_REC TK_LPAREN fieldLP TK_RPAREN
	;

unionDef:
	    TK_UNION TK_LPAREN fieldLP TK_RPAREN
	;

fieldLP:
	    field
	|   field TK_SEPARATOR
	|   field TK_SEPARATOR fieldLP
	;

field:
        varDefLP
	;

capabilityDef:
	   TK_CAP capFor
	;

capFor:
	    qualifiedID
	|   opPrototype
	|   TK_SEM semPrototype
	|   TK_VM
	;




/******************************  optype  ******************************/

optypeDeclaration:
	    TK_OPTYPE TK_ID eqOpt opPrototype
	;

opPrototype:
	    prototype opRestrictionOpt
	;

eqOpt:
	    /* epsilon (Empty production) */
	|   TK_EQ
	;

opRestrictionOpt:
	    /* epsilon (Empty production) */
	|   TK_LBRACE opRestriction TK_RBRACE
	;

opRestriction:
	    TK_CALL
	|   TK_SEND
	|   TK_CALL TK_COMMA TK_SEND
	|   TK_SEND TK_COMMA TK_CALL
	;



/*************************  blocks and statements  *************************/

block:
	    blockItems
	;

blockItems:
	    blockItem
	|   blockItems TK_SEPARATOR blockItem
	;

blockItem:
	    /* epsilon (Empty production) */
	|   declaration
	|   statement
	|   expression
	|   importClause
	;

statement:
	    skipStatement
	|   stopStatement
	|   exitStatement
	|   nextStatement
	|   returnStatement
	|   replyStatement
	|   forwardStatement
	|   sendStatement
	|   explicitCall
	|   destroyStatement
	|   beginEnd
	|   ifStatement
	|   doStatement
	|   forAllStatement
	|   vStatement
	|   inputStatement
	|   receiveStatement
	|   pStatement
	|   concurrentStatement
	|   writeStatement
	;

writeStatement:
    TK_WRITE TK_LPAREN expression TK_RPAREN
    ;

skipStatement:
	    TK_SKIP
	;

stopStatement:
	    TK_STOP exitCodeOptional
	;

exitCodeOptional:
	    /* epsilon (Empty production) */
	|   TK_LPAREN expression TK_RPAREN
	;

exitStatement:
	    TK_EXIT
	;

nextStatement:
	    TK_NEXT
	;

returnStatement:
	    TK_RETURN
	;

replyStatement:
	    TK_REPLY
	;

forwardStatement:
	    TK_FORWARD invocation
	;

sendStatement:
	    TK_SEND invocation
	;

receiveStatement:
	    TK_RECEIVE expression parenList
	;

vStatement:
	    TK_V TK_LPAREN expression TK_RPAREN
	;

pStatement:
	    TK_P TK_LPAREN expression TK_RPAREN	;

explicitCall:
	    TK_CALL invocation;

destroyStatement:
	    TK_DESTROY expression;

beginEnd:
	    TK_BEGIN block TK_END;

ifStatement:
	    TK_IF guardedCommandLP elseCommandOptional TK_FI;

doStatement:
	    TK_DO guardedCommandLP elseCommandOptional TK_OD;

guardedCommandLP:
	    guardedCommand
	|   guardedCommandLP TK_SQUARE guardedCommand;

guardedCommand:
	    expression TK_ARROW block;

elseCommandOptional:
	    /* epsilon (Empty production) */
	|   TK_SQUARE TK_ELSE TK_ARROW block;


forAllStatement:
	    TK_FA quantifierLP TK_ARROW block TK_AF;



/*************************  input statement *************************/

inputStatement:
	    TK_IN inCommandLP elseCommandOptional TK_NI;

inCommandLP:
	    inCommand
	|   inCommandLP TK_SQUARE inCommand;

inCommand:
	    quantifiersOptional inSpecific syncExpressionOptional scheduleExpressionOptional TK_ARROW block;

inSpecific:
	    inOp paramNames
	;

inOp:
	    qualifiedID	;

syncExpressionOptional:
	    /* epsilon (Empty production) */
	|   TK_AND expression
	|   TK_SUCHTHAT expression
	;

scheduleExpressionOptional:
	    /* epsilon (Empty production) */
	|   TK_BY expression
	;



/*************************  co statement *************************/

concurrentStatement:
	    TK_CO concurrentCommandLP TK_OC
	;

concurrentCommandLP:
	    concurrentCommand
	|   concurrentCommandLP TK_PARALLEL concurrentCommand

	;

concurrentCommand:
	quantifiersOptional separatorOptional concurrentInvocation postProcessingOptional

	;

separatorOptional:		/* allow \n where it can't be handled in scanner */
	    /* epsilon (Empty production) */
	|   separatorOptional TK_SEPARATOR
	;

concurrentInvocation:
	    explicitCall
	|   sendStatement
	|   expression
	;

postProcessingOptional:
	    /* epsilon (Empty production) */
	|   TK_ARROW block
	;



/******************************  quantifier  ******************************/

quantifiersOptional:
	    /* epsilon (Empty production) */
	|   TK_LPAREN quantifierLP TK_RPAREN
	;

quantifierLP:
	    quantifier
	|   quantifierLP TK_COMMA quantifier
	;

quantifier:
	    TK_ID TK_ASSIGN expression direction expression stepOptional suchThatOptional
	;

direction:
	    TK_TO
	|   TK_DOWNTO
	;

stepOptional:
	    /* epsilon (Empty production) */
	|   TK_BY expression
	;

suchThatOptional:
	    /* epsilon (Empty production) */
	|   TK_SUCHTHAT expression
	;



/******************************  expressionession  ******************************/

expression:
	    TK_ID
	|   literal
	|   constructor
	|   createExpression
	//|   invocation
	| expression parenList
	|   prefixExpression
    //|   suffixExpression
	 |   expression TK_INCR
	|   expression TK_DECR
	|   expression TK_HAT
	|   expression TK_PERIOD TK_ID
	|   expression TK_LBRACKET boundLP TK_RBRACKET

	//|   binaryExpression
    	|   expression TK_EXPON	expression
    	|   expression TK_ASTER	expression
    	|   expression TK_DIV		expression
    	|   expression TK_MOD		expression
    	|   expression TK_REMDR	expression
    	|   expression TK_PLUS	expression
    	|   expression TK_MINUS	expression
    	|   expression TK_CONCAT	expression
    	|   expression TK_EQ		expression
    	|   expression TK_NE		expression
    	|   expression TK_GE		expression
    	|   expression TK_LE		expression
    	|   expression TK_GT		expression
    	|   expression TK_LT		expression
    	|   expression TK_AND		expression
    	|   expression TK_OR		expression
    	|   expression TK_XOR		expression
    	|   expression TK_RSHIFT	expression
    	|   expression TK_LSHIFT	expression
    	|   expression TK_SWAP	expression
    	|   expression TK_ASSIGN	expression
    	|   expression TK_AUG_PLUS	expression
    	|   expression TK_AUG_MINUS	expression
    	|   expression TK_AUG_ASTER	expression
    	|   expression TK_AUG_DIV	expression
    	|   expression TK_AUG_REMDR	expression
    	|   expression TK_AUG_EXPON	expression
    	|   expression TK_AUG_OR	expression
    	|   expression TK_AUG_AND	expression
    	|   expression TK_AUG_CONCAT	expression
    	|   expression TK_AUG_RSHIFT	expression
    	|   expression TK_AUG_LSHIFT	expression
    	;

literal:
	    TK_ILIT
	|   TK_RLIT
	|   TK_BLIT
	|   TK_CLIT
	|   TK_SLIT
	|   TK_NLIT
	|   TK_FLIT
	;



prefixExpression:
	    TK_NOT	expression	   
	|   TK_PLUS	expression	   
	|   TK_MINUS	expression	   
	|   TK_ADDR	expression	   
	|   TK_QMARK	expression	   
	|   TK_INCR expression	   
	|   TK_DECR expression	   
	|   basicType parenExpression  
	|   TK_STRING parenExpression

	|   TK_LOW  TK_LPAREN type TK_RPAREN
	|   TK_HIGH TK_LPAREN type TK_RPAREN
	|   TK_NEW  TK_LPAREN subscriptsOptional newItem TK_RPAREN

	;

newItem:
	    unsubType;

parenExpression:
	    TK_LPAREN expression TK_RPAREN
	;


invocation:

	;

parenList:
	    TK_LPAREN parenItemList TK_RPAREN
	;

parenItemList:
	    /* epsilon (Empty production) */
	|   expressionLP
	;

expressionLP:
	    expression
	|   expressionLP TK_COMMA expression
	;


constructor:
	    TK_LPAREN constrItemLP TK_RPAREN
	;

constrItemLP:
	    constrItem
	|   constrItemLP TK_COMMA constrItem
	;

constrItem:
	    expression
	|   TK_LBRACKET expression TK_RBRACKET expression
	;


createExpression:
	    TK_CREATE createCall locationOptional
	;

createCall:
	    resourceName parenList		
	;

resourceName:
	    TK_ID				
	|   TK_VM				
	;

locationOptional:
	    /* epsilon (Empty production) */				
	|   TK_ON expression				
	;



/******************************  miscellaneous  ******************************/

qualifiedID:
	    TK_ID				
	|   TK_ID TK_PERIOD TK_ID		
	;

endId:
	    TK_END idOptional			
	;

idOptional:
	    /* epsilon (Empty production) */				
	|   TK_ID				
	;

idList:
	    /* epsilon (Empty production) */				
	|   idLP				
	;

idLP:
	    TK_ID				
	|   idLP TK_COMMA TK_ID		
	;

idSubsLP:
	    idSubs				
	|   idSubsLP TK_COMMA idSubs		
	;

idSubs:
	    TK_ID				
	|   TK_ID subscripts			
	;

subscripts:
	    bracketedList			
	|   bracketedList subscripts		
	;

subscriptsOptional:
	    /* epsilon (Empty production) */				
	|   subscripts				
	;

bracketedList:
	    TK_LBRACKET boundLP TK_RBRACKET	
	;

boundLP:
	    bounds				
	|   boundLP TK_COMMA bounds		
	;

bounds:
	    bound			        
	|   bound TK_COLON bound		
	;

bound:
	    expression				
	|   TK_ASTER				
	;

//LEXER RULES - TOKENS

//Reserved Words
TK_P: 'P' ;
TK_V: 'V' ;
TK_AF: 'af' ;
TK_AND: 'and'  | '&' ;
TK_ANY: 'any' ;
TK_BEGIN: 'begin' ;
TK_BODY: 'body' ;
TK_BOOL: 'bool' ;
TK_BY: 'by' ;
TK_CALL: 'call' ;
TK_CAP: 'cap' ;
TK_CHAR: 'char' ;
TK_CO: 'co' ;
TK_CONST: 'const' ;
TK_CREATE: 'create' ;
TK_DESTROY: 'destroy' ;
TK_DO: 'do' ;
TK_DOWNTO: 'downto' ;
TK_ELSE: 'else' ;
TK_END: 'end' ;
TK_ENUM: 'enum' ;
TK_EXIT: 'exit' ;
TK_EXTEND: 'extend' ;
TK_EXTERNAL: 'external' ;
TK_FA: 'fa' ;
TK_FI: 'fi' ;
TK_FILE: 'file' ;
TK_FINAL: 'final' ;
TK_FORWARD: 'forward' ;
TK_GLOBAL: 'global' ;
TK_HIGH: 'high' ;
TK_IF: 'if' ;
TK_IMPORT: 'import' ;
TK_IN: 'in' ;
TK_INITIAL: 'initial' ;
TK_INT: 'int' ;
TK_LOW: 'low' ;
TK_MOD: 'mod' ;
TK_NEW: 'new' ;
TK_NEXT: 'next' ;
TK_NI: 'ni' ;
TK_NOT: 'not' | '~'  ;
TK_OC: 'oc' ;
TK_OD: 'od' ;
TK_ON: 'on' ;
TK_OP: 'op' ;
TK_OPTYPE: 'optype' ;
TK_OR: 'or' | '|';
TK_PROC: 'proc' ;
TK_PROCEDURE: 'procedure' ;
TK_PROCESS: 'process' ;
TK_PTR: 'ptr' ;
TK_REAL: 'real' ;
TK_REC: 'rec' ;
TK_RECEIVE: 'receive' ;
TK_REF: 'ref' ;
TK_REPLY: 'reply' ;
TK_RES: 'res' ;
TK_RESOURCE: 'resource' ;
TK_RETURN: 'return' ;
TK_RETURNS: 'returns' ;
TK_SEM: 'sem' ;
TK_SEND: 'send' ;
TK_SEPARATE: 'separate' ;
TK_SKIP: 'skip' ;
TK_SUCHTHAT: 'st' ;
TK_STOP: 'stop' ;
TK_STRING: 'string' ;
TK_TO: 'to' ;
TK_TYPE: 'type' ;
TK_UNION: 'union' ;
TK_VAL: 'val' ;
TK_VAR: 'var' ;
TK_VM: 'vm' ;
TK_WRITE: 'write';
TK_XOR: 'xor' ;

//Operators
TK_COMMA: ',' ;
TK_COLON: ':' ;
TK_EQ: '=' ;
TK_INCR: '++' ;
TK_PLUS: '+' ;
TK_DECR: '--' ;
TK_MINUS: '-' ;
TK_ASTER: '*' ;
TK_EXPON: '**' ;
TK_DIV: '/' ;
TK_REMDR: '%' ;
TK_LPAREN: '(' ;
TK_RPAREN: ')' ;
TK_ARROW: '->' ;
TK_SQUARE: '[]' ;
TK_ASSIGN: ':=' ;
TK_SWAP: ':=:' ;
TK_LBRACKET: '[' ;
TK_RBRACKET: ']' ;
TK_GE: '>=' ;
TK_LE: '<=' ;
TK_GT: '>' ;
TK_LT: '<' ;
TK_NE: '!=' | '~=' ;
TK_PERIOD: '.' ;
TK_ADDR: '@' ;
TK_HAT: '^' ;
TK_CONCAT: '||' ;
TK_LBRACE: '{' ;
TK_RBRACE: '}' ;
TK_QMARK: '?' ;
TK_PARALLEL: '//' ;
TK_RSHIFT: '>>' ;
TK_LSHIFT: '<<' ;
TK_AUG_PLUS: '+:=' ;
TK_AUG_MINUS: '-:=' ;
TK_AUG_ASTER: '*:=' ;
TK_AUG_EXPON: '**:=' ;
TK_AUG_DIV: '/:=' ;
TK_AUG_REMDR: '%:=' ;
TK_AUG_OR: '|:=' ;
TK_AUG_AND: '&:=' ;
TK_AUG_CONCAT: '||:=' ;
TK_AUG_RSHIFT: '>>:=' ;
TK_AUG_LSHIFT: '<<:=' ;
TK_SEPARATOR: ';'|'\n';



//Identificators
TK_ID: [A-Za-z][A-Za-z0-9_]*;


//Primitive literals
fragment
DIGIT: [0-9];
fragment
EXP: [eE][+-]? (DIGIT)+;

TK_ILIT:
        INT10
        |INT8
        |INT16;

fragment
INT8: [0-7]+[qQ];
fragment
INT10:[0-9]+;
fragment
INT16:[0-9][0-9a-fA-F]*[Xx];

TK_RLIT:
    DIGIT+ '.' DIGIT* EXP?
    |'.' DIGIT+ EXP?
    |DIGIT+ EXP;
TK_BLIT: 'false' | 'true';
TK_CLIT: '\'' CHAR '\'';


fragment
CHAR: ~['\\\r\n];
TK_SLIT: '"'  CHAR*? '"';


TK_NLIT: 'noop' | 'null';
TK_FLIT: 'stderr' | 'stdin' | 'stdout';
TK_BOGUS : '<ERROR, THIS SHOULD NOT HAPPEN>'; //Este token es usado para evitar ambiguedad

COMMENT
    :   '/*' .*? '*/' -> skip;
LINE_COMMENT
    :   CMT_LITERAL ~[\r\n]* -> skip;

fragment
CMT_LITERAL: '#'+ | '/' '/'+;
WHITESPACE  :  [ \t\r]+ -> skip
    ;




