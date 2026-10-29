package com.ssh.jediterm.core.typeahead;

public interface Debouncer {
  void call();

  void terminateCall();
}