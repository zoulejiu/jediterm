package com.ssh.jediterm.terminal.ui;

import com.ssh.jediterm.terminal.TerminalDisplay;
import com.ssh.jediterm.terminal.TtyConnector;

import javax.swing.*;
import java.awt.*;

/**
 * @author traff
 */
public interface TerminalWidget {
  JediTermWidget createTerminalSession(TtyConnector ttyConnector);

  JComponent getComponent();

  default JComponent getPreferredFocusableComponent() {
    return getComponent();
  }

  boolean canOpenSession();

  Dimension getPreferredSize();

  TerminalDisplay getTerminalDisplay();

  void addListener(TerminalWidgetListener listener);
  void removeListener(TerminalWidgetListener listener);
}
