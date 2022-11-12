package com.flamelab.gameserver.utiles.data;

import com.flamelab.gameserver.enums.UnitTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    private UnitTypes unitType;
    private Integer amountOfUnits;

}
