package com.flamelab.gameserver.utiles.naming;

public enum DbCollectionNames {

    PLAYERS__DB_COLLECTION("players"),
    ARMIES__DB_COLLECTION("armies"),
    SCORES__DB_COLLECTION("scores");

    private String name;

    DbCollectionNames(String name) {
        this.name = name;
    }
}
