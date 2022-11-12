package com.flamelab.gameserver.exceptions;

public class MoreThanOneEntityExistsByQueryException extends RuntimeException {

    public MoreThanOneEntityExistsByQueryException(String message) {
        super(message);
    }
}
