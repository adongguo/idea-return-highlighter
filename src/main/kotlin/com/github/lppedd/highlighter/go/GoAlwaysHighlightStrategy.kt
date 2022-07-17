package com.github.lppedd.highlighter.go

import com.github.lppedd.highlighter.ReturnHighlightStrategy
import com.goide.psi.GoReturnStatement

internal object GoAlwaysHighlightStrategy : ReturnHighlightStrategy<GoReturnStatement> {
  override fun isValidContext(psiElement: GoReturnStatement) = true
}
