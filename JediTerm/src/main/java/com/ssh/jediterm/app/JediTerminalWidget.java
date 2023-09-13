package com.ssh.jediterm.app;

import com.ssh.jediterm.terminal.ui.JediTermWidget;
import com.ssh.jediterm.terminal.ui.settings.SettingsProvider;

public class JediTerminalWidget extends JediTermWidget {
  public JediTerminalWidget(SettingsProvider settingsProvider) {
    super(settingsProvider);
    setName("terminal");
  }
}
