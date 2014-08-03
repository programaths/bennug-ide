package com.programaths.bennugd.psi;

import com.intellij.psi.tree.IElementType;
import com.programaths.bennugd.BennuGdLanguage;

/**
 * Created by Christian on 3/08/2014.
 */
public class BgdTokenType extends IElementType {
    public BgdTokenType(String id) {
        super(id, BennuGdLanguage.INSTANCE);
    }
}
