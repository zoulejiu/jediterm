package com.ssh.jediterm.terminal;

import com.ssh.jediterm.core.Color;
import com.ssh.jediterm.core.util.TermSize;
import com.ssh.jediterm.terminal.emulator.mouse.MouseMode;
import com.ssh.jediterm.terminal.model.JediTerminal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TerminalDisplay {
  // Size information
  int getRowCount();

  int getColumnCount();

  void setCursor(int x, int y);

  void setCursorShape(CursorShape shape);

  void beep();

  void requestResize(@NotNull TermSize newWinSize, RequestOrigin origin, int cursorX, int cursorY,
                     JediTerminal.ResizeHandler resizeHandler);

  void scrollArea(final int scrollRegionTop, final int scrollRegionSize, int dy);

  default void historyBufferLineCountChanged() {}

  void setCursorVisible(boolean shouldDrawCursor);

  void setScrollingEnabled(boolean enabled);

  void setBlinkingCursor(boolean enabled);

  String getWindowTitle();

  void setWindowTitle(String name);

  void terminalMouseModeSet(MouseMode mode);

  boolean ambiguousCharsAreDoubleWidth();

  default void setBracketedPasteMode(boolean enabled) {}

  default @Nullable Color getWindowForeground() {
    return null;
  }

  default @Nullable Color getWindowBackground() {
    return null;
  }
}
