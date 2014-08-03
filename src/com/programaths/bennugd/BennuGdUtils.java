package com.programaths.bennugd;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.programaths.bennugd.psi.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian on 3/08/2014.
 */
public class BennuGdUtils {
    public static List<PsiElement> findAllDeclarations(Project project) {
        List<PsiElement> result = new ArrayList<PsiElement>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, BennuGdFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            BennuGdFile simpleFile = (BennuGdFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                Collection<BgdVarDec> varDecs = PsiTreeUtil.findChildrenOfType(simpleFile, BgdVarDec.class);
                result.addAll(varDecs);
                Collection<BgdFuncDec> funcDecs = PsiTreeUtil.findChildrenOfType(simpleFile, BgdFuncDec.class);
                result.addAll(funcDecs);
                Collection<BgdProcessDec> procDecs = PsiTreeUtil.findChildrenOfType(simpleFile, BgdProcessDec.class);
                result.addAll(procDecs);
                Collection<BgdStructStm> structDecs = PsiTreeUtil.findChildrenOfType(simpleFile, BgdStructStm.class);
                result.addAll(structDecs);
                Collection<BgdTypeStm> typeDecs = PsiTreeUtil.findChildrenOfType(simpleFile, BgdTypeStm.class);
                result.addAll(typeDecs);
            }
        }
        return result;
    }
}
