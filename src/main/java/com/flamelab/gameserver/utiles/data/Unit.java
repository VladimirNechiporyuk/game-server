package com.flamelab.gameserver.utiles.data;

import com.flamelab.gameserver.enums.UnitTypes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Unit {

    private UnitTypes unitType;
    private Integer amountOfUnits;

}
