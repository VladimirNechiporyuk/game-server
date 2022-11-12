package com.flamelab.gameserver.entities;

import com.flamelab.gameserver.utiles.data.Unit;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Army extends CommonEntity {

    private ObjectId playerId;
    private Unit spearmanInHavyArmors;
    private Unit cavalrymanInHavyArmors;
    private Unit bowmans;

}
