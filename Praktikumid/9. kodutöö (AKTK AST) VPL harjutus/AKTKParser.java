// Generated from AKTK.g4 by ANTLR 4.4
package antlrgen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AKTKParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, MuutujaNimi=24, 
		Arvuliteraal=25, Soneliteraal=26, Kommentaar=27, Whitespace=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'var'", "'!='", "'>='", "'while'", "'{'", "';'", 
		"'=='", "'<'", "'='", "'}'", "'>'", "'if'", "'<='", "'else'", "'('", "'do'", 
		"')'", "'*'", "'+'", "'then'", "','", "'-'", "MuutujaNimi", "Arvuliteraal", 
		"Soneliteraal", "Kommentaar", "Whitespace"
	};
	public static final int
		RULE_programm = 0, RULE_lauseteJada = 1, RULE_lause = 2, RULE_ifLause = 3, 
		RULE_whileLause = 4, RULE_omistamine = 5, RULE_muutujaDeklaratsioon = 6, 
		RULE_avaldis = 7, RULE_avaldis5 = 8, RULE_avaldis4 = 9, RULE_avaldis3 = 10, 
		RULE_avaldis2 = 11, RULE_avaldis1 = 12, RULE_avaldis0 = 13;
	public static final String[] ruleNames = {
		"programm", "lauseteJada", "lause", "ifLause", "whileLause", "omistamine", 
		"muutujaDeklaratsioon", "avaldis", "avaldis5", "avaldis4", "avaldis3", 
		"avaldis2", "avaldis1", "avaldis0"
	};

	@Override
	public String getGrammarFileName() { return "AKTK.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AKTKParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgrammContext extends ParserRuleContext {
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitProgramm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); lauseteJada();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LauseteJadaContext extends ParserRuleContext {
		public LauseContext lause(int i) {
			return getRuleContext(LauseContext.class,i);
		}
		public List<LauseContext> lause() {
			return getRuleContexts(LauseContext.class);
		}
		public LauseteJadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lauseteJada; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitLauseteJada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LauseteJadaContext lauseteJada() throws RecognitionException {
		LauseteJadaContext _localctx = new LauseteJadaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lauseteJada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); lause();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(31); match(T__16);
				setState(32); lause();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LauseContext extends ParserRuleContext {
		public WhileLauseContext whileLause() {
			return getRuleContext(WhileLauseContext.class,0);
		}
		public IfLauseContext ifLause() {
			return getRuleContext(IfLauseContext.class,0);
		}
		public MuutujaDeklaratsioonContext muutujaDeklaratsioon() {
			return getRuleContext(MuutujaDeklaratsioonContext.class,0);
		}
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public OmistamineContext omistamine() {
			return getRuleContext(OmistamineContext.class,0);
		}
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public LauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitLause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LauseContext lause() throws RecognitionException {
		LauseContext _localctx = new LauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lause);
		try {
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); ifLause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); whileLause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40); omistamine();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41); muutujaDeklaratsioon();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42); avaldis();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(43); match(T__17);
				setState(44); lauseteJada();
				setState(45); match(T__12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfLauseContext extends ParserRuleContext {
		public LauseContext lause(int i) {
			return getRuleContext(LauseContext.class,i);
		}
		public List<LauseContext> lause() {
			return getRuleContexts(LauseContext.class);
		}
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public IfLauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifLause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitIfLause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfLauseContext ifLause() throws RecognitionException {
		IfLauseContext _localctx = new IfLauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifLause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(T__10);
			setState(50); avaldis();
			setState(51); match(T__2);
			setState(52); lause();
			setState(53); match(T__8);
			setState(54); lause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLauseContext extends ParserRuleContext {
		public LauseContext lause() {
			return getRuleContext(LauseContext.class,0);
		}
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public WhileLauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitWhileLause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLauseContext whileLause() throws RecognitionException {
		WhileLauseContext _localctx = new WhileLauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileLause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(T__18);
			setState(57); avaldis();
			setState(58); match(T__6);
			setState(59); lause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OmistamineContext extends ParserRuleContext {
		public TerminalNode MuutujaNimi() { return getToken(AKTKParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public OmistamineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_omistamine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitOmistamine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OmistamineContext omistamine() throws RecognitionException {
		OmistamineContext _localctx = new OmistamineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_omistamine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(MuutujaNimi);
			setState(62); match(T__13);
			setState(63); avaldis();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MuutujaDeklaratsioonContext extends ParserRuleContext {
		public TerminalNode MuutujaNimi() { return getToken(AKTKParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public MuutujaDeklaratsioonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muutujaDeklaratsioon; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitMuutujaDeklaratsioon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MuutujaDeklaratsioonContext muutujaDeklaratsioon() throws RecognitionException {
		MuutujaDeklaratsioonContext _localctx = new MuutujaDeklaratsioonContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_muutujaDeklaratsioon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(T__21);
			setState(66); match(MuutujaNimi);
			setState(69);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(67); match(T__13);
				setState(68); avaldis();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AvaldisContext extends ParserRuleContext {
		public Avaldis5Context avaldis5() {
			return getRuleContext(Avaldis5Context.class,0);
		}
		public AvaldisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitAvaldis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AvaldisContext avaldis() throws RecognitionException {
		AvaldisContext _localctx = new AvaldisContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_avaldis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); avaldis5();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis5Context extends ParserRuleContext {
		public Avaldis5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis5; }
	 
		public Avaldis5Context() { }
		public void copyFrom(Avaldis5Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VordlemineContext extends Avaldis5Context {
		public Avaldis4Context avaldis4(int i) {
			return getRuleContext(Avaldis4Context.class,i);
		}
		public List<Avaldis4Context> avaldis4() {
			return getRuleContexts(Avaldis4Context.class);
		}
		public VordlemineContext(Avaldis5Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitVordlemine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TriviaalneAvaldis5Context extends Avaldis5Context {
		public Avaldis4Context avaldis4() {
			return getRuleContext(Avaldis4Context.class,0);
		}
		public TriviaalneAvaldis5Context(Avaldis5Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitTriviaalneAvaldis5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis5Context avaldis5() throws RecognitionException {
		Avaldis5Context _localctx = new Avaldis5Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_avaldis5);
		int _la;
		try {
			setState(78);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new VordlemineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73); avaldis4(0);
				setState(74);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__19) | (1L << T__15) | (1L << T__14) | (1L << T__11) | (1L << T__9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(75); avaldis4(0);
				}
				break;
			case 2:
				_localctx = new TriviaalneAvaldis5Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77); avaldis4(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis4Context extends ParserRuleContext {
		public Avaldis4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis4; }
	 
		public Avaldis4Context() { }
		public void copyFrom(Avaldis4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TriviaalneAvaldis4Context extends Avaldis4Context {
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public TriviaalneAvaldis4Context(Avaldis4Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitTriviaalneAvaldis4(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiitmineLahutamineContext extends Avaldis4Context {
		public Avaldis4Context avaldis4() {
			return getRuleContext(Avaldis4Context.class,0);
		}
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public LiitmineLahutamineContext(Avaldis4Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitLiitmineLahutamine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis4Context avaldis4() throws RecognitionException {
		return avaldis4(0);
	}

	private Avaldis4Context avaldis4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Avaldis4Context _localctx = new Avaldis4Context(_ctx, _parentState);
		Avaldis4Context _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_avaldis4, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TriviaalneAvaldis4Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(81); avaldis3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LiitmineLahutamineContext(new Avaldis4Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_avaldis4);
					setState(83);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(84);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==T__0) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(85); avaldis3(0);
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Avaldis3Context extends ParserRuleContext {
		public Avaldis3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis3; }
	 
		public Avaldis3Context() { }
		public void copyFrom(Avaldis3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class KorrutamineJagamineContext extends Avaldis3Context {
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public KorrutamineJagamineContext(Avaldis3Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitKorrutamineJagamine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TriviaalneAvaldis3Context extends Avaldis3Context {
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public TriviaalneAvaldis3Context(Avaldis3Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitTriviaalneAvaldis3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis3Context avaldis3() throws RecognitionException {
		return avaldis3(0);
	}

	private Avaldis3Context avaldis3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Avaldis3Context _localctx = new Avaldis3Context(_ctx, _parentState);
		Avaldis3Context _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_avaldis3, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TriviaalneAvaldis3Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(92); avaldis2();
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new KorrutamineJagamineContext(new Avaldis3Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_avaldis3);
					setState(94);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(95);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__4) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(96); avaldis2();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Avaldis2Context extends ParserRuleContext {
		public Avaldis2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis2; }
	 
		public Avaldis2Context() { }
		public void copyFrom(Avaldis2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TriviaalneAvaldis2Context extends Avaldis2Context {
		public Avaldis1Context avaldis1() {
			return getRuleContext(Avaldis1Context.class,0);
		}
		public TriviaalneAvaldis2Context(Avaldis2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitTriviaalneAvaldis2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaarneMiinusContext extends Avaldis2Context {
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public UnaarneMiinusContext(Avaldis2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitUnaarneMiinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis2Context avaldis2() throws RecognitionException {
		Avaldis2Context _localctx = new Avaldis2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_avaldis2);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new UnaarneMiinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102); match(T__0);
				setState(103); avaldis2();
				}
				break;
			case T__7:
			case MuutujaNimi:
			case Arvuliteraal:
			case Soneliteraal:
				_localctx = new TriviaalneAvaldis2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104); avaldis1();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis1Context extends ParserRuleContext {
		public Avaldis1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis1; }
	 
		public Avaldis1Context() { }
		public void copyFrom(Avaldis1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TriviaalneAvaldis1Context extends Avaldis1Context {
		public Avaldis0Context avaldis0() {
			return getRuleContext(Avaldis0Context.class,0);
		}
		public TriviaalneAvaldis1Context(Avaldis1Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitTriviaalneAvaldis1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunktsiooniValjakutseContext extends Avaldis1Context {
		public TerminalNode MuutujaNimi() { return getToken(AKTKParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis(int i) {
			return getRuleContext(AvaldisContext.class,i);
		}
		public List<AvaldisContext> avaldis() {
			return getRuleContexts(AvaldisContext.class);
		}
		public FunktsiooniValjakutseContext(Avaldis1Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitFunktsiooniValjakutse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis1Context avaldis1() throws RecognitionException {
		Avaldis1Context _localctx = new Avaldis1Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_avaldis1);
		int _la;
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new FunktsiooniValjakutseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107); match(MuutujaNimi);
				setState(108); match(T__7);
				setState(117);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__0) | (1L << MuutujaNimi) | (1L << Arvuliteraal) | (1L << Soneliteraal))) != 0)) {
					{
					setState(109); avaldis();
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(110); match(T__1);
						setState(111); avaldis();
						}
						}
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(119); match(T__5);
				}
				break;
			case 2:
				_localctx = new TriviaalneAvaldis1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120); avaldis0();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis0Context extends ParserRuleContext {
		public Avaldis0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis0; }
	 
		public Avaldis0Context() { }
		public void copyFrom(Avaldis0Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SuluavaldisContext extends Avaldis0Context {
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public SuluavaldisContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitSuluavaldis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SoneliteraalRContext extends Avaldis0Context {
		public TerminalNode Soneliteraal() { return getToken(AKTKParser.Soneliteraal, 0); }
		public SoneliteraalRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitSoneliteraalR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MuutujaNimiRContext extends Avaldis0Context {
		public TerminalNode MuutujaNimi() { return getToken(AKTKParser.MuutujaNimi, 0); }
		public MuutujaNimiRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitMuutujaNimiR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArvuliteraalRContext extends Avaldis0Context {
		public TerminalNode Arvuliteraal() { return getToken(AKTKParser.Arvuliteraal, 0); }
		public ArvuliteraalRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AKTKVisitor ) return ((AKTKVisitor<? extends T>)visitor).visitArvuliteraalR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Avaldis0Context avaldis0() throws RecognitionException {
		Avaldis0Context _localctx = new Avaldis0Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_avaldis0);
		try {
			setState(130);
			switch (_input.LA(1)) {
			case MuutujaNimi:
				_localctx = new MuutujaNimiRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(123); match(MuutujaNimi);
				}
				break;
			case Arvuliteraal:
				_localctx = new ArvuliteraalRContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124); match(Arvuliteraal);
				}
				break;
			case Soneliteraal:
				_localctx = new SoneliteraalRContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125); match(Soneliteraal);
				}
				break;
			case T__7:
				_localctx = new SuluavaldisContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126); match(T__7);
				setState(127); avaldis();
				setState(128); match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9: return avaldis4_sempred((Avaldis4Context)_localctx, predIndex);
		case 10: return avaldis3_sempred((Avaldis3Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean avaldis3_sempred(Avaldis3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean avaldis4_sempred(Avaldis4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u0087\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\7\3$\n\3"+
		"\f\3\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\5\bH\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nQ\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\fd"+
		"\n\f\f\f\16\fg\13\f\3\r\3\r\3\r\5\rl\n\r\3\16\3\16\3\16\3\16\3\16\7\16"+
		"s\n\16\f\16\16\16v\13\16\5\16x\n\16\3\16\3\16\5\16|\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0085\n\17\3\17\2\4\24\26\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\5\6\2\5\6\n\13\16\16\20\20\4\2\26\26\31\31\4\2"+
		"\3\3\25\25\u0089\2\36\3\2\2\2\4 \3\2\2\2\6\61\3\2\2\2\b\63\3\2\2\2\n:"+
		"\3\2\2\2\f?\3\2\2\2\16C\3\2\2\2\20I\3\2\2\2\22P\3\2\2\2\24R\3\2\2\2\26"+
		"]\3\2\2\2\30k\3\2\2\2\32{\3\2\2\2\34\u0084\3\2\2\2\36\37\5\4\3\2\37\3"+
		"\3\2\2\2 %\5\6\4\2!\"\7\t\2\2\"$\5\6\4\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2"+
		"\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2(\62\5\b\5\2)\62\5\n\6\2*\62\5\f\7\2"+
		"+\62\5\16\b\2,\62\5\20\t\2-.\7\b\2\2./\5\4\3\2/\60\7\r\2\2\60\62\3\2\2"+
		"\2\61(\3\2\2\2\61)\3\2\2\2\61*\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2"+
		"\2\2\62\7\3\2\2\2\63\64\7\17\2\2\64\65\5\20\t\2\65\66\7\27\2\2\66\67\5"+
		"\6\4\2\678\7\21\2\289\5\6\4\29\t\3\2\2\2:;\7\7\2\2;<\5\20\t\2<=\7\23\2"+
		"\2=>\5\6\4\2>\13\3\2\2\2?@\7\32\2\2@A\7\f\2\2AB\5\20\t\2B\r\3\2\2\2CD"+
		"\7\4\2\2DG\7\32\2\2EF\7\f\2\2FH\5\20\t\2GE\3\2\2\2GH\3\2\2\2H\17\3\2\2"+
		"\2IJ\5\22\n\2J\21\3\2\2\2KL\5\24\13\2LM\t\2\2\2MN\5\24\13\2NQ\3\2\2\2"+
		"OQ\5\24\13\2PK\3\2\2\2PO\3\2\2\2Q\23\3\2\2\2RS\b\13\1\2ST\5\26\f\2TZ\3"+
		"\2\2\2UV\f\4\2\2VW\t\3\2\2WY\5\26\f\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z"+
		"[\3\2\2\2[\25\3\2\2\2\\Z\3\2\2\2]^\b\f\1\2^_\5\30\r\2_e\3\2\2\2`a\f\4"+
		"\2\2ab\t\4\2\2bd\5\30\r\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\27"+
		"\3\2\2\2ge\3\2\2\2hi\7\31\2\2il\5\30\r\2jl\5\32\16\2kh\3\2\2\2kj\3\2\2"+
		"\2l\31\3\2\2\2mn\7\32\2\2nw\7\22\2\2ot\5\20\t\2pq\7\30\2\2qs\5\20\t\2"+
		"rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wo\3\2\2\2"+
		"wx\3\2\2\2xy\3\2\2\2y|\7\24\2\2z|\5\34\17\2{m\3\2\2\2{z\3\2\2\2|\33\3"+
		"\2\2\2}\u0085\7\32\2\2~\u0085\7\33\2\2\177\u0085\7\34\2\2\u0080\u0081"+
		"\7\22\2\2\u0081\u0082\5\20\t\2\u0082\u0083\7\24\2\2\u0083\u0085\3\2\2"+
		"\2\u0084}\3\2\2\2\u0084~\3\2\2\2\u0084\177\3\2\2\2\u0084\u0080\3\2\2\2"+
		"\u0085\35\3\2\2\2\r%\61GPZektw{\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}