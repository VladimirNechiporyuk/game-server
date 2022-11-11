package com.flamelab.gameserver.utiles.naming;

public enum DbCollectionNames {

    PLAYERS__DB_COLLECTION("users");

    private String name;

    DbCollectionNames(String name) {
        this.name = name;
    }
}
