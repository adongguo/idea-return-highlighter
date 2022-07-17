package com.github.lppedd.highlighter.go

import com.github.lppedd.highlighter.ReturnHighlightStrategy.PsiResult
import com.github.lppedd.highlighter.ReturnHighlightStrategy.PsiResult.*
import com.github.lppedd.highlighter.TopLevelReturnHighlightStrategy
import com.goide.psi.GoReturnStatement
import com.intellij.psi.PsiElement

/**
 * @author Edoardo Luppi
 */
internal object GoTopLevelHighlightStrategy : TopLevelReturnHighlightStrategy<GoReturnStatement>() {
  override fun check(psiElement: PsiElement): PsiResult =
    when (psiElement) {
      is GoReturnStatement -> VALID
      else -> CONTINUE
    }
}
