package com.programaths.bennugd;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.programaths.bennugd.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Christian on 3/08/2014.
 */
public class ProcessAndFuncAnnotator implements Annotator{
    interface WithId{
        public String getId();
    }

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof BgdIdOrFuncLike || element instanceof BgdVarRef){
            String id;
                    if(element instanceof BgdIdOrFuncLike){
                        id= ((BgdIdOrFuncLike)element).getVarRef().getId().getText();
                    }else {
                        id= ((BgdVarRef) element).getId().getText();
                    }

            System.out.println("found text to mark "+element.getText());
            List<PsiElement> bgdIdOrFuncLike = BennuGdUtils.findAllDeclarations(element.getProject());
            if(bgdIdOrFuncLike.isEmpty()){
                System.out.println("Empty function or id");
            }
            for (PsiElement idOrFuncLike : bgdIdOrFuncLike) {
                if(idOrFuncLike instanceof BgdProcessDec && ((BgdProcessDec) idOrFuncLike).getId().getText().equals(id)){
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("PROCESS"));
                    System.out.println("marked text process");
                    return;
                }else if(idOrFuncLike instanceof BgdFuncDec && ((BgdFuncDec) idOrFuncLike).getId().getText().equals(id)){
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("FUNC"));
                    System.out.println("marked text func");
                    return;
                }else if(idOrFuncLike instanceof BgdVarDec && ((BgdVarDec) idOrFuncLike).getVarRef().getId().getText().equals(id)){
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("ID"));
                    System.out.println("marked text id");
                    return;
                }else if(idOrFuncLike instanceof BgdStructStm && ((BgdStructStm) idOrFuncLike).getId().getText().equals(id)){
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("STRUCT"));
                    System.out.println("marked text struct");
                    return;
                }else if(idOrFuncLike instanceof BgdTypeStm && ((BgdTypeStm) idOrFuncLike).getId().getText().equals(id)){
                    Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setTextAttributes(TextAttributesKey.createTextAttributesKey("TYPE"));
                    System.out.println("marked text type");
                    return;
                }
            }

        }
    }
}
