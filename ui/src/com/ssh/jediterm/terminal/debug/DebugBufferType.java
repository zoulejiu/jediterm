package com.ssh.jediterm.terminal.debug;

import com.ssh.jediterm.terminal.LoggingTtyConnector;
import com.ssh.jediterm.terminal.ui.TerminalSession;

import java.util.List;

/**
 * @author traff
 */
public enum DebugBufferType {
  Screen() {
    public String getValue(TerminalSession session, int stateIndex) {
      List<LoggingTtyConnector.TerminalState> states = ((LoggingTtyConnector) session.getTtyConnector()).getStates();
      if (stateIndex == states.size()) {
        return session.getTerminalTextBuffer().getScreenLines();
      } else {
        return states.get(stateIndex).myScreenLines;
      }
    }
  },
  BackStyle() {
    public String getValue(TerminalSession session, int stateIndex) {
      List<LoggingTtyConnector.TerminalState> states = ((LoggingTtyConnector) session.getTtyConnector()).getStates();
      if (stateIndex == states.size()) {
        return session.getTerminalTextBuffer().getStyleLines();
      } else {
        return states.get(stateIndex).myStyleLines;
      }
    }
  },
  History() {
    public String getValue(TerminalSession session, int stateIndex) {
      List<LoggingTtyConnector.TerminalState> states = ((LoggingTtyConnector) session.getTtyConnector()).getStates();
      if (stateIndex == states.size()) {
        return session.getTerminalTextBuffer().getHistoryBuffer().getLines();
      } else {
        return states.get(stateIndex).myHistoryLines;
      }
    }
  };

  public abstract String getValue(TerminalSession session, int stateIndex);
}
