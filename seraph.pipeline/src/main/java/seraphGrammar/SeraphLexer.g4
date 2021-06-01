lexer grammar SeraphLexer;

OPENB: '{';

CLOSEB: '}';

REGISTER: ('R' | 'r') ('E' | 'e') ('G' | 'g') ('I' | 'i') (
		'S'
		| 's'
	) ('T' | 't') ('E' | 'e') ('R' | 'r');

QUERY: ('Q' | 'q') ('U' | 'u') ('E' | 'e') ('R' | 'r') (
		'Y'
		| 'y'
	);

STREAM: ('S' | 's') ('T' | 't') ('R' | 'r') ('E' | 'e') (
		'A'
		| 'a'
	) ('M' | 'm');

STARTING: ('S' | 's') ('T' | 't') ('A' | 'a') ('R' | 'r') (
		'T'
		| 't'
	) ('I' | 'i') ('N' | 'n') ('G' | 'g');

WITH: ( 'W' | 'w') ( 'I' | 'i') ( 'T' | 't') ( 'H' | 'h');

WINDOW: ('W' | 'w') ('I' | 'i') ('N' | 'n') ('D' | 'd') (
		'O'
		| 'o'
	) ('W' | 'w');

RANGE: ('R' | 'r') ('A' | 'a') ('N' | 'n') ('G' | 'g') (
		'E'
		| 'e'
	) -> mode(WINDOW_RANGE);

EMIT: ( 'E' | 'e') ( 'M' | 'm') ( 'I' | 'i') ( 'T' | 't');

ON: ( 'O' | 'o') ( 'N' | 'n');

ENTERING: ('E' | 'e') ('N' | 'n') ('T' | 't') ('E' | 'e') (
		'R'
		| 'r'
	) ('I' | 'i') ('N' | 'n') ('G' | 'g');

EVERY: ('E' | 'e') ('V' | 'v') ('E' | 'e') ('R' | 'r') (
		'Y'
		| 'y'
	) -> mode(EMIT_RANGE);

INTO: ( 'I' | 'i') ( 'N' | 'n') ( 'T' | 't') ( 'O' | 'o');

EXIT: ( 'E' | 'e') ( 'X' | 'x') ( 'I' | 'i') ( 'T' | 't');

SNAPSHOT: ('S' | 's') ('N' | 'n') ('A' | 'a') ('P' | 'p') (
		'S'
		| 's'
	) ('H' | 'h') ('O' | 'o') ('T' | 't');

EARLIEST: ('E' | 'e') ('A' | 'a') ('R' | 'r') ('L' | 'l') (
		'I'
		| 'i'
	) ('E' | 'e') ('S' | 's') ('T' | 't');

LATEST: ('L' | 'l') ('A' | 'a') ('T' | 't') ('E' | 'e') (
		'S'
		| 's'
	) ('T' | 't');

FROM: ( 'F' | 'f') ( 'R' | 'r') ( 'O' | 'o') ( 'M' | 'm');

KAFKA_TOPIC: 'kafka://' WORD '/' WORD;

DIGIT: '0' ..'9';

MONTH: DIGIT DIGIT;

DAY: DIGIT DIGIT;

YEAR: DIGIT DIGIT DIGIT DIGIT;

HOURS: DIGIT DIGIT;

MINUTES: DIGIT DIGIT;

SECONDS: DIGIT DIGIT;

ISO8601_DATETIME_UTC:
	YEAR '-' MONTH '-' DAY 'T' HOURS ':' MINUTES ':' SECONDS 'Z';

WORD: ('a' ..'z' | 'A' ..'Z' | '(' | '{' | '}') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '-'
		| '_'
		| ':'
		| '('
		| ')'
		| '['
		| ']'
		| '{'
		| '}'
		| '*'
		| '.'
		| ','
		| '|'
		| '>'
	)*;

WS: (' ' | '\t' | '\r' | '\n')+ -> skip;

mode WINDOW_RANGE;

WINDOW_RANGE_EVENTS: ('E' | 'e') ('V' | 'v') ('E' | 'e') (
		'N'
		| 'n'
	) ('T' | 't') ('S' | 's') -> mode(CYPHER);

WINDOW_RANGE_EVENT: ('E' | 'e') ('V' | 'v') ('E' | 'e') (
		'N'
		| 'n'
	) ('T' | 't') -> mode(CYPHER);

WINDOW_RANGE_INT: '0' ..'9'+;

WINDOW_RANGE_ISO8601DURATION:
	'P' (WINDOW_RANGE_INT 'Y')? (WINDOW_RANGE_INT 'M')? (
		WINDOW_RANGE_INT 'D'
	)? 'T' (WINDOW_RANGE_INT 'H')? (WINDOW_RANGE_INT 'M')? (
		WINDOW_RANGE_INT 'S'
	)? -> mode(CYPHER);

WINDOW_RANGE_WS: (' ' | '\t' | '\r' | '\n')+ -> skip;

mode EMIT_RANGE;

EMIT_RANGE_EVENTS: ('E' | 'e') ('V' | 'v') ('E' | 'e') (
		'N'
		| 'n'
	) ('T' | 't') ('S' | 's') -> mode(DEFAULT_MODE);

EMIT_RANGE_EVENT: ('E' | 'e') ('V' | 'v') ('E' | 'e') ('N' | 'n') (
		'T'
		| 't'
	) -> mode(DEFAULT_MODE);

EMIT_RANGE_INT: '0' ..'9'+;

EMIT_RANGE_ISO8601DURATION:
	'P' (EMIT_RANGE_INT 'Y')? (EMIT_RANGE_INT 'M')? (
		EMIT_RANGE_INT 'D'
	)? 'T' (EMIT_RANGE_INT 'H')? (EMIT_RANGE_INT 'M')? (
		EMIT_RANGE_INT 'S'
	)? -> mode(DEFAULT_MODE);

EMIT_RANGE_WS: (' ' | '\t' | '\r' | '\n')+ -> skip;

mode CYPHER;

CYPHER_QUERY: .+? ';' -> mode(DEFAULT_MODE);
