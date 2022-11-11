package com.flamelab.gameserver.utiles.naming;

import jdk.jfr.Description;

@Description("Fields naming is using for correct mapping from one object type to other during mapping and also for actions in data base" +
        "Fields related to classes in packages:" +
        "com.flamelab.gameserver.entities" +
        "com.flamelab.gameserver.dtos.create" +
        "com.flamelab.gameserver.dtos.transfer" +
        "com.flamelab.gameserver.dtos.update")
public enum FieldNames {

    ID__FIELD_APPELLATION("id"),
    CREATED_DATE__FIELD_APPELLATION("createdDate"),
    NAME__FIELD_APPELLATION("name"),
    PLAYER_ID__FIELD_APPELLATION("playerId"),
    UNIT_TYPE__FIELD_APPELLATION("unitType"),
    GENDER__FIELD_APPELLATION("gender"),
    ARMY_ID__FIELD_APPELLATION("armyId"),
    MAGES__FIELD_APPELLATION("mages"),
    SWORDSMAN_IN_HAVY_ARMOR__FIELD_APPELLATION("swordsmanInHavyArmors"),
    SWORDSMAN_IN_LIGHT_ARMOR__FIELD_APPELLATION("swordsmanInLightArmors"),
    SPEARMAN_IN_HAVY_ARMOR__FIELD_APPELLATION("spearmanInHavyArmors"),
    SPEARMAN_IN_LIGHT_ARMOR__FIELD_APPELLATION("spearmanInLightArmors"),
    CAVALRYMAN_IN_HAVY_ARMOR__FIELD_APPELLATION("cavalrymanInHavyArmors"),
    CAVALRYMAN_IN_LIGHT_ARMOR__FIELD_APPELLATION("cavalrymanInHavyArmors"),
    BOWMANS__FIELD_APPELLATION("bowmans"),
    SCORE__FIELD_APPELLATION("score");

    private String name;

    FieldNames(String name) {
        this.name = name;
    }
}
