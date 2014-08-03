package com.programaths.bennugd.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.programaths.bennugd.psi.BgdTypes;
import com.programaths.bennugd.psi.BgdVarDec;

public class BgdPsiImplUtil {
    public static String getName(BgdVarDec element) {
        ASTNode keyNode = element.getNode().findChildByType(BgdTypes.ID);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }
 
    public static String getType(BgdVarDec element) {
        ASTNode valueNode = element.getNode().findChildByType(BgdTypes.VAR_TYPE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }


    public static String getName(BgdVarRef element) {
        return element.getId().getText();
    }
    /*
    public static PsiElement setName(BgdVarRef element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(BgdTypes.ID);
        if (keyNode != null) {

            BgdVarRef property = BgdVarRef.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SimpleProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
    */
}