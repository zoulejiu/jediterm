package com.ssh.jediterm.terminal.ui.settings;

import com.ssh.jediterm.core.Platform;
import com.ssh.jediterm.terminal.HyperlinkStyle;
import com.ssh.jediterm.terminal.TerminalColor;
import com.ssh.jediterm.terminal.TextStyle;
import com.ssh.jediterm.terminal.emulator.ColorPalette;
import com.ssh.jediterm.terminal.emulator.ColorPaletteImpl;
import com.ssh.jediterm.terminal.model.LinesBuffer;
import com.ssh.jediterm.terminal.model.TerminalTypeAheadSettings;
import com.ssh.jediterm.terminal.ui.TerminalActionPresentation;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collections;

import static com.ssh.jediterm.terminal.ui.AwtTransformers.fromAwtToTerminalColor;

public class DefaultSettingsProvider implements SettingsProvider {
  @Override
  public @NotNull TerminalActionPresentation getOpenUrlActionPresentation() {
    return new TerminalActionPresentation("Open as URL", Collections.emptyList());
  }

  @Override
  public @NotNull TerminalActionPresentation getCopyActionPresentation() {
    KeyStroke keyStroke = Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_DOWN_MASK)
      // CTRL + C is used for signal; use CTRL + SHIFT + C instead
      : KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
    return new TerminalActionPresentation("Copy", keyStroke);
  }

  @Override
  public @NotNull TerminalActionPresentation getPasteActionPresentation() {
    KeyStroke keyStroke = Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_DOWN_MASK)
      // CTRL + V is used for signal; use CTRL + SHIFT + V instead
      : KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
    return new TerminalActionPresentation("Paste", keyStroke);
  }

  @Override
  public @NotNull TerminalActionPresentation getClearBufferActionPresentation() {
    return new TerminalActionPresentation("Clear Buffer", Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.META_DOWN_MASK)
      : KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getPageUpActionPresentation() {
    return new TerminalActionPresentation("Page Up",
      KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, InputEvent.SHIFT_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getPageDownActionPresentation() {
    return new TerminalActionPresentation("Page Down",
      KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, InputEvent.SHIFT_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getLineUpActionPresentation() {
    return new TerminalActionPresentation("Line Up", Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.META_DOWN_MASK)
      : KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getLineDownActionPresentation() {
    return new TerminalActionPresentation("Line Down", Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.META_DOWN_MASK)
      : KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getFindActionPresentation() {
    return new TerminalActionPresentation("Find", Platform.isMacOS()
      ? KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.META_DOWN_MASK)
      : KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
  }

  @Override
  public @NotNull TerminalActionPresentation getSelectAllActionPresentation() {
    return new TerminalActionPresentation("Select All", Collections.emptyList());
  }

  @Override
  public ColorPalette getTerminalColorPalette() {
    return Platform.isWindows() ? ColorPaletteImpl.WINDOWS_PALETTE : ColorPaletteImpl.XTERM_PALETTE;
  }

  @Override
  public Font getTerminalFont() {
    String fontName;
    if (Platform.isWindows()) {
      fontName = "Consolas";
    } else if (Platform.isMacOS()) {
      fontName = "Menlo";
    } else {
      fontName = "Monospaced";
    }
    return new Font(fontName, Font.PLAIN, (int)getTerminalFontSize());
  }

  @Override
  public float getTerminalFontSize() {
    return 14;
  }

  @Override
  public TextStyle getDefaultStyle() {
    return new TextStyle(TerminalColor.BLACK, TerminalColor.WHITE);
    // return new TextStyle(TerminalColor.WHITE, TerminalColor.rgb(24, 24, 24));
  }

  @Override
  public @NotNull TextStyle getSelectionColor() {
    return new TextStyle(TerminalColor.WHITE, TerminalColor.rgb(82, 109, 165));
  }

  @Override
  public @NotNull TextStyle getFoundPatternColor() {
    return new TextStyle(TerminalColor.BLACK, TerminalColor.rgb(255, 255, 0));
  }

  @Override
  public TextStyle getHyperlinkColor() {
    return new TextStyle(fromAwtToTerminalColor(java.awt.Color.BLUE), TerminalColor.WHITE);
  }

  @Override
  public HyperlinkStyle.HighlightMode getHyperlinkHighlightingMode() {
    return HyperlinkStyle.HighlightMode.HOVER;
  }

  @Override
  public boolean useInverseSelectionColor() {
    return true;
  }

  @Override
  public boolean copyOnSelect() {
    return emulateX11CopyPaste();
  }

  @Override
  public boolean pasteOnMiddleMouseClick() {
    return emulateX11CopyPaste();
  }

  @Override
  public boolean emulateX11CopyPaste() {
    return false;
  }

  @Override
  public boolean useAntialiasing() {
    return true;
  }

  @Override
  public int maxRefreshRate() {
    return 50;
  }

  @Override
  public boolean audibleBell() {
    return true;
  }

  @Override
  public boolean enableMouseReporting() {
    return true;
  }

  @Override
  public int caretBlinkingMs() {
    return 505;
  }

  @Override
  public boolean scrollToBottomOnTyping() {
    return true;
  }

  @Override
  public boolean DECCompatibilityMode() {
    return true;
  }

  @Override
  public boolean forceActionOnMouseReporting() {
    return false;
  }

  @Override
  public int getBufferMaxLinesCount() {
    return LinesBuffer.DEFAULT_MAX_LINES_COUNT;
  }

  @Override
  public boolean altSendsEscape() {
    return true;
  }

  @Override
  public boolean ambiguousCharsAreDoubleWidth() {
    return false;
  }

  @Override
  public @NotNull TerminalTypeAheadSettings getTypeAheadSettings() {
    return TerminalTypeAheadSettings.DEFAULT;
  }

  @Override
  public boolean sendArrowKeysInAlternativeMode() {
    return true;
  }
}