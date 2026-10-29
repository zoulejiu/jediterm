package com.ssh.jediterm.terminal.model

import com.ssh.jediterm.terminal.TextStyle
import com.ssh.jediterm.terminal.model.TerminalLine.TextEntry
import com.ssh.jediterm.terminal.util.CharUtils
import com.ssh.jediterm.util.CharBufferUtil

@JvmOverloads
fun terminalLine(text: String, style: TextStyle = TextStyle()): TerminalLine {
  return TerminalLine(TextEntry(style, CharBufferUtil.create(text)))
}

fun createFillerEntry(width: Int): TextEntry {
  return TextEntry(TextStyle(), CharBuffer(CharUtils.NUL_CHAR, width))
}

fun LinesStorage.getLineTexts(): List<String> {
  val lines = ArrayList<String>(size)
  for (line in this) {
    lines.add(line.text)
  }
  return lines
}
