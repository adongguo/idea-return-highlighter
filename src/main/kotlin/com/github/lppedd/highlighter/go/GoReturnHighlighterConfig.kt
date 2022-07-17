package com.github.lppedd.highlighter.go

import com.github.lppedd.highlighter.Application
import com.github.lppedd.highlighter.Constants
import com.github.lppedd.highlighter.ReturnHighlightStrategy
import com.github.lppedd.highlighter.go.GoReturnHighlighterConfig.GoConfig
import com.goide.psi.GoReturnStatement
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.PersistentStateComponent


@State(
  name = "Go",
  storages = [Storage(Constants.ISTORAGE_FILE)]
)
internal class GoReturnHighlighterConfig : PersistentStateComponent<GoConfig> {
  companion object {
    fun getInstance(): GoReturnHighlighterConfig =
      ServiceManager.getService(GoReturnHighlighterConfig::class.java)
  }

  private var state = GoConfig()
  private var highlightStrategy: ReturnHighlightStrategy<GoReturnStatement> = GoAlwaysHighlightStrategy

  override fun getState(): GoConfig = state.copy()
  override fun loadState(state: GoConfig) {
    this.state = state
    updateCurrentHighlightStrategy()
  }

  fun setState(state: GoConfig) {
    this.state = state
    updateCurrentHighlightStrategy()
    Application.refreshFiles()
  }

  fun getHighlightStrategy() = highlightStrategy

  private fun updateCurrentHighlightStrategy() {
    var highlightStrategy: ReturnHighlightStrategy<GoReturnStatement> =
      GoAlwaysHighlightStrategy

    if (state.isOnlyTopLevelReturns) {
      highlightStrategy = GoTopLevelHighlightStrategy
    }

    this.highlightStrategy = highlightStrategy
  }

  data class GoConfig(var isOnlyTopLevelReturns: Boolean = false)
}
