package com.flamelab.gameserver.dtos.transcfer;

import com.flamelab.gameserver.utiles.data.Unit;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TransferArmyId extends CommonTransferDto {

    private Unit mages;
    private Unit swordsmanInHavyArmors;
    private Unit swordsmanInLightArmors;
    private Unit spearmanInHavyArmors;
    private Unit spearmanInLightArmors;
    private Unit cavalrymanInHavyArmors;
    private Unit cavalrymanInLightArmors;
    private Unit bowmans;

}
