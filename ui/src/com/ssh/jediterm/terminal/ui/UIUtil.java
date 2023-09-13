package com.ssh.jediterm.terminal.ui;

import com.ssh.jediterm.core.Platform;

/**
 * @deprecated use {@link Platform} instead
 */
@Deprecated
public class UIUtil {
  public static final String OS_NAME = System.getProperty("os.name");

  protected static final String _OS_NAME = OS_NAME.toLowerCase();
  public static final boolean isWindows = _OS_NAME.startsWith("windows");
  public static final boolean isMac = _OS_NAME.startsWith("mac");
}
