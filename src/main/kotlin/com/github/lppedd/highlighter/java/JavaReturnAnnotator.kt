package com.github.lppedd.highlighter.java

import com.intellij.psi.PsiKeyword
import com.github.lppedd.highlighter.AbstractReturnAnnotator as ARA

/**
 * @author Edoardo Luppi
 */
class JavaReturnAnnotator : ARA<PsiKeyword>(PsiKeyword::class.java) {
  private val config = JavaReturnHighlighterConfig.INSTANCE

  override fun isValidContext(psiElement: PsiKeyword) =
      config.getHighlightStrategy().isValidContext(psiElement)
}
