package com.cipher.aimkingbackend.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
  private final String detailMessage;
  public ApplicationException(String message, String detailMessage) {
    super(message);
    this.detailMessage = detailMessage;
  }
}
