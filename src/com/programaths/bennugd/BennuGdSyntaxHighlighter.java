package com.programaths.bennugd;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import com.programaths.bennugd.ide.BennugdLexer;
import com.programaths.bennugd.psi.BgdTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class BennuGdSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT = createTextAttributesKey("SIMPLE_COMMENT");
    public static final TextAttributesKey STRING = createTextAttributesKey("BGD_STRING");
    public static final TextAttributesKey PROCESS  = createTextAttributesKey("PROCESS");
    public static final TextAttributesKey FUNC  = createTextAttributesKey("FUNC");
    public static final TextAttributesKey ID  = createTextAttributesKey("ID");
    public static final TextAttributesKey STRUCT  = createTextAttributesKey("STRUCT");
    public static final TextAttributesKey TYPE  = createTextAttributesKey("TYPE");
 
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new BennugdLexer();
    }
 
    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(BgdTypes.STRING)){
            return STRING_KEYS;
        }else if(tokenType.equals(BgdTypes.COMMENT)){
            return COMMENT_KEYS;
        }
        return EMPTY_KEYS;
    }
}