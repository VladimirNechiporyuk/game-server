package com.flamelab.gameserver.entities;

import com.flamelab.gameserver.utiles.data.Unit;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Army extends CommonEntity {

    private UUID ownPlayerId;
    private Unit mages;
    private Unit swordsmanInHavyArmors;
    private Unit swordsmanInLightArmors;
    private Unit spearmanInHavyArmors;
    private Unit spearmanInLightArmors;
    private Unit cavalrymanInHavyArmors;
    private Unit cavalrymanInLightArmors;
    private Unit bowmans;

}
