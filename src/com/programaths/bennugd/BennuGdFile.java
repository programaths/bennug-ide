package com.programaths.bennugd;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Christian on 3/08/2014.
 */
public class BennuGdFile extends PsiFileBase {
    protected BennuGdFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, BennuGdLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return BennuGdFileType.INSTANCE;
    }

}
