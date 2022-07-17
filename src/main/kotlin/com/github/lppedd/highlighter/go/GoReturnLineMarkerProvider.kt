package com.github.lppedd.highlighter.go

import com.github.lppedd.highlighter.ReturnHighlighterBundle
import com.goide.psi.GoReturnStatement
import com.github.lppedd.highlighter.AbstractReturnLineMarkerProvider as ARLMP

/**
 * @author Edoardo Luppi
 */
internal class GoReturnLineMarkerProvider : ARLMP<GoReturnStatement>(GoReturnStatement::class.java) {
  private val config = GoReturnHighlighterConfig.getInstance()

  override fun getName() = ReturnHighlighterBundle["rh.settings.go"]
  override fun isValidContext(psiElement: GoReturnStatement) =
    config.getHighlightStrategy().isValidContext(psiElement)
}
