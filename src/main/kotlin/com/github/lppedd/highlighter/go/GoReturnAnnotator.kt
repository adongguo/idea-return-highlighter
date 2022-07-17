package com.github.lppedd.highlighter.go

import com.goide.psi.GoReturnStatement
import com.github.lppedd.highlighter.AbstractReturnAnnotator as ARA

internal class GoReturnAnnotator : ARA<GoReturnStatement>(GoReturnStatement::class.java) {
  private val config = GoReturnHighlighterConfig.getInstance()

  override fun isValidContext(psiElement: GoReturnStatement) =
    config.getHighlightStrategy().isValidContext(psiElement)
}
