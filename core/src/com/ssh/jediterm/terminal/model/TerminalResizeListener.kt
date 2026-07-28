package com.ssh.jediterm.terminal.model

import com.ssh.jediterm.core.util.TermSize

interface TerminalResizeListener {
  fun onResize(oldTermSize: TermSize, newTermSize: TermSize)
}
