package com.ssh.jediterm.terminal;

import com.ssh.jediterm.core.Color;
import com.ssh.jediterm.core.util.TermSize;
import com.ssh.jediterm.terminal.emulator.mouse.MouseFormat;
import com.ssh.jediterm.terminal.emulator.mouse.MouseMode;
import com.ssh.jediterm.terminal.model.TerminalSelection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TerminalDisplay {
  void setCursor(int x, int y);

  void setCursorShape(@NotNull CursorShape cursorShape);

  void beep();

  default void onResize(@NotNull TermSize newTermSize, @NotNull RequestOrigin origin) {}

  void scrollArea(final int scrollRegionTop, final int scrollRegionSize, int dy);

  void setCursorVisible(boolean isCursorVisible);

  void useAlternateScreenBuffer(boolean useAlternateScreenBuffer);

  void setBlinkingCursor(boolean isCursorBlinking);

  String getWindowTitle();

  void setWindowTitle(@NotNull String windowTitle);

  @Nullable
  TerminalSelection getSelection();

  void terminalMouseModeSet(@NotNull MouseMode mouseMode);

  void setMouseFormat(@NotNull MouseFormat mouseFormat);

  boolean ambiguousCharsAreDoubleWidth();

  default void setBracketedPasteMode(boolean bracketedPasteModeEnabled) {}

  default @Nullable Color getWindowForeground() {
    return null;
  }

  default @Nullable Color getWindowBackground() {
    return null;
  }
}
