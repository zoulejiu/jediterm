package com.ssh.jediterm.terminal.ui.settings;

import com.ssh.jediterm.terminal.ui.settings.SettingsProvider;
import com.ssh.jediterm.terminal.TtyConnector;
import com.ssh.jediterm.terminal.ui.TerminalActionPresentation;
import org.jetbrains.annotations.NotNull;

/**
 * @author traff
 */
public interface TabbedSettingsProvider extends SettingsProvider {
  boolean shouldCloseTabOnLogout(TtyConnector ttyConnector);

  String tabName(TtyConnector ttyConnector, String sessionName);

  @NotNull TerminalActionPresentation getNewSessionActionPresentation();

  @NotNull TerminalActionPresentation getCloseSessionActionPresentation();

  @NotNull TerminalActionPresentation getPreviousTabActionPresentation();

  @NotNull TerminalActionPresentation getNextTabActionPresentation();
}
