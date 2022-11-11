package com.flamelab.gameserver.exceptions;

public class NoExistentEntityException extends RuntimeException {
    public NoExistentEntityException(String message) {
        super(message);
    }
}
