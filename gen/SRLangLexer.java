// Generated from C:/Users/Nicolai Romero/Desktop/LP-3-Interprete/grammar\SRLang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SRLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TK_P=1, TK_V=2, TK_AF=3, TK_AND=4, TK_ANY=5, TK_BEGIN=6, TK_BODY=7, TK_BOOL=8, 
		TK_BY=9, TK_CALL=10, TK_CAP=11, TK_CHAR=12, TK_CO=13, TK_CONST=14, TK_CREATE=15, 
		TK_DESTROY=16, TK_DO=17, TK_DOWNTO=18, TK_ELSE=19, TK_END=20, TK_ENUM=21, 
		TK_EXIT=22, TK_EXTEND=23, TK_EXTERNAL=24, TK_FA=25, TK_FI=26, TK_FILE=27, 
		TK_FINAL=28, TK_FORWARD=29, TK_GLOBAL=30, TK_HIGH=31, TK_IF=32, TK_IMPORT=33, 
		TK_IN=34, TK_INITIAL=35, TK_INT=36, TK_LOW=37, TK_MOD=38, TK_NEW=39, TK_NEXT=40, 
		TK_NI=41, TK_NOT=42, TK_OC=43, TK_OD=44, TK_ON=45, TK_OP=46, TK_OPTYPE=47, 
		TK_OR=48, TK_PROC=49, TK_PROCEDURE=50, TK_PROCESS=51, TK_PTR=52, TK_REAL=53, 
		TK_REC=54, TK_RECEIVE=55, TK_REF=56, TK_REPLY=57, TK_RES=58, TK_RESOURCE=59, 
		TK_RETURN=60, TK_RETURNS=61, TK_SEM=62, TK_SEND=63, TK_SEPARATE=64, TK_SKIP=65, 
		TK_SUCHTHAT=66, TK_STOP=67, TK_STRING=68, TK_TO=69, TK_TYPE=70, TK_UNION=71, 
		TK_VAL=72, TK_VAR=73, TK_VM=74, TK_XOR=75, TK_COMMA=76, TK_COLON=77, TK_EQ=78, 
		TK_INCR=79, TK_PLUS=80, TK_DECR=81, TK_MINUS=82, TK_ASTER=83, TK_EXPON=84, 
		TK_DIV=85, TK_REMDR=86, TK_LPAREN=87, TK_RPAREN=88, TK_ARROW=89, TK_SQUARE=90, 
		TK_ASSIGN=91, TK_SWAP=92, TK_LBRACKET=93, TK_RBRACKET=94, TK_GE=95, TK_LE=96, 
		TK_GT=97, TK_LT=98, TK_NE=99, TK_PERIOD=100, TK_ADDR=101, TK_HAT=102, 
		TK_CONCAT=103, TK_LBRACE=104, TK_RBRACE=105, TK_QMARK=106, TK_PARALLEL=107, 
		TK_RSHIFT=108, TK_LSHIFT=109, TK_AUG_PLUS=110, TK_AUG_MINUS=111, TK_AUG_ASTER=112, 
		TK_AUG_EXPON=113, TK_AUG_DIV=114, TK_AUG_REMDR=115, TK_AUG_OR=116, TK_AUG_AND=117, 
		TK_AUG_CONCAT=118, TK_AUG_RSHIFT=119, TK_AUG_LSHIFT=120, TK_SEPARATOR=121, 
		TK_ID=122, TK_ILIT=123, TK_RLIT=124, TK_BLIT=125, TK_CLIT=126, TK_SLIT=127, 
		TK_NLIT=128, TK_FLIT=129, TK_BOGUS=130, COMMENT=131, LINE_COMMENT=132, 
		WHITESPACE=133;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TK_P", "TK_V", "TK_AF", "TK_AND", "TK_ANY", "TK_BEGIN", "TK_BODY", "TK_BOOL", 
			"TK_BY", "TK_CALL", "TK_CAP", "TK_CHAR", "TK_CO", "TK_CONST", "TK_CREATE", 
			"TK_DESTROY", "TK_DO", "TK_DOWNTO", "TK_ELSE", "TK_END", "TK_ENUM", "TK_EXIT", 
			"TK_EXTEND", "TK_EXTERNAL", "TK_FA", "TK_FI", "TK_FILE", "TK_FINAL", 
			"TK_FORWARD", "TK_GLOBAL", "TK_HIGH", "TK_IF", "TK_IMPORT", "TK_IN", 
			"TK_INITIAL", "TK_INT", "TK_LOW", "TK_MOD", "TK_NEW", "TK_NEXT", "TK_NI", 
			"TK_NOT", "TK_OC", "TK_OD", "TK_ON", "TK_OP", "TK_OPTYPE", "TK_OR", "TK_PROC", 
			"TK_PROCEDURE", "TK_PROCESS", "TK_PTR", "TK_REAL", "TK_REC", "TK_RECEIVE", 
			"TK_REF", "TK_REPLY", "TK_RES", "TK_RESOURCE", "TK_RETURN", "TK_RETURNS", 
			"TK_SEM", "TK_SEND", "TK_SEPARATE", "TK_SKIP", "TK_SUCHTHAT", "TK_STOP", 
			"TK_STRING", "TK_TO", "TK_TYPE", "TK_UNION", "TK_VAL", "TK_VAR", "TK_VM", 
			"TK_XOR", "TK_COMMA", "TK_COLON", "TK_EQ", "TK_INCR", "TK_PLUS", "TK_DECR", 
			"TK_MINUS", "TK_ASTER", "TK_EXPON", "TK_DIV", "TK_REMDR", "TK_LPAREN", 
			"TK_RPAREN", "TK_ARROW", "TK_SQUARE", "TK_ASSIGN", "TK_SWAP", "TK_LBRACKET", 
			"TK_RBRACKET", "TK_GE", "TK_LE", "TK_GT", "TK_LT", "TK_NE", "TK_PERIOD", 
			"TK_ADDR", "TK_HAT", "TK_CONCAT", "TK_LBRACE", "TK_RBRACE", "TK_QMARK", 
			"TK_PARALLEL", "TK_RSHIFT", "TK_LSHIFT", "TK_AUG_PLUS", "TK_AUG_MINUS", 
			"TK_AUG_ASTER", "TK_AUG_EXPON", "TK_AUG_DIV", "TK_AUG_REMDR", "TK_AUG_OR", 
			"TK_AUG_AND", "TK_AUG_CONCAT", "TK_AUG_RSHIFT", "TK_AUG_LSHIFT", "TK_SEPARATOR", 
			"TK_ID", "DIGIT", "EXP", "TK_ILIT", "INT8", "INT10", "INT16", "TK_RLIT", 
			"TK_BLIT", "TK_CLIT", "CHAR", "TK_SLIT", "TK_NLIT", "TK_FLIT", "TK_BOGUS", 
			"COMMENT", "LINE_COMMENT", "CMT_LITERAL", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'P'", "'V'", "'af'", null, "'any'", "'begin'", "'body'", "'bool'", 
			"'by'", "'call'", "'cap'", "'char'", "'co'", "'const'", "'create'", "'destroy'", 
			"'do'", "'downto'", "'else'", "'end'", "'enum'", "'exit'", "'extend'", 
			"'external'", "'fa'", "'fi'", "'file'", "'final'", "'forward'", "'global'", 
			"'high'", "'if'", "'import'", "'in'", "'initial'", "'int'", "'low'", 
			"'mod'", "'new'", "'next'", "'ni'", null, "'oc'", "'od'", "'on'", "'op'", 
			"'optype'", null, "'proc'", "'procedure'", "'process'", "'ptr'", "'real'", 
			"'rec'", "'receive'", "'ref'", "'reply'", "'res'", "'resource'", "'return'", 
			"'returns'", "'sem'", "'send'", "'separate'", "'skip'", "'st'", "'stop'", 
			"'string'", "'to'", "'type'", "'union'", "'val'", "'var'", "'vm'", "'xor'", 
			"','", "':'", "'='", "'++'", "'+'", "'--'", "'-'", "'*'", "'**'", "'/'", 
			"'%'", "'('", "')'", "'->'", "'[]'", "':='", "':=:'", "'['", "']'", "'>='", 
			"'<='", "'>'", "'<'", null, "'.'", "'@'", "'^'", "'||'", "'{'", "'}'", 
			"'?'", "'//'", "'>>'", "'<<'", "'+:='", "'-:='", "'*:='", "'**:='", "'/:='", 
			"'%:='", "'|:='", "'&:='", "'||:='", "'>>:='", "'<<:='", "';'", null, 
			null, null, null, null, null, null, null, "'<ERROR, THIS SHOULD NOT HAPPEN>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TK_P", "TK_V", "TK_AF", "TK_AND", "TK_ANY", "TK_BEGIN", "TK_BODY", 
			"TK_BOOL", "TK_BY", "TK_CALL", "TK_CAP", "TK_CHAR", "TK_CO", "TK_CONST", 
			"TK_CREATE", "TK_DESTROY", "TK_DO", "TK_DOWNTO", "TK_ELSE", "TK_END", 
			"TK_ENUM", "TK_EXIT", "TK_EXTEND", "TK_EXTERNAL", "TK_FA", "TK_FI", "TK_FILE", 
			"TK_FINAL", "TK_FORWARD", "TK_GLOBAL", "TK_HIGH", "TK_IF", "TK_IMPORT", 
			"TK_IN", "TK_INITIAL", "TK_INT", "TK_LOW", "TK_MOD", "TK_NEW", "TK_NEXT", 
			"TK_NI", "TK_NOT", "TK_OC", "TK_OD", "TK_ON", "TK_OP", "TK_OPTYPE", "TK_OR", 
			"TK_PROC", "TK_PROCEDURE", "TK_PROCESS", "TK_PTR", "TK_REAL", "TK_REC", 
			"TK_RECEIVE", "TK_REF", "TK_REPLY", "TK_RES", "TK_RESOURCE", "TK_RETURN", 
			"TK_RETURNS", "TK_SEM", "TK_SEND", "TK_SEPARATE", "TK_SKIP", "TK_SUCHTHAT", 
			"TK_STOP", "TK_STRING", "TK_TO", "TK_TYPE", "TK_UNION", "TK_VAL", "TK_VAR", 
			"TK_VM", "TK_XOR", "TK_COMMA", "TK_COLON", "TK_EQ", "TK_INCR", "TK_PLUS", 
			"TK_DECR", "TK_MINUS", "TK_ASTER", "TK_EXPON", "TK_DIV", "TK_REMDR", 
			"TK_LPAREN", "TK_RPAREN", "TK_ARROW", "TK_SQUARE", "TK_ASSIGN", "TK_SWAP", 
			"TK_LBRACKET", "TK_RBRACKET", "TK_GE", "TK_LE", "TK_GT", "TK_LT", "TK_NE", 
			"TK_PERIOD", "TK_ADDR", "TK_HAT", "TK_CONCAT", "TK_LBRACE", "TK_RBRACE", 
			"TK_QMARK", "TK_PARALLEL", "TK_RSHIFT", "TK_LSHIFT", "TK_AUG_PLUS", "TK_AUG_MINUS", 
			"TK_AUG_ASTER", "TK_AUG_EXPON", "TK_AUG_DIV", "TK_AUG_REMDR", "TK_AUG_OR", 
			"TK_AUG_AND", "TK_AUG_CONCAT", "TK_AUG_RSHIFT", "TK_AUG_LSHIFT", "TK_SEPARATOR", 
			"TK_ID", "TK_ILIT", "TK_RLIT", "TK_BLIT", "TK_CLIT", "TK_SLIT", "TK_NLIT", 
			"TK_FLIT", "TK_BOGUS", "COMMENT", "LINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SRLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SRLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u0087\u03ee\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k"+
		"\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv"+
		"\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t"+
		"\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089"+
		"\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0127\n\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\5+\u01e9\n+\3,\3"+
		",\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\5\61\u0201\n\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3"+
		"?\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3"+
		"C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3H\3"+
		"H\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3J\3K\3K\3K\3L\3L\3L\3L\3M\3M\3N\3"+
		"N\3O\3O\3P\3P\3P\3Q\3Q\3R\3R\3R\3S\3S\3T\3T\3U\3U\3U\3V\3V\3W\3W\3X\3"+
		"X\3Y\3Y\3Z\3Z\3Z\3[\3[\3[\3\\\3\\\3\\\3]\3]\3]\3]\3^\3^\3_\3_\3`\3`\3"+
		"`\3a\3a\3a\3b\3b\3c\3c\3d\3d\3d\3d\5d\u02d4\nd\3e\3e\3f\3f\3g\3g\3h\3"+
		"h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3l\3m\3m\3m\3n\3n\3n\3o\3o\3o\3o\3p\3p\3"+
		"p\3p\3q\3q\3q\3q\3r\3r\3r\3r\3r\3s\3s\3s\3s\3t\3t\3t\3t\3u\3u\3u\3u\3"+
		"v\3v\3v\3v\3w\3w\3w\3w\3w\3x\3x\3x\3x\3x\3y\3y\3y\3y\3y\3z\3z\3{\3{\7"+
		"{\u0322\n{\f{\16{\u0325\13{\3|\3|\3}\3}\5}\u032b\n}\3}\6}\u032e\n}\r}"+
		"\16}\u032f\3~\3~\3~\5~\u0335\n~\3\177\6\177\u0338\n\177\r\177\16\177\u0339"+
		"\3\177\3\177\3\u0080\6\u0080\u033f\n\u0080\r\u0080\16\u0080\u0340\3\u0081"+
		"\3\u0081\7\u0081\u0345\n\u0081\f\u0081\16\u0081\u0348\13\u0081\3\u0081"+
		"\3\u0081\3\u0082\6\u0082\u034d\n\u0082\r\u0082\16\u0082\u034e\3\u0082"+
		"\3\u0082\7\u0082\u0353\n\u0082\f\u0082\16\u0082\u0356\13\u0082\3\u0082"+
		"\5\u0082\u0359\n\u0082\3\u0082\3\u0082\6\u0082\u035d\n\u0082\r\u0082\16"+
		"\u0082\u035e\3\u0082\5\u0082\u0362\n\u0082\3\u0082\6\u0082\u0365\n\u0082"+
		"\r\u0082\16\u0082\u0366\3\u0082\3\u0082\5\u0082\u036b\n\u0082\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\5\u0083"+
		"\u0376\n\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086"+
		"\3\u0086\7\u0086\u0380\n\u0086\f\u0086\16\u0086\u0383\13\u0086\3\u0086"+
		"\3\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\5\u0087\u038f\n\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\5\u0088\u03a2\n\u0088\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\7\u008a\u03c8\n\u008a\f\u008a"+
		"\16\u008a\u03cb\13\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008b"+
		"\3\u008b\7\u008b\u03d4\n\u008b\f\u008b\16\u008b\u03d7\13\u008b\3\u008b"+
		"\3\u008b\3\u008c\6\u008c\u03dc\n\u008c\r\u008c\16\u008c\u03dd\3\u008c"+
		"\3\u008c\6\u008c\u03e2\n\u008c\r\u008c\16\u008c\u03e3\5\u008c\u03e6\n"+
		"\u008c\3\u008d\6\u008d\u03e9\n\u008d\r\u008d\16\u008d\u03ea\3\u008d\3"+
		"\u008d\4\u0381\u03c9\2\u008e\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087"+
		"E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009b"+
		"O\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00af"+
		"Y\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3"+
		"c\u00c5d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7"+
		"m\u00d9n\u00dbo\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9v\u00eb"+
		"w\u00edx\u00efy\u00f1z\u00f3{\u00f5|\u00f7\2\u00f9\2\u00fb}\u00fd\2\u00ff"+
		"\2\u0101\2\u0103~\u0105\177\u0107\u0080\u0109\2\u010b\u0081\u010d\u0082"+
		"\u010f\u0083\u0111\u0084\u0113\u0085\u0115\u0086\u0117\2\u0119\u0087\3"+
		"\2\16\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\4\2GGgg\4\2--//\3\2\629\4\2SSss"+
		"\5\2\62;CHch\4\2ZZzz\6\2\f\f\17\17))^^\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\2\u0405\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2"+
		"\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2"+
		"\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9"+
		"\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2"+
		"\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb"+
		"\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2"+
		"\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd"+
		"\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2"+
		"\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef"+
		"\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2\2\2\u00fb\3\2\2"+
		"\2\2\u0103\3\2\2\2\2\u0105\3\2\2\2\2\u0107\3\2\2\2\2\u010b\3\2\2\2\2\u010d"+
		"\3\2\2\2\2\u010f\3\2\2\2\2\u0111\3\2\2\2\2\u0113\3\2\2\2\2\u0115\3\2\2"+
		"\2\2\u0119\3\2\2\2\3\u011b\3\2\2\2\5\u011d\3\2\2\2\7\u011f\3\2\2\2\t\u0126"+
		"\3\2\2\2\13\u0128\3\2\2\2\r\u012c\3\2\2\2\17\u0132\3\2\2\2\21\u0137\3"+
		"\2\2\2\23\u013c\3\2\2\2\25\u013f\3\2\2\2\27\u0144\3\2\2\2\31\u0148\3\2"+
		"\2\2\33\u014d\3\2\2\2\35\u0150\3\2\2\2\37\u0156\3\2\2\2!\u015d\3\2\2\2"+
		"#\u0165\3\2\2\2%\u0168\3\2\2\2\'\u016f\3\2\2\2)\u0174\3\2\2\2+\u0178\3"+
		"\2\2\2-\u017d\3\2\2\2/\u0182\3\2\2\2\61\u0189\3\2\2\2\63\u0192\3\2\2\2"+
		"\65\u0195\3\2\2\2\67\u0198\3\2\2\29\u019d\3\2\2\2;\u01a3\3\2\2\2=\u01ab"+
		"\3\2\2\2?\u01b2\3\2\2\2A\u01b7\3\2\2\2C\u01ba\3\2\2\2E\u01c1\3\2\2\2G"+
		"\u01c4\3\2\2\2I\u01cc\3\2\2\2K\u01d0\3\2\2\2M\u01d4\3\2\2\2O\u01d8\3\2"+
		"\2\2Q\u01dc\3\2\2\2S\u01e1\3\2\2\2U\u01e8\3\2\2\2W\u01ea\3\2\2\2Y\u01ed"+
		"\3\2\2\2[\u01f0\3\2\2\2]\u01f3\3\2\2\2_\u01f6\3\2\2\2a\u0200\3\2\2\2c"+
		"\u0202\3\2\2\2e\u0207\3\2\2\2g\u0211\3\2\2\2i\u0219\3\2\2\2k\u021d\3\2"+
		"\2\2m\u0222\3\2\2\2o\u0226\3\2\2\2q\u022e\3\2\2\2s\u0232\3\2\2\2u\u0238"+
		"\3\2\2\2w\u023c\3\2\2\2y\u0245\3\2\2\2{\u024c\3\2\2\2}\u0254\3\2\2\2\177"+
		"\u0258\3\2\2\2\u0081\u025d\3\2\2\2\u0083\u0266\3\2\2\2\u0085\u026b\3\2"+
		"\2\2\u0087\u026e\3\2\2\2\u0089\u0273\3\2\2\2\u008b\u027a\3\2\2\2\u008d"+
		"\u027d\3\2\2\2\u008f\u0282\3\2\2\2\u0091\u0288\3\2\2\2\u0093\u028c\3\2"+
		"\2\2\u0095\u0290\3\2\2\2\u0097\u0293\3\2\2\2\u0099\u0297\3\2\2\2\u009b"+
		"\u0299\3\2\2\2\u009d\u029b\3\2\2\2\u009f\u029d\3\2\2\2\u00a1\u02a0\3\2"+
		"\2\2\u00a3\u02a2\3\2\2\2\u00a5\u02a5\3\2\2\2\u00a7\u02a7\3\2\2\2\u00a9"+
		"\u02a9\3\2\2\2\u00ab\u02ac\3\2\2\2\u00ad\u02ae\3\2\2\2\u00af\u02b0\3\2"+
		"\2\2\u00b1\u02b2\3\2\2\2\u00b3\u02b4\3\2\2\2\u00b5\u02b7\3\2\2\2\u00b7"+
		"\u02ba\3\2\2\2\u00b9\u02bd\3\2\2\2\u00bb\u02c1\3\2\2\2\u00bd\u02c3\3\2"+
		"\2\2\u00bf\u02c5\3\2\2\2\u00c1\u02c8\3\2\2\2\u00c3\u02cb\3\2\2\2\u00c5"+
		"\u02cd\3\2\2\2\u00c7\u02d3\3\2\2\2\u00c9\u02d5\3\2\2\2\u00cb\u02d7\3\2"+
		"\2\2\u00cd\u02d9\3\2\2\2\u00cf\u02db\3\2\2\2\u00d1\u02de\3\2\2\2\u00d3"+
		"\u02e0\3\2\2\2\u00d5\u02e2\3\2\2\2\u00d7\u02e4\3\2\2\2\u00d9\u02e7\3\2"+
		"\2\2\u00db\u02ea\3\2\2\2\u00dd\u02ed\3\2\2\2\u00df\u02f1\3\2\2\2\u00e1"+
		"\u02f5\3\2\2\2\u00e3\u02f9\3\2\2\2\u00e5\u02fe\3\2\2\2\u00e7\u0302\3\2"+
		"\2\2\u00e9\u0306\3\2\2\2\u00eb\u030a\3\2\2\2\u00ed\u030e\3\2\2\2\u00ef"+
		"\u0313\3\2\2\2\u00f1\u0318\3\2\2\2\u00f3\u031d\3\2\2\2\u00f5\u031f\3\2"+
		"\2\2\u00f7\u0326\3\2\2\2\u00f9\u0328\3\2\2\2\u00fb\u0334\3\2\2\2\u00fd"+
		"\u0337\3\2\2\2\u00ff\u033e\3\2\2\2\u0101\u0342\3\2\2\2\u0103\u036a\3\2"+
		"\2\2\u0105\u0375\3\2\2\2\u0107\u0377\3\2\2\2\u0109\u037b\3\2\2\2\u010b"+
		"\u037d\3\2\2\2\u010d\u038e\3\2\2\2\u010f\u03a1\3\2\2\2\u0111\u03a3\3\2"+
		"\2\2\u0113\u03c3\3\2\2\2\u0115\u03d1\3\2\2\2\u0117\u03e5\3\2\2\2\u0119"+
		"\u03e8\3\2\2\2\u011b\u011c\7R\2\2\u011c\4\3\2\2\2\u011d\u011e\7X\2\2\u011e"+
		"\6\3\2\2\2\u011f\u0120\7c\2\2\u0120\u0121\7h\2\2\u0121\b\3\2\2\2\u0122"+
		"\u0123\7c\2\2\u0123\u0124\7p\2\2\u0124\u0127\7f\2\2\u0125\u0127\7(\2\2"+
		"\u0126\u0122\3\2\2\2\u0126\u0125\3\2\2\2\u0127\n\3\2\2\2\u0128\u0129\7"+
		"c\2\2\u0129\u012a\7p\2\2\u012a\u012b\7{\2\2\u012b\f\3\2\2\2\u012c\u012d"+
		"\7d\2\2\u012d\u012e\7g\2\2\u012e\u012f\7i\2\2\u012f\u0130\7k\2\2\u0130"+
		"\u0131\7p\2\2\u0131\16\3\2\2\2\u0132\u0133\7d\2\2\u0133\u0134\7q\2\2\u0134"+
		"\u0135\7f\2\2\u0135\u0136\7{\2\2\u0136\20\3\2\2\2\u0137\u0138\7d\2\2\u0138"+
		"\u0139\7q\2\2\u0139\u013a\7q\2\2\u013a\u013b\7n\2\2\u013b\22\3\2\2\2\u013c"+
		"\u013d\7d\2\2\u013d\u013e\7{\2\2\u013e\24\3\2\2\2\u013f\u0140\7e\2\2\u0140"+
		"\u0141\7c\2\2\u0141\u0142\7n\2\2\u0142\u0143\7n\2\2\u0143\26\3\2\2\2\u0144"+
		"\u0145\7e\2\2\u0145\u0146\7c\2\2\u0146\u0147\7r\2\2\u0147\30\3\2\2\2\u0148"+
		"\u0149\7e\2\2\u0149\u014a\7j\2\2\u014a\u014b\7c\2\2\u014b\u014c\7t\2\2"+
		"\u014c\32\3\2\2\2\u014d\u014e\7e\2\2\u014e\u014f\7q\2\2\u014f\34\3\2\2"+
		"\2\u0150\u0151\7e\2\2\u0151\u0152\7q\2\2\u0152\u0153\7p\2\2\u0153\u0154"+
		"\7u\2\2\u0154\u0155\7v\2\2\u0155\36\3\2\2\2\u0156\u0157\7e\2\2\u0157\u0158"+
		"\7t\2\2\u0158\u0159\7g\2\2\u0159\u015a\7c\2\2\u015a\u015b\7v\2\2\u015b"+
		"\u015c\7g\2\2\u015c \3\2\2\2\u015d\u015e\7f\2\2\u015e\u015f\7g\2\2\u015f"+
		"\u0160\7u\2\2\u0160\u0161\7v\2\2\u0161\u0162\7t\2\2\u0162\u0163\7q\2\2"+
		"\u0163\u0164\7{\2\2\u0164\"\3\2\2\2\u0165\u0166\7f\2\2\u0166\u0167\7q"+
		"\2\2\u0167$\3\2\2\2\u0168\u0169\7f\2\2\u0169\u016a\7q\2\2\u016a\u016b"+
		"\7y\2\2\u016b\u016c\7p\2\2\u016c\u016d\7v\2\2\u016d\u016e\7q\2\2\u016e"+
		"&\3\2\2\2\u016f\u0170\7g\2\2\u0170\u0171\7n\2\2\u0171\u0172\7u\2\2\u0172"+
		"\u0173\7g\2\2\u0173(\3\2\2\2\u0174\u0175\7g\2\2\u0175\u0176\7p\2\2\u0176"+
		"\u0177\7f\2\2\u0177*\3\2\2\2\u0178\u0179\7g\2\2\u0179\u017a\7p\2\2\u017a"+
		"\u017b\7w\2\2\u017b\u017c\7o\2\2\u017c,\3\2\2\2\u017d\u017e\7g\2\2\u017e"+
		"\u017f\7z\2\2\u017f\u0180\7k\2\2\u0180\u0181\7v\2\2\u0181.\3\2\2\2\u0182"+
		"\u0183\7g\2\2\u0183\u0184\7z\2\2\u0184\u0185\7v\2\2\u0185\u0186\7g\2\2"+
		"\u0186\u0187\7p\2\2\u0187\u0188\7f\2\2\u0188\60\3\2\2\2\u0189\u018a\7"+
		"g\2\2\u018a\u018b\7z\2\2\u018b\u018c\7v\2\2\u018c\u018d\7g\2\2\u018d\u018e"+
		"\7t\2\2\u018e\u018f\7p\2\2\u018f\u0190\7c\2\2\u0190\u0191\7n\2\2\u0191"+
		"\62\3\2\2\2\u0192\u0193\7h\2\2\u0193\u0194\7c\2\2\u0194\64\3\2\2\2\u0195"+
		"\u0196\7h\2\2\u0196\u0197\7k\2\2\u0197\66\3\2\2\2\u0198\u0199\7h\2\2\u0199"+
		"\u019a\7k\2\2\u019a\u019b\7n\2\2\u019b\u019c\7g\2\2\u019c8\3\2\2\2\u019d"+
		"\u019e\7h\2\2\u019e\u019f\7k\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7c\2\2"+
		"\u01a1\u01a2\7n\2\2\u01a2:\3\2\2\2\u01a3\u01a4\7h\2\2\u01a4\u01a5\7q\2"+
		"\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7y\2\2\u01a7\u01a8\7c\2\2\u01a8\u01a9"+
		"\7t\2\2\u01a9\u01aa\7f\2\2\u01aa<\3\2\2\2\u01ab\u01ac\7i\2\2\u01ac\u01ad"+
		"\7n\2\2\u01ad\u01ae\7q\2\2\u01ae\u01af\7d\2\2\u01af\u01b0\7c\2\2\u01b0"+
		"\u01b1\7n\2\2\u01b1>\3\2\2\2\u01b2\u01b3\7j\2\2\u01b3\u01b4\7k\2\2\u01b4"+
		"\u01b5\7i\2\2\u01b5\u01b6\7j\2\2\u01b6@\3\2\2\2\u01b7\u01b8\7k\2\2\u01b8"+
		"\u01b9\7h\2\2\u01b9B\3\2\2\2\u01ba\u01bb\7k\2\2\u01bb\u01bc\7o\2\2\u01bc"+
		"\u01bd\7r\2\2\u01bd\u01be\7q\2\2\u01be\u01bf\7t\2\2\u01bf\u01c0\7v\2\2"+
		"\u01c0D\3\2\2\2\u01c1\u01c2\7k\2\2\u01c2\u01c3\7p\2\2\u01c3F\3\2\2\2\u01c4"+
		"\u01c5\7k\2\2\u01c5\u01c6\7p\2\2\u01c6\u01c7\7k\2\2\u01c7\u01c8\7v\2\2"+
		"\u01c8\u01c9\7k\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb\7n\2\2\u01cbH\3\2\2"+
		"\2\u01cc\u01cd\7k\2\2\u01cd\u01ce\7p\2\2\u01ce\u01cf\7v\2\2\u01cfJ\3\2"+
		"\2\2\u01d0\u01d1\7n\2\2\u01d1\u01d2\7q\2\2\u01d2\u01d3\7y\2\2\u01d3L\3"+
		"\2\2\2\u01d4\u01d5\7o\2\2\u01d5\u01d6\7q\2\2\u01d6\u01d7\7f\2\2\u01d7"+
		"N\3\2\2\2\u01d8\u01d9\7p\2\2\u01d9\u01da\7g\2\2\u01da\u01db\7y\2\2\u01db"+
		"P\3\2\2\2\u01dc\u01dd\7p\2\2\u01dd\u01de\7g\2\2\u01de\u01df\7z\2\2\u01df"+
		"\u01e0\7v\2\2\u01e0R\3\2\2\2\u01e1\u01e2\7p\2\2\u01e2\u01e3\7k\2\2\u01e3"+
		"T\3\2\2\2\u01e4\u01e5\7p\2\2\u01e5\u01e6\7q\2\2\u01e6\u01e9\7v\2\2\u01e7"+
		"\u01e9\7\u0080\2\2\u01e8\u01e4\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9V\3\2"+
		"\2\2\u01ea\u01eb\7q\2\2\u01eb\u01ec\7e\2\2\u01ecX\3\2\2\2\u01ed\u01ee"+
		"\7q\2\2\u01ee\u01ef\7f\2\2\u01efZ\3\2\2\2\u01f0\u01f1\7q\2\2\u01f1\u01f2"+
		"\7p\2\2\u01f2\\\3\2\2\2\u01f3\u01f4\7q\2\2\u01f4\u01f5\7r\2\2\u01f5^\3"+
		"\2\2\2\u01f6\u01f7\7q\2\2\u01f7\u01f8\7r\2\2\u01f8\u01f9\7v\2\2\u01f9"+
		"\u01fa\7{\2\2\u01fa\u01fb\7r\2\2\u01fb\u01fc\7g\2\2\u01fc`\3\2\2\2\u01fd"+
		"\u01fe\7q\2\2\u01fe\u0201\7t\2\2\u01ff\u0201\7~\2\2\u0200\u01fd\3\2\2"+
		"\2\u0200\u01ff\3\2\2\2\u0201b\3\2\2\2\u0202\u0203\7r\2\2\u0203\u0204\7"+
		"t\2\2\u0204\u0205\7q\2\2\u0205\u0206\7e\2\2\u0206d\3\2\2\2\u0207\u0208"+
		"\7r\2\2\u0208\u0209\7t\2\2\u0209\u020a\7q\2\2\u020a\u020b\7e\2\2\u020b"+
		"\u020c\7g\2\2\u020c\u020d\7f\2\2\u020d\u020e\7w\2\2\u020e\u020f\7t\2\2"+
		"\u020f\u0210\7g\2\2\u0210f\3\2\2\2\u0211\u0212\7r\2\2\u0212\u0213\7t\2"+
		"\2\u0213\u0214\7q\2\2\u0214\u0215\7e\2\2\u0215\u0216\7g\2\2\u0216\u0217"+
		"\7u\2\2\u0217\u0218\7u\2\2\u0218h\3\2\2\2\u0219\u021a\7r\2\2\u021a\u021b"+
		"\7v\2\2\u021b\u021c\7t\2\2\u021cj\3\2\2\2\u021d\u021e\7t\2\2\u021e\u021f"+
		"\7g\2\2\u021f\u0220\7c\2\2\u0220\u0221\7n\2\2\u0221l\3\2\2\2\u0222\u0223"+
		"\7t\2\2\u0223\u0224\7g\2\2\u0224\u0225\7e\2\2\u0225n\3\2\2\2\u0226\u0227"+
		"\7t\2\2\u0227\u0228\7g\2\2\u0228\u0229\7e\2\2\u0229\u022a\7g\2\2\u022a"+
		"\u022b\7k\2\2\u022b\u022c\7x\2\2\u022c\u022d\7g\2\2\u022dp\3\2\2\2\u022e"+
		"\u022f\7t\2\2\u022f\u0230\7g\2\2\u0230\u0231\7h\2\2\u0231r\3\2\2\2\u0232"+
		"\u0233\7t\2\2\u0233\u0234\7g\2\2\u0234\u0235\7r\2\2\u0235\u0236\7n\2\2"+
		"\u0236\u0237\7{\2\2\u0237t\3\2\2\2\u0238\u0239\7t\2\2\u0239\u023a\7g\2"+
		"\2\u023a\u023b\7u\2\2\u023bv\3\2\2\2\u023c\u023d\7t\2\2\u023d\u023e\7"+
		"g\2\2\u023e\u023f\7u\2\2\u023f\u0240\7q\2\2\u0240\u0241\7w\2\2\u0241\u0242"+
		"\7t\2\2\u0242\u0243\7e\2\2\u0243\u0244\7g\2\2\u0244x\3\2\2\2\u0245\u0246"+
		"\7t\2\2\u0246\u0247\7g\2\2\u0247\u0248\7v\2\2\u0248\u0249\7w\2\2\u0249"+
		"\u024a\7t\2\2\u024a\u024b\7p\2\2\u024bz\3\2\2\2\u024c\u024d\7t\2\2\u024d"+
		"\u024e\7g\2\2\u024e\u024f\7v\2\2\u024f\u0250\7w\2\2\u0250\u0251\7t\2\2"+
		"\u0251\u0252\7p\2\2\u0252\u0253\7u\2\2\u0253|\3\2\2\2\u0254\u0255\7u\2"+
		"\2\u0255\u0256\7g\2\2\u0256\u0257\7o\2\2\u0257~\3\2\2\2\u0258\u0259\7"+
		"u\2\2\u0259\u025a\7g\2\2\u025a\u025b\7p\2\2\u025b\u025c\7f\2\2\u025c\u0080"+
		"\3\2\2\2\u025d\u025e\7u\2\2\u025e\u025f\7g\2\2\u025f\u0260\7r\2\2\u0260"+
		"\u0261\7c\2\2\u0261\u0262\7t\2\2\u0262\u0263\7c\2\2\u0263\u0264\7v\2\2"+
		"\u0264\u0265\7g\2\2\u0265\u0082\3\2\2\2\u0266\u0267\7u\2\2\u0267\u0268"+
		"\7m\2\2\u0268\u0269\7k\2\2\u0269\u026a\7r\2\2\u026a\u0084\3\2\2\2\u026b"+
		"\u026c\7u\2\2\u026c\u026d\7v\2\2\u026d\u0086\3\2\2\2\u026e\u026f\7u\2"+
		"\2\u026f\u0270\7v\2\2\u0270\u0271\7q\2\2\u0271\u0272\7r\2\2\u0272\u0088"+
		"\3\2\2\2\u0273\u0274\7u\2\2\u0274\u0275\7v\2\2\u0275\u0276\7t\2\2\u0276"+
		"\u0277\7k\2\2\u0277\u0278\7p\2\2\u0278\u0279\7i\2\2\u0279\u008a\3\2\2"+
		"\2\u027a\u027b\7v\2\2\u027b\u027c\7q\2\2\u027c\u008c\3\2\2\2\u027d\u027e"+
		"\7v\2\2\u027e\u027f\7{\2\2\u027f\u0280\7r\2\2\u0280\u0281\7g\2\2\u0281"+
		"\u008e\3\2\2\2\u0282\u0283\7w\2\2\u0283\u0284\7p\2\2\u0284\u0285\7k\2"+
		"\2\u0285\u0286\7q\2\2\u0286\u0287\7p\2\2\u0287\u0090\3\2\2\2\u0288\u0289"+
		"\7x\2\2\u0289\u028a\7c\2\2\u028a\u028b\7n\2\2\u028b\u0092\3\2\2\2\u028c"+
		"\u028d\7x\2\2\u028d\u028e\7c\2\2\u028e\u028f\7t\2\2\u028f\u0094\3\2\2"+
		"\2\u0290\u0291\7x\2\2\u0291\u0292\7o\2\2\u0292\u0096\3\2\2\2\u0293\u0294"+
		"\7z\2\2\u0294\u0295\7q\2\2\u0295\u0296\7t\2\2\u0296\u0098\3\2\2\2\u0297"+
		"\u0298\7.\2\2\u0298\u009a\3\2\2\2\u0299\u029a\7<\2\2\u029a\u009c\3\2\2"+
		"\2\u029b\u029c\7?\2\2\u029c\u009e\3\2\2\2\u029d\u029e\7-\2\2\u029e\u029f"+
		"\7-\2\2\u029f\u00a0\3\2\2\2\u02a0\u02a1\7-\2\2\u02a1\u00a2\3\2\2\2\u02a2"+
		"\u02a3\7/\2\2\u02a3\u02a4\7/\2\2\u02a4\u00a4\3\2\2\2\u02a5\u02a6\7/\2"+
		"\2\u02a6\u00a6\3\2\2\2\u02a7\u02a8\7,\2\2\u02a8\u00a8\3\2\2\2\u02a9\u02aa"+
		"\7,\2\2\u02aa\u02ab\7,\2\2\u02ab\u00aa\3\2\2\2\u02ac\u02ad\7\61\2\2\u02ad"+
		"\u00ac\3\2\2\2\u02ae\u02af\7\'\2\2\u02af\u00ae\3\2\2\2\u02b0\u02b1\7*"+
		"\2\2\u02b1\u00b0\3\2\2\2\u02b2\u02b3\7+\2\2\u02b3\u00b2\3\2\2\2\u02b4"+
		"\u02b5\7/\2\2\u02b5\u02b6\7@\2\2\u02b6\u00b4\3\2\2\2\u02b7\u02b8\7]\2"+
		"\2\u02b8\u02b9\7_\2\2\u02b9\u00b6\3\2\2\2\u02ba\u02bb\7<\2\2\u02bb\u02bc"+
		"\7?\2\2\u02bc\u00b8\3\2\2\2\u02bd\u02be\7<\2\2\u02be\u02bf\7?\2\2\u02bf"+
		"\u02c0\7<\2\2\u02c0\u00ba\3\2\2\2\u02c1\u02c2\7]\2\2\u02c2\u00bc\3\2\2"+
		"\2\u02c3\u02c4\7_\2\2\u02c4\u00be\3\2\2\2\u02c5\u02c6\7@\2\2\u02c6\u02c7"+
		"\7?\2\2\u02c7\u00c0\3\2\2\2\u02c8\u02c9\7>\2\2\u02c9\u02ca\7?\2\2\u02ca"+
		"\u00c2\3\2\2\2\u02cb\u02cc\7@\2\2\u02cc\u00c4\3\2\2\2\u02cd\u02ce\7>\2"+
		"\2\u02ce\u00c6\3\2\2\2\u02cf\u02d0\7#\2\2\u02d0\u02d4\7?\2\2\u02d1\u02d2"+
		"\7\u0080\2\2\u02d2\u02d4\7?\2\2\u02d3\u02cf\3\2\2\2\u02d3\u02d1\3\2\2"+
		"\2\u02d4\u00c8\3\2\2\2\u02d5\u02d6\7\60\2\2\u02d6\u00ca\3\2\2\2\u02d7"+
		"\u02d8\7B\2\2\u02d8\u00cc\3\2\2\2\u02d9\u02da\7`\2\2\u02da\u00ce\3\2\2"+
		"\2\u02db\u02dc\7~\2\2\u02dc\u02dd\7~\2\2\u02dd\u00d0\3\2\2\2\u02de\u02df"+
		"\7}\2\2\u02df\u00d2\3\2\2\2\u02e0\u02e1\7\177\2\2\u02e1\u00d4\3\2\2\2"+
		"\u02e2\u02e3\7A\2\2\u02e3\u00d6\3\2\2\2\u02e4\u02e5\7\61\2\2\u02e5\u02e6"+
		"\7\61\2\2\u02e6\u00d8\3\2\2\2\u02e7\u02e8\7@\2\2\u02e8\u02e9\7@\2\2\u02e9"+
		"\u00da\3\2\2\2\u02ea\u02eb\7>\2\2\u02eb\u02ec\7>\2\2\u02ec\u00dc\3\2\2"+
		"\2\u02ed\u02ee\7-\2\2\u02ee\u02ef\7<\2\2\u02ef\u02f0\7?\2\2\u02f0\u00de"+
		"\3\2\2\2\u02f1\u02f2\7/\2\2\u02f2\u02f3\7<\2\2\u02f3\u02f4\7?\2\2\u02f4"+
		"\u00e0\3\2\2\2\u02f5\u02f6\7,\2\2\u02f6\u02f7\7<\2\2\u02f7\u02f8\7?\2"+
		"\2\u02f8\u00e2\3\2\2\2\u02f9\u02fa\7,\2\2\u02fa\u02fb\7,\2\2\u02fb\u02fc"+
		"\7<\2\2\u02fc\u02fd\7?\2\2\u02fd\u00e4\3\2\2\2\u02fe\u02ff\7\61\2\2\u02ff"+
		"\u0300\7<\2\2\u0300\u0301\7?\2\2\u0301\u00e6\3\2\2\2\u0302\u0303\7\'\2"+
		"\2\u0303\u0304\7<\2\2\u0304\u0305\7?\2\2\u0305\u00e8\3\2\2\2\u0306\u0307"+
		"\7~\2\2\u0307\u0308\7<\2\2\u0308\u0309\7?\2\2\u0309\u00ea\3\2\2\2\u030a"+
		"\u030b\7(\2\2\u030b\u030c\7<\2\2\u030c\u030d\7?\2\2\u030d\u00ec\3\2\2"+
		"\2\u030e\u030f\7~\2\2\u030f\u0310\7~\2\2\u0310\u0311\7<\2\2\u0311\u0312"+
		"\7?\2\2\u0312\u00ee\3\2\2\2\u0313\u0314\7@\2\2\u0314\u0315\7@\2\2\u0315"+
		"\u0316\7<\2\2\u0316\u0317\7?\2\2\u0317\u00f0\3\2\2\2\u0318\u0319\7>\2"+
		"\2\u0319\u031a\7>\2\2\u031a\u031b\7<\2\2\u031b\u031c\7?\2\2\u031c\u00f2"+
		"\3\2\2\2\u031d\u031e\7=\2\2\u031e\u00f4\3\2\2\2\u031f\u0323\t\2\2\2\u0320"+
		"\u0322\t\3\2\2\u0321\u0320\3\2\2\2\u0322\u0325\3\2\2\2\u0323\u0321\3\2"+
		"\2\2\u0323\u0324\3\2\2\2\u0324\u00f6\3\2\2\2\u0325\u0323\3\2\2\2\u0326"+
		"\u0327\t\4\2\2\u0327\u00f8\3\2\2\2\u0328\u032a\t\5\2\2\u0329\u032b\t\6"+
		"\2\2\u032a\u0329\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032d\3\2\2\2\u032c"+
		"\u032e\5\u00f7|\2\u032d\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u032d"+
		"\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u00fa\3\2\2\2\u0331\u0335\5\u00ff\u0080"+
		"\2\u0332\u0335\5\u00fd\177\2\u0333\u0335\5\u0101\u0081\2\u0334\u0331\3"+
		"\2\2\2\u0334\u0332\3\2\2\2\u0334\u0333\3\2\2\2\u0335\u00fc\3\2\2\2\u0336"+
		"\u0338\t\7\2\2\u0337\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u0337\3\2"+
		"\2\2\u0339\u033a\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\t\b\2\2\u033c"+
		"\u00fe\3\2\2\2\u033d\u033f\t\4\2\2\u033e\u033d\3\2\2\2\u033f\u0340\3\2"+
		"\2\2\u0340\u033e\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0100\3\2\2\2\u0342"+
		"\u0346\t\4\2\2\u0343\u0345\t\t\2\2\u0344\u0343\3\2\2\2\u0345\u0348\3\2"+
		"\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0349\u034a\t\n\2\2\u034a\u0102\3\2\2\2\u034b\u034d\5\u00f7"+
		"|\2\u034c\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034c\3\2\2\2\u034e"+
		"\u034f\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0354\7\60\2\2\u0351\u0353\5"+
		"\u00f7|\2\u0352\u0351\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0352\3\2\2\2"+
		"\u0354\u0355\3\2\2\2\u0355\u0358\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u0359"+
		"\5\u00f9}\2\u0358\u0357\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u036b\3\2\2"+
		"\2\u035a\u035c\7\60\2\2\u035b\u035d\5\u00f7|\2\u035c\u035b\3\2\2\2\u035d"+
		"\u035e\3\2\2\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0361\3\2"+
		"\2\2\u0360\u0362\5\u00f9}\2\u0361\u0360\3\2\2\2\u0361\u0362\3\2\2\2\u0362"+
		"\u036b\3\2\2\2\u0363\u0365\5\u00f7|\2\u0364\u0363\3\2\2\2\u0365\u0366"+
		"\3\2\2\2\u0366\u0364\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u0368\3\2\2\2\u0368"+
		"\u0369\5\u00f9}\2\u0369\u036b\3\2\2\2\u036a\u034c\3\2\2\2\u036a\u035a"+
		"\3\2\2\2\u036a\u0364\3\2\2\2\u036b\u0104\3\2\2\2\u036c\u036d\7h\2\2\u036d"+
		"\u036e\7c\2\2\u036e\u036f\7n\2\2\u036f\u0370\7u\2\2\u0370\u0376\7g\2\2"+
		"\u0371\u0372\7v\2\2\u0372\u0373\7t\2\2\u0373\u0374\7w\2\2\u0374\u0376"+
		"\7g\2\2\u0375\u036c\3\2\2\2\u0375\u0371\3\2\2\2\u0376\u0106\3\2\2\2\u0377"+
		"\u0378\7)\2\2\u0378\u0379\5\u0109\u0085\2\u0379\u037a\7)\2\2\u037a\u0108"+
		"\3\2\2\2\u037b\u037c\n\13\2\2\u037c\u010a\3\2\2\2\u037d\u0381\7$\2\2\u037e"+
		"\u0380\5\u0109\u0085\2\u037f\u037e\3\2\2\2\u0380\u0383\3\2\2\2\u0381\u0382"+
		"\3\2\2\2\u0381\u037f\3\2\2\2\u0382\u0384\3\2\2\2\u0383\u0381\3\2\2\2\u0384"+
		"\u0385\7$\2\2\u0385\u010c\3\2\2\2\u0386\u0387\7p\2\2\u0387\u0388\7q\2"+
		"\2\u0388\u0389\7q\2\2\u0389\u038f\7r\2\2\u038a\u038b\7p\2\2\u038b\u038c"+
		"\7w\2\2\u038c\u038d\7n\2\2\u038d\u038f\7n\2\2\u038e\u0386\3\2\2\2\u038e"+
		"\u038a\3\2\2\2\u038f\u010e\3\2\2\2\u0390\u0391\7u\2\2\u0391\u0392\7v\2"+
		"\2\u0392\u0393\7f\2\2\u0393\u0394\7g\2\2\u0394\u0395\7t\2\2\u0395\u03a2"+
		"\7t\2\2\u0396\u0397\7u\2\2\u0397\u0398\7v\2\2\u0398\u0399\7f\2\2\u0399"+
		"\u039a\7k\2\2\u039a\u03a2\7p\2\2\u039b\u039c\7u\2\2\u039c\u039d\7v\2\2"+
		"\u039d\u039e\7f\2\2\u039e\u039f\7q\2\2\u039f\u03a0\7w\2\2\u03a0\u03a2"+
		"\7v\2\2\u03a1\u0390\3\2\2\2\u03a1\u0396\3\2\2\2\u03a1\u039b\3\2\2\2\u03a2"+
		"\u0110\3\2\2\2\u03a3\u03a4\7>\2\2\u03a4\u03a5\7G\2\2\u03a5\u03a6\7T\2"+
		"\2\u03a6\u03a7\7T\2\2\u03a7\u03a8\7Q\2\2\u03a8\u03a9\7T\2\2\u03a9\u03aa"+
		"\7.\2\2\u03aa\u03ab\7\"\2\2\u03ab\u03ac\7V\2\2\u03ac\u03ad\7J\2\2\u03ad"+
		"\u03ae\7K\2\2\u03ae\u03af\7U\2\2\u03af\u03b0\7\"\2\2\u03b0\u03b1\7U\2"+
		"\2\u03b1\u03b2\7J\2\2\u03b2\u03b3\7Q\2\2\u03b3\u03b4\7W\2\2\u03b4\u03b5"+
		"\7N\2\2\u03b5\u03b6\7F\2\2\u03b6\u03b7\7\"\2\2\u03b7\u03b8\7P\2\2\u03b8"+
		"\u03b9\7Q\2\2\u03b9\u03ba\7V\2\2\u03ba\u03bb\7\"\2\2\u03bb\u03bc\7J\2"+
		"\2\u03bc\u03bd\7C\2\2\u03bd\u03be\7R\2\2\u03be\u03bf\7R\2\2\u03bf\u03c0"+
		"\7G\2\2\u03c0\u03c1\7P\2\2\u03c1\u03c2\7@\2\2\u03c2\u0112\3\2\2\2\u03c3"+
		"\u03c4\7\61\2\2\u03c4\u03c5\7,\2\2\u03c5\u03c9\3\2\2\2\u03c6\u03c8\13"+
		"\2\2\2\u03c7\u03c6\3\2\2\2\u03c8\u03cb\3\2\2\2\u03c9\u03ca\3\2\2\2\u03c9"+
		"\u03c7\3\2\2\2\u03ca\u03cc\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cc\u03cd\7,"+
		"\2\2\u03cd\u03ce\7\61\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d0\b\u008a\2\2"+
		"\u03d0\u0114\3\2\2\2\u03d1\u03d5\5\u0117\u008c\2\u03d2\u03d4\n\f\2\2\u03d3"+
		"\u03d2\3\2\2\2\u03d4\u03d7\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d5\u03d6\3\2"+
		"\2\2\u03d6\u03d8\3\2\2\2\u03d7\u03d5\3\2\2\2\u03d8\u03d9\b\u008b\2\2\u03d9"+
		"\u0116\3\2\2\2\u03da\u03dc\7%\2\2\u03db\u03da\3\2\2\2\u03dc\u03dd\3\2"+
		"\2\2\u03dd\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e6\3\2\2\2\u03df"+
		"\u03e1\7\61\2\2\u03e0\u03e2\7\61\2\2\u03e1\u03e0\3\2\2\2\u03e2\u03e3\3"+
		"\2\2\2\u03e3\u03e1\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e6\3\2\2\2\u03e5"+
		"\u03db\3\2\2\2\u03e5\u03df\3\2\2\2\u03e6\u0118\3\2\2\2\u03e7\u03e9\t\r"+
		"\2\2\u03e8\u03e7\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea"+
		"\u03eb\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ed\b\u008d\2\2\u03ed\u011a"+
		"\3\2\2\2\37\2\u0126\u01e8\u0200\u02d3\u0323\u032a\u032f\u0334\u0339\u0340"+
		"\u0346\u034e\u0354\u0358\u035e\u0361\u0366\u036a\u0375\u0381\u038e\u03a1"+
		"\u03c9\u03d5\u03dd\u03e3\u03e5\u03ea\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}