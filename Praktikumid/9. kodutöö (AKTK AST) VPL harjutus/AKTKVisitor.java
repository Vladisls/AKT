// Generated from AKTK.g4 by ANTLR 4.4
package antlrgen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AKTKParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AKTKVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AKTKParser#lauseteJada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLauseteJada(@NotNull AKTKParser.LauseteJadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#whileLause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLause(@NotNull AKTKParser.WhileLauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Suluavaldis}
	 * labeled alternative in {@link AKTKParser#avaldis0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuluavaldis(@NotNull AKTKParser.SuluavaldisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KorrutamineJagamine}
	 * labeled alternative in {@link AKTKParser#avaldis3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKorrutamineJagamine(@NotNull AKTKParser.KorrutamineJagamineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TriviaalneAvaldis4}
	 * labeled alternative in {@link AKTKParser#avaldis4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis4(@NotNull AKTKParser.TriviaalneAvaldis4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code TriviaalneAvaldis3}
	 * labeled alternative in {@link AKTKParser#avaldis3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis3(@NotNull AKTKParser.TriviaalneAvaldis3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code TriviaalneAvaldis2}
	 * labeled alternative in {@link AKTKParser#avaldis2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis2(@NotNull AKTKParser.TriviaalneAvaldis2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code TriviaalneAvaldis1}
	 * labeled alternative in {@link AKTKParser#avaldis1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis1(@NotNull AKTKParser.TriviaalneAvaldis1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#ifLause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLause(@NotNull AKTKParser.IfLauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Vordlemine}
	 * labeled alternative in {@link AKTKParser#avaldis5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVordlemine(@NotNull AKTKParser.VordlemineContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#lause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLause(@NotNull AKTKParser.LauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SoneliteraalR}
	 * labeled alternative in {@link AKTKParser#avaldis0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoneliteraalR(@NotNull AKTKParser.SoneliteraalRContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#avaldis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvaldis(@NotNull AKTKParser.AvaldisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TriviaalneAvaldis5}
	 * labeled alternative in {@link AKTKParser#avaldis5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis5(@NotNull AKTKParser.TriviaalneAvaldis5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaarneMiinus}
	 * labeled alternative in {@link AKTKParser#avaldis2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaarneMiinus(@NotNull AKTKParser.UnaarneMiinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArvuliteraalR}
	 * labeled alternative in {@link AKTKParser#avaldis0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArvuliteraalR(@NotNull AKTKParser.ArvuliteraalRContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#muutujaDeklaratsioon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuutujaDeklaratsioon(@NotNull AKTKParser.MuutujaDeklaratsioonContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#omistamine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOmistamine(@NotNull AKTKParser.OmistamineContext ctx);
	/**
	 * Visit a parse tree produced by {@link AKTKParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(@NotNull AKTKParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MuutujaNimiR}
	 * labeled alternative in {@link AKTKParser#avaldis0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuutujaNimiR(@NotNull AKTKParser.MuutujaNimiRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiitmineLahutamine}
	 * labeled alternative in {@link AKTKParser#avaldis4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiitmineLahutamine(@NotNull AKTKParser.LiitmineLahutamineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunktsiooniValjakutse}
	 * labeled alternative in {@link AKTKParser#avaldis1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunktsiooniValjakutse(@NotNull AKTKParser.FunktsiooniValjakutseContext ctx);
}