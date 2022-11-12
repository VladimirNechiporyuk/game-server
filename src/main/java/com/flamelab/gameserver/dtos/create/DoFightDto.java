package com.flamelab.gameserver.dtos.create;

import com.flamelab.gameserver.enums.UnitTypes;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class DoFightDto {

    private ObjectId playerId;
    private UnitTypes unitType;

}
