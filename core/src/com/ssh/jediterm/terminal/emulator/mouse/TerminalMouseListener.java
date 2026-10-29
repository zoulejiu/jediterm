package com.ssh.jediterm.terminal.emulator.mouse;

import com.ssh.jediterm.core.input.MouseEvent;
import com.ssh.jediterm.core.input.MouseWheelEvent;
import org.jetbrains.annotations.NotNull;

public interface TerminalMouseListener {
  boolean onMouseEvent(int x, int y, @NotNull MouseEvent event, MouseEventProcessingSettings settings);
}
