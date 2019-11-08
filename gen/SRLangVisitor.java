// Generated from C:/Users/Nicolai Romero/Desktop/LP-3-Interprete/grammar\SRLang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SRLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SRLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SRLangParser#components}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponents(SRLangParser.ComponentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(SRLangParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#specificComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificComponent(SRLangParser.SpecificComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#combinedComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinedComponent(SRLangParser.CombinedComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#combinedspecificPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinedspecificPart(SRLangParser.CombinedspecificPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#componentLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentLabel(SRLangParser.ComponentLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#componentKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentKeyword(SRLangParser.ComponentKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#specificBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificBody(SRLangParser.SpecificBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#optionalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalParams(SRLangParser.OptionalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#componentParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentParams(SRLangParser.ComponentParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#separateBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparateBody(SRLangParser.SeparateBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#specificStatementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificStatementList(SRLangParser.SpecificStatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#specificStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificStatement(SRLangParser.SpecificStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bodyStatementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyStatementList(SRLangParser.BodyStatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyStatement(SRLangParser.BodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bodyOnly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyOnly(SRLangParser.BodyOnlyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#commonStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonStatement(SRLangParser.CommonStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#importClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportClause(SRLangParser.ImportClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#extendClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendClause(SRLangParser.ExtendClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(SRLangParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#importName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportName(SRLangParser.ImportNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#opDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpDeclaration(SRLangParser.OpDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#opOrExternal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpOrExternal(SRLangParser.OpOrExternalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#operDefLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperDefLP(SRLangParser.OperDefLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#operDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperDef(SRLangParser.OperDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#colonOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonOpt(SRLangParser.ColonOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#semDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemDeclaration(SRLangParser.SemDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#semDefLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemDefLP(SRLangParser.SemDefLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#semDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemDef(SRLangParser.SemDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#semPrototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemPrototype(SRLangParser.SemPrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#semInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemInit(SRLangParser.SemInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#proc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc(SRLangParser.ProcContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(SRLangParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#process}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcess(SRLangParser.ProcessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#initialBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialBlock(SRLangParser.InitialBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#initialOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialOptional(SRLangParser.InitialOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#finalBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalBlock(SRLangParser.FinalBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#finalOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalOptional(SRLangParser.FinalOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#prototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototype(SRLangParser.PrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(SRLangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#paramSpecificList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamSpecificList(SRLangParser.ParamSpecificListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#paramSpecificLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamSpecificLP(SRLangParser.ParamSpecificLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#paramSpecific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamSpecific(SRLangParser.ParamSpecificContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#paramKindOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamKindOptional(SRLangParser.ParamKindOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#returnSpecificOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSpecificOptional(SRLangParser.ReturnSpecificOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#returnSpecificNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSpecificNull(SRLangParser.ReturnSpecificNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#paramNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamNames(SRLangParser.ParamNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#returnNameOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnNameOptional(SRLangParser.ReturnNameOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SRLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(SRLangParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#typeRestriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRestriction(SRLangParser.TypeRestrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#objDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjDeclaration(SRLangParser.ObjDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#varOrConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOrConst(SRLangParser.VarOrConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#varDefLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefLP(SRLangParser.VarDefLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(SRLangParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#varAtt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAtt(SRLangParser.VarAttContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SRLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#unsubType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsubType(SRLangParser.UnsubTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(SRLangParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#stringDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDef(SRLangParser.StringDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#stringLim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLim(SRLangParser.StringLimContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#enumDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDef(SRLangParser.EnumDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#pointerDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerDef(SRLangParser.PointerDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#recordDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDef(SRLangParser.RecordDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#unionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionDef(SRLangParser.UnionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#fieldLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldLP(SRLangParser.FieldLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(SRLangParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#capabilityDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapabilityDef(SRLangParser.CapabilityDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#capFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapFor(SRLangParser.CapForContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#optypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptypeDeclaration(SRLangParser.OptypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#opPrototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpPrototype(SRLangParser.OpPrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#eqOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOpt(SRLangParser.EqOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#opRestrictionOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRestrictionOpt(SRLangParser.OpRestrictionOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#opRestriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRestriction(SRLangParser.OpRestrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SRLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#blockItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItems(SRLangParser.BlockItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(SRLangParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SRLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#skipStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStatement(SRLangParser.SkipStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#stopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopStatement(SRLangParser.StopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#exitCodeOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitCodeOptional(SRLangParser.ExitCodeOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#exitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStatement(SRLangParser.ExitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#nextStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextStatement(SRLangParser.NextStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SRLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#replyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplyStatement(SRLangParser.ReplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#forwardStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForwardStatement(SRLangParser.ForwardStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#sendStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendStatement(SRLangParser.SendStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#receiveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiveStatement(SRLangParser.ReceiveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#vStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVStatement(SRLangParser.VStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#pStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPStatement(SRLangParser.PStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#explicitCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitCall(SRLangParser.ExplicitCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#destroyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestroyStatement(SRLangParser.DestroyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#beginEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginEnd(SRLangParser.BeginEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SRLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(SRLangParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#guardedCommandLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedCommandLP(SRLangParser.GuardedCommandLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#guardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedCommand(SRLangParser.GuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#elseCommandOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseCommandOptional(SRLangParser.ElseCommandOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#forAllStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAllStatement(SRLangParser.ForAllStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(SRLangParser.InputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#inCommandLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCommandLP(SRLangParser.InCommandLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#inCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCommand(SRLangParser.InCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#inSpecific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInSpecific(SRLangParser.InSpecificContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#inOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOp(SRLangParser.InOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#syncExpressionOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncExpressionOptional(SRLangParser.SyncExpressionOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#scheduleExpressionOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScheduleExpressionOptional(SRLangParser.ScheduleExpressionOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#concurrentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentStatement(SRLangParser.ConcurrentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#concurrentCommandLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentCommandLP(SRLangParser.ConcurrentCommandLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#concurrentCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentCommand(SRLangParser.ConcurrentCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#separatorOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparatorOptional(SRLangParser.SeparatorOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#concurrentInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentInvocation(SRLangParser.ConcurrentInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#postProcessingOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostProcessingOptional(SRLangParser.PostProcessingOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#quantifiersOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiersOptional(SRLangParser.QuantifiersOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#quantifierLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierLP(SRLangParser.QuantifierLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(SRLangParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection(SRLangParser.DirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#stepOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepOptional(SRLangParser.StepOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#suchThatOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuchThatOptional(SRLangParser.SuchThatOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SRLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SRLangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#prefixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(SRLangParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#newItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewItem(SRLangParser.NewItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(SRLangParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocation(SRLangParser.InvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#parenList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenList(SRLangParser.ParenListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#parenItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenItemList(SRLangParser.ParenItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#expressionLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLP(SRLangParser.ExpressionLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(SRLangParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#constrItemLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrItemLP(SRLangParser.ConstrItemLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#constrItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrItem(SRLangParser.ConstrItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#createExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateExpression(SRLangParser.CreateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#createCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCall(SRLangParser.CreateCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#resourceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceName(SRLangParser.ResourceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#locationOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationOptional(SRLangParser.LocationOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#qualifiedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedID(SRLangParser.QualifiedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#endId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndId(SRLangParser.EndIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#idOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdOptional(SRLangParser.IdOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(SRLangParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#idLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdLP(SRLangParser.IdLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#idSubsLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSubsLP(SRLangParser.IdSubsLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#idSubs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSubs(SRLangParser.IdSubsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#subscripts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscripts(SRLangParser.SubscriptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#subscriptsOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptsOptional(SRLangParser.SubscriptsOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bracketedList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedList(SRLangParser.BracketedListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#boundLP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundLP(SRLangParser.BoundLPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBounds(SRLangParser.BoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SRLangParser#bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBound(SRLangParser.BoundContext ctx);
}