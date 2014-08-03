package com.programaths.bennugd;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BennuGdFileType extends LanguageFileType {
    public static final BennuGdFileType INSTANCE = new BennuGdFileType();

    private BennuGdFileType() {
        super(BennuGdLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "BennuGd";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "BennuGd prg";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "prg";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return BennuGdIcons.FILE;
    }
}