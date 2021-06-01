parser grammar SeraphParser;

options {
	tokenVocab = SeraphLexer;
}

oS_Seraph: oS_RegisterQuery;

oS_RegisterQuery:
	REGISTER QUERY oS_QueryName OPENB oS_QueryInput oS_QueryCypher oS_QueryOutput CLOSEB EOF;

oS_QueryName: WORD;

oS_QueryCypher: CYPHER_QUERY;

/*
 * Input definition
 */
oS_QueryInput:
	FROM STREAM oS_InputStream STARTING FROM oS_TimeInstant WITH WINDOW RANGE oS_WindowRange;

oS_InputStream: KAFKA_TOPIC;

oS_TimeInstant: EARLIEST | LATEST | oS_ISO_8601_Datetime;

oS_ISO_8601_Datetime: ISO8601_DATETIME_UTC;

/*
 * Window range
 */
oS_WindowRange: oS_WindowEventRange | oS_WindowTimeRange;

oS_WindowEventRange:
	(WINDOW_RANGE_INT WINDOW_RANGE_EVENT)
	| (WINDOW_RANGE_INT WINDOW_RANGE_EVENTS);

oS_WindowTimeRange: WINDOW_RANGE_ISO8601DURATION;

/*
 * Output definition
 */
oS_QueryOutput:
	EMIT oS_Emit EVERY oS_EmitRange INTO oS_OutputStream;

oS_Emit: (ON ENTERING) | (ON EXIT) | (SNAPSHOT);

oS_OutputStream: KAFKA_TOPIC;

/*
 * Emit range
 */
oS_EmitRange: oS_EmitEventRange | oS_EmitTimeRange;

oS_EmitEventRange:
	(EMIT_RANGE_INT EMIT_RANGE_EVENT)
	| (EMIT_RANGE_INT EMIT_RANGE_EVENTS);

oS_EmitTimeRange: EMIT_RANGE_ISO8601DURATION;