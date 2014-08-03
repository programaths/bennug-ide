package com.programaths.bennugd;

import com.intellij.lang.Language;

/**
 * Created by Christian on 3/08/2014.
 */
public class BennuGdLanguage extends Language {
    public static final BennuGdLanguage INSTANCE = new BennuGdLanguage();

    private BennuGdLanguage() {
        super("BennuGd");
    }
}
