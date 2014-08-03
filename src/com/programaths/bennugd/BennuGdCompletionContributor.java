package com.programaths.bennugd;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.Condition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.patterns.TreeElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.programaths.bennugd.psi.BgdImportStatement;
import com.programaths.bennugd.psi.BgdProcessDec;
import com.programaths.bennugd.psi.BgdTypes;
import com.programaths.bennugd.psi.BgdVarDec;
import org.jetbrains.annotations.NotNull;

import java.io.Console;
import java.util.Collection;

public class BennuGdCompletionContributor extends CompletionContributor {
    public BennuGdCompletionContributor() {

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().inside(PlatformPatterns.psiElement(BgdTypes.PROCESS_DEC)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement pel;
                        pel=parameters.getPosition();
                        System.out.println("Autocomplete?");
                        System.out.println(pel);
                        pel=PsiTreeUtil.getParentOfType(pel, BgdProcessDec.class);

                        if(pel!=null){
                            Collection<BgdVarDec> childrenOfType = PsiTreeUtil.findChildrenOfType(pel, BgdVarDec.class);
                            if(!childrenOfType.isEmpty()) {
                                for (BgdVarDec child : childrenOfType) {
                                    resultSet.addElement(LookupElementBuilder.create(child.getVarRef().getId().getText()));
                                }
                                String[] localeVars={
                                        "angle",
                                        "bigbro",
                                        "c_number",
                                        "ctype",
                                        "father",
                                        "file",
                                        "flags",
                                        "graph",
                                        "height",
                                        "id",
                                        "priority",
                                        "region",
                                        "reserved",
                                        "resolution",
                                        "size",
                                        "size_x",
                                        "size_y",
                                        "smallbro",
                                        "son",
                                        "x",
                                        "xgraph",
                                        "y",
                                        "z"
                                };
                                for (String localeVar : localeVars) {
                                    resultSet.addElement(LookupElementBuilder.create(localeVar));
                                }

                            }else{
                                System.out.println("No children!!");
                            }
                        }else{

                        }
                    }
                });

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(BgdTypes.ID).withLanguage(BennuGdLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement pel;
                        pel=parameters.getPosition();
                        System.out.println("Autocomplete?");
                        System.out.println(pel);
                        pel=PsiTreeUtil.getParentOfType(pel, BgdProcessDec.class);
                        if(pel!=null){
                            Collection<BgdVarDec> childrenOfType = PsiTreeUtil.findChildrenOfType(pel, BgdVarDec.class);
                            if(!childrenOfType.isEmpty()) {
                                for (BgdVarDec child : childrenOfType) {
                                    resultSet.addElement(LookupElementBuilder.create(child.getName()));
                                }
                                String[] localeVars={
                                        "angle",
                                        "bigbro",
                                        "c_number",
                                        "ctype",
                                        "father",
                                        "file",
                                        "flags",
                                        "graph",
                                        "height",
                                        "id",
                                        "priority",
                                        "region",
                                        "reserved",
                                        "resolution",
                                        "size",
                                        "size_x",
                                        "size_y",
                                        "smallbro",
                                        "son",
                                        "x",
                                        "xgraph",
                                        "y",
                                        "z"
                                };
                                for (String localeVar : localeVars) {
                                    resultSet.addElement(LookupElementBuilder.create(localeVar));
                                }

                            }else{
                                System.out.println("No children!!");
                            }
                        }else{
                            System.out.println("Nothing to autocomplete");
                        }
                    }
                }
        );
*/
        extend(CompletionType.BASIC,PlatformPatterns.psiElement(BgdTypes.STRING).withLanguage(BennuGdLanguage.INSTANCE).withParent(BgdImportStatement.class),new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                completionResultSet.addElement(LookupElementBuilder.create("mod_blendop"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_cd"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_crypt"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_debug"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_dir"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_draw"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_effects"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_ffi"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_file"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_flic"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_grproc"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_joy"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_key"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_m7"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_map"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_math"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_mem"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_mouse"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_path"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_proc"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_rand"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_regex"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_say"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_screen"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_scroll"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_sort"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_sound"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_string"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_sys"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_text"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_time"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_timers"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_video"));
                completionResultSet.addElement(LookupElementBuilder.create("mod_wm"));

            }
        });

    }
}