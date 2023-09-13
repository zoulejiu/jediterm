package com.ssh.jediterm.terminal.ui;

import com.ssh.jediterm.terminal.RequestOrigin;
import org.jetbrains.annotations.NotNull;


public interface TerminalPanelListener {
  void onPanelResize(@NotNull RequestOrigin origin);

  void onTitleChanged(String title);
}
