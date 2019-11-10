package com.github.lppedd.highlighter.settings

import com.github.lppedd.highlighter.AbstractReturnAnnotator
import com.github.lppedd.highlighter.Constants
import com.github.lppedd.highlighter.Icons
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.psi.codeStyle.DisplayPriority
import com.intellij.psi.codeStyle.DisplayPrioritySortable

/**
 * @author Edoardo Luppi
 */
class ReturnHighlighterColorSettingsPage : ColorSettingsPage, DisplayPrioritySortable {
  override fun getDisplayName() = Constants.PRESENTABLE_APP_NAME
  override fun getIcon() = Icons.GUTTER_RETURN
  override fun getPriority() = DisplayPriority.COMMON_SETTINGS
  override fun getAttributeDescriptors() =
      arrayOf(AttributesDescriptor("Return keyword", AbstractReturnAnnotator.RETURN_KEYWORD))

  override fun getHighlighter() = PlainSyntaxHighlighter()
  override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
  override fun getDemoText() = """
      final String value = getValue();
      <return>return</return> value;
    """.trimIndent()

  override fun getAdditionalHighlightingTagToDescriptorMap() =
      mapOf(Pair("return", AbstractReturnAnnotator.RETURN_KEYWORD))
}
