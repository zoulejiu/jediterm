package com.ssh.jediterm.terminal.ui;

import com.ssh.jediterm.terminal.Terminal;
import com.ssh.jediterm.terminal.TtyConnector;
import com.ssh.jediterm.terminal.model.TerminalTextBuffer;

/**
 * @author traff
 */
public interface TerminalSession {
  void start();

  TerminalTextBuffer getTerminalTextBuffer();

  Terminal getTerminal();

  TtyConnector getTtyConnector();

  void close();
}
