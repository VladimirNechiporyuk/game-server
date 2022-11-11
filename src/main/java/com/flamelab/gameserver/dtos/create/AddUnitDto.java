package com.flamelab.gameserver.dtos.create;

import com.flamelab.gameserver.enums.UnitTypes;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AddUnitDto extends CommonCreateDto {

    private UUID playerId;
    private UnitTypes unitType;

}
