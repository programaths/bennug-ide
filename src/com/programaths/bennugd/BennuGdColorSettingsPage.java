package com.programaths.bennugd;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class BennuGdColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", BennuGdSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("String", BennuGdSyntaxHighlighter.STRING),
            new AttributesDescriptor("Processes", BennuGdSyntaxHighlighter.PROCESS),
            new AttributesDescriptor("Functions", BennuGdSyntaxHighlighter.FUNC),
            new AttributesDescriptor("Identifiers", BennuGdSyntaxHighlighter.ID),
            new AttributesDescriptor("Structures", BennuGdSyntaxHighlighter.STRUCT),
            new AttributesDescriptor("Types", BennuGdSyntaxHighlighter.TYPE),
    };
 
    @Nullable
    @Override
    public Icon getIcon() {
        return BennuGdIcons.FILE;
    }
 
    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new BennuGdSyntaxHighlighter();
    }
 
    @NotNull
    @Override
    public String getDemoText() {
        return "program \"ok\"\n" +
                "import \"bar\"\n" +
                "process foo\n" +
                "public\n" +
                "begin\n" +
                "end";
    }
 
    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
 
    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }
 
    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }
 
    @NotNull
    @Override
    public String getDisplayName() {
        return "BennuGd";
    }
}