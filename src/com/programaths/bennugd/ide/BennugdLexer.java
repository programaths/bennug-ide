package com.programaths.bennugd.ide;

import com.intellij.lexer.FlexAdapter;

/**
 * Created by Christian on 3/08/2014.
 */
public class BennugdLexer extends FlexAdapter {
    public BennugdLexer() {
        super(new _BennugdLexer());
    }
}
