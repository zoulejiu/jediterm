package com.ssh.jediterm.terminal.model

interface TerminalSelectionChangesListener {
  fun selectionChanged(selection: TerminalSelection?)
}
