package com.programaths.bennugd.psi;

import com.intellij.psi.tree.IElementType;
import com.programaths.bennugd.BennuGdLanguage;

/**
 * Created by Christian on 3/08/2014.
 */
public class BgdElementType extends IElementType {
    public BgdElementType(String import_statement) {
        super(import_statement, BennuGdLanguage.INSTANCE);
    }
}
