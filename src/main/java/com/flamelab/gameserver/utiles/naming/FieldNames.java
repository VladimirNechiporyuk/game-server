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
    LAST_UPDATED_DATE__FIELD_APPELLATION("lastUpdatedDate"),
    NAME__FIELD_APPELLATION("name"),
    PLAYER_ID__FIELD_APPELLATION("playerId"),
    UNIT_TYPE__FIELD_APPELLATION("unitType"),
    GENDER__FIELD_APPELLATION("gender"),
    ARMY_ID__FIELD_APPELLATION("armyId"),
    SCORE__FIELD_APPELLATION("score"),
    SPEARMAN_IN_HAVY_ARMOR__FIELD_APPELLATION("spearmanInHavyArmors"),
    CAVALRYMAN_IN_HAVY_ARMOR__FIELD_APPELLATION("cavalrymanInHavyArmors"),
    BOWMANS__FIELD_APPELLATION("bowmans");

    private final String field;

    public String getField() {
        return field;
    }

    FieldNames(String field) {
        this.field = field;
    }

    public static FieldNames getFieldAppellationByName(String name) {
        switch (name) {
            case "id" -> {
                return ID__FIELD_APPELLATION;
            }
            case "createdDate" -> {
                return CREATED_DATE__FIELD_APPELLATION;
            }
            case "lastUpdatedDate" -> {
                return LAST_UPDATED_DATE__FIELD_APPELLATION;
            }
            case "name" -> {
                return NAME__FIELD_APPELLATION;
            }
            case "unitType" -> {
                return UNIT_TYPE__FIELD_APPELLATION;
            }
            case "gender" -> {
                return GENDER__FIELD_APPELLATION;
            }
            case "armyId" -> {
                return ARMY_ID__FIELD_APPELLATION;
            }
            case "score" -> {
                return SCORE__FIELD_APPELLATION;
            }
            case "spearmanInHavyArmors" -> {
                return SPEARMAN_IN_HAVY_ARMOR__FIELD_APPELLATION;
            }
            case "cavalrymanInHavyArmors" -> {
                return CAVALRYMAN_IN_HAVY_ARMOR__FIELD_APPELLATION;
            }
            case "bowmans" -> {
                return BOWMANS__FIELD_APPELLATION;
            }
            default -> {
                throw new RuntimeException(String.format("There is no field with name: %s", name));
            }
        }
    }
}
