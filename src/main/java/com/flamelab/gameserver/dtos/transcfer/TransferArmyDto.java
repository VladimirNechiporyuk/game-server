package com.flamelab.gameserver.dtos.transcfer;

import com.flamelab.gameserver.utiles.data.Unit;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TransferArmyDto extends CommonTransferDto {

    private Unit spearmanInHavyArmors;
    private Unit cavalrymanInHavyArmors;
    private Unit bowmans;

}
