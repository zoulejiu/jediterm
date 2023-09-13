package com.ssh.jediterm.util;

import com.ssh.jediterm.core.Color;
import com.ssh.jediterm.core.util.TermSize;
import com.ssh.jediterm.terminal.CursorShape;
import com.ssh.jediterm.terminal.RequestOrigin;
import com.ssh.jediterm.terminal.TerminalDisplay;
import com.ssh.jediterm.terminal.emulator.mouse.MouseMode;
import com.ssh.jediterm.terminal.model.JediTerminal;
import com.ssh.jediterm.terminal.model.TerminalSelection;
import com.ssh.jediterm.terminal.model.TerminalTextBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author traff
 */
public class BackBufferDisplay implements TerminalDisplay {
  private final TerminalTextBuffer myTerminalTextBuffer;
  private TerminalSelection mySelection = null;
  private String myWindowTitle;
  private @Nullable Color myForegroundColor;
  private @Nullable Color myBackgroundColor;

  public BackBufferDisplay(TerminalTextBuffer terminalTextBuffer) {
    myTerminalTextBuffer = terminalTextBuffer;
  }

  @Override
  public int getRowCount() {
    return myTerminalTextBuffer.getHeight();
  }

  @Override
  public int getColumnCount() {
    return myTerminalTextBuffer.getWidth();
  }

  @Override
  public void setCursor(int x, int y) {
  }

  @Override
  public void setCursorShape(CursorShape shape) {
  }

  @Override
  public void beep() {
  }

  @Override
  public void requestResize(@NotNull TermSize newWinSize, RequestOrigin origin, int cursorX, int cursorY, JediTerminal.ResizeHandler resizeHandler) {
    myTerminalTextBuffer.resize(newWinSize, origin, cursorX, cursorY, resizeHandler, mySelection);
  }

  @Override
  public void scrollArea(int scrollRegionTop, int scrollRegionSize, int dy) {
  }

  @Override
  public void setCursorVisible(boolean shouldDrawCursor) {
  }

  @Override
  public void setScrollingEnabled(boolean enabled) {
  }

  @Override
  public void setBlinkingCursor(boolean enabled) {
  }

  @Override
  public void setWindowTitle(String title) {
    myWindowTitle = title;
  }

  public @Nullable String getWindowTitle() {
    return myWindowTitle;
  }

  public TerminalSelection getSelection() {
    return mySelection;
  }

  @Override
  public boolean ambiguousCharsAreDoubleWidth() {
    return false;
  }

  public void setSelection(TerminalSelection mySelection) {
    this.mySelection = mySelection;
  }

  @Override
  public void terminalMouseModeSet(MouseMode mode) {
  }

  @Override
  public @Nullable Color getWindowForeground() {
    return myForegroundColor;
  }

  public void setWindowForeground(@Nullable Color foregroundColor) {
    myForegroundColor = foregroundColor;
  }

  @Override
  public @Nullable Color getWindowBackground() {
    return myBackgroundColor;
  }

  public void setWindowBackground(@Nullable Color backgroundColor) {
    myBackgroundColor = backgroundColor;
  }
}
