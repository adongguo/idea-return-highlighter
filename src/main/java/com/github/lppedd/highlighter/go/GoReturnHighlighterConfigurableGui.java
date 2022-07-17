package com.github.lppedd.highlighter.go;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;

import com.github.lppedd.highlighter.ReturnHighlighterBundle;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;

/**
 * @author Edoardo Luppi
 */
public class GoReturnHighlighterConfigurableGui {
  private JPanel rootPanel;
  private JBLabel info;
  private JBCheckBox isOnlyTopLevelReturns;

  public GoReturnHighlighterConfigurableGui(@NotNull final ReturnHighlighterBundle bundle) {
    this();
    finishUpComponents(bundle);
  }

  private GoReturnHighlighterConfigurableGui() {}

  @NotNull
  public JPanel getRootPanel() {
    return rootPanel;
  }

  @NotNull
  public Boolean isOnlyTopLevelReturns() {
    return isOnlyTopLevelReturns.isSelected();
  }

  public void setOnlyTopLevelReturns(@NotNull final Boolean value) {
    isOnlyTopLevelReturns.setSelected(value);
  }

  private void finishUpComponents(@NotNull final ReturnHighlighterBundle bundle) {
    info.setText(bundle.get("rh.settings.custom.go"));
    isOnlyTopLevelReturns.setText(bundle.get("rh.settings.custom.go.topLevel"));
  }
}
