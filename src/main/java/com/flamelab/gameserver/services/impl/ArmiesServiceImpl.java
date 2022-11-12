package com.flamelab.gameserver.services.impl;

import com.flamelab.gameserver.dtos.create.AddUnitDto;
import com.flamelab.gameserver.dtos.transcfer.TransferArmyDto;
import com.flamelab.gameserver.entities.Army;
import com.flamelab.gameserver.services.ArmiesService;
import com.flamelab.gameserver.utiles.DbEntityUtility;
import com.flamelab.gameserver.utiles.MapperUtility;
import com.flamelab.gameserver.utiles.data.Unit;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.flamelab.gameserver.enums.UnitTypes.*;
import static com.flamelab.gameserver.utiles.naming.DbCollectionNames.ARMIES__DB_COLLECTION;
import static com.flamelab.gameserver.utiles.naming.FieldNames.PLAYER_ID__FIELD_APPELLATION;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArmiesServiceImpl implements ArmiesService {

    private final DbEntityUtility<Army> dbEntityUtility;
    private final MapperUtility<Army, TransferArmyDto> mapperFromEntityToTransferDto;

    @Override
    public TransferArmyDto createArmy() {
        Army army = new Army();
        army.setId(ObjectId.get());
        army.setCreatedDate(LocalDateTime.now());
        army.setLastUpdatedDate(LocalDateTime.now());
        army.setCavalrymanInHavyArmors(new Unit(CAVALRYMAN_IN_HEAVY_ARMOR, 1));
        army.setSpearmanInHavyArmors(new Unit(SPEARMAN_IN_HEAVY_ARMOR, 1));
        army.setBowmans(new Unit(BOWMAN, 1));
        return mapperFromEntityToTransferDto.map(
                dbEntityUtility.saveEntity(army, Army.class, ARMIES__DB_COLLECTION),
                Army.class,
                TransferArmyDto.class
        );
    }

    @Override
    public void setPlayerIdForArmy(ObjectId armyId, ObjectId playerId) {
        Army army = fetchArmyById(armyId);
        Map<FieldNames, Object> fieldsWithNewData = Map.of(PLAYER_ID__FIELD_APPELLATION, playerId);
        dbEntityUtility.updateEntity(army, Army.class, fieldsWithNewData, ARMIES__DB_COLLECTION);
    }

    @Override
    public TransferArmyDto addUnit(AddUnitDto addUnitDto) {
        return null;
    }

    @Override
    public TransferArmyDto getArmyData(ObjectId playerId) {
        return null;
    }

    @Override
    public List<TransferArmyDto> getAllArmiesData() {
        return null;
    }

    private Army fetchArmyById(ObjectId armyId) {
        return dbEntityUtility.findOneById(armyId, Army.class, ARMIES__DB_COLLECTION);
    }


}
