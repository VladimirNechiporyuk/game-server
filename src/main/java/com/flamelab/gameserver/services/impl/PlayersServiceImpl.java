package com.flamelab.gameserver.services.impl;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.services.PlayersService;
import com.flamelab.gameserver.utiles.*;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.flamelab.gameserver.utiles.naming.DbCollectionNames.PLAYERS__DB_COLLECTION;
import static com.flamelab.gameserver.utiles.naming.FieldNames.ID__FIELD_APPELLATION;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    private final MapperUtility<Player, TransferPlayerDto> mapperFromEntityToTransferDto;
    private final MapperUtility<UpdatePlayerDto, Player> mapperFromUpdateDtoToEntity;
    private final DbEntityUtility<Player> dbEntityUtility;
    private final EntityBuilder<Player, CreatePlayerDto> entityBuilder;
    private final DifferenceUtility<Player> differenceUtility;
    private final ClassUtility<Player> classUtility;

    @Override
    public TransferPlayerDto createEntity(CreatePlayerDto createDto, ObjectId armyId) {
        Player playerForSaving;
        playerForSaving = entityBuilder.buildEntityFromDto(createDto, CreatePlayerDto.class, Player.class);
        playerForSaving.setArmyId(armyId);
        return mapperFromEntityToTransferDto.map(
                dbEntityUtility.saveEntity(
                        playerForSaving,
                        Player.class,
                        PLAYERS__DB_COLLECTION),
                Player.class,
                TransferPlayerDto.class
        );

    }

    @Override
    public TransferPlayerDto getEntityById(ObjectId id) {
        return mapperFromEntityToTransferDto.map(
                fetchPlayerById(id),
//                fetchPlayerByOrThrow(Map.of(ID__FIELD_APPELLATION, id)),
                Player.class,
                TransferPlayerDto.class
        );
    }

    @Override
    public List<TransferPlayerDto> getAllEntities() {
        return mapperFromEntityToTransferDto.mapToList(
                dbEntityUtility.findAllByClass(Player.class, PLAYERS__DB_COLLECTION),
                Player.class,
                TransferPlayerDto.class
        );
    }

    @Override
    public List<String> getAvailableParametersNameOfEntity() {
        return classUtility.getParameterNames(Player.class);
    }

    @Override
    public TransferPlayerDto updateEntityById(ObjectId id, UpdatePlayerDto updatedDto) {
        Player existingPlayer = fetchPlayerById(id);
        Player playerWithNewData = mapperFromUpdateDtoToEntity.map(updatedDto, UpdatePlayerDto.class, Player.class);
        return mapperFromEntityToTransferDto.map(
                updateProjectData(existingPlayer, playerWithNewData),
                Player.class,
                TransferPlayerDto.class);
    }

    @Override
    public void deleteEntityById(ObjectId id) {
        dbEntityUtility.deleteEntityBy(Map.of(ID__FIELD_APPELLATION, id), Player.class, PLAYERS__DB_COLLECTION);
    }

    @Override
    public boolean isPlayerExists(ObjectId playerId) {
        return dbEntityUtility.isEntityExistsBy(Map.of(ID__FIELD_APPELLATION, playerId), Player.class, PLAYERS__DB_COLLECTION);
    }

    private Player fetchPlayerByOrThrow(Map<FieldNames, Object> criterias) {
        return dbEntityUtility.findOneByOrThrow(criterias, Player.class, PLAYERS__DB_COLLECTION);
    }

    private Player fetchPlayerById(ObjectId id) {
        return dbEntityUtility.findOneById(id, Player.class, PLAYERS__DB_COLLECTION);
    }

    private TransferPlayerDto updateEntityBy(Map<FieldNames, Object> criterias, UpdatePlayerDto updatedDto) {
        Player existingProject = fetchPlayerByOrThrow(criterias);
        Player projectWithNewData = mapperFromUpdateDtoToEntity.map(updatedDto, UpdatePlayerDto.class, Player.class);
        return mapperFromEntityToTransferDto.map(
                updateProjectData(existingProject, projectWithNewData),
                Player.class,
                TransferPlayerDto.class);
    }

    private Player updateProjectData(Player projectForUpdate, Player projectWithNewData) {
        Map<FieldNames, Object> fieldsWithNewData = differenceUtility.getChanges(projectForUpdate, projectWithNewData, Player.class);
        return dbEntityUtility.updateEntity(
                projectForUpdate,
                Player.class,
                fieldsWithNewData,
                PLAYERS__DB_COLLECTION);
    }

}
