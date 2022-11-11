package com.flamelab.gameserver.services.impl;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;
import com.flamelab.gameserver.entities.Player;
import com.flamelab.gameserver.exceptions.NoExistentEntityException;
import com.flamelab.gameserver.repositories.PlayersRepository;
import com.flamelab.gameserver.services.PlayersService;
import com.flamelab.gameserver.utiles.*;
import com.flamelab.gameserver.utiles.naming.FieldNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    private final PlayersRepository playersRepository;
    private final MapperUtility<Player, TransferPlayerDto> mapperFromEntityToTransferDto;
    private final MapperUtility<UpdatePlayerDto, Player> mapperFromUpdateDtoToEntity;
    private final EntityBuilder<Player, CreatePlayerDto> entityBuilder;
    private final CopyUtility<Player> copyUtility;
    private final DifferenceUtility<Player> differenceUtility;
    private final ClassUtility<Player> classUtility;

    @Override
    public TransferPlayerDto createEntity(CreatePlayerDto createDto) {
        Player playerForSaving;
        playerForSaving = entityBuilder.buildEntityFromDto(createDto, CreatePlayerDto.class, Player.class);
        playerForSaving.setId(UUID.randomUUID());
        return mapperFromEntityToTransferDto.map(
                playersRepository.save(playerForSaving),
                Player.class,
                TransferPlayerDto.class
        );

    }

    @Override
    public TransferPlayerDto getEntityById(UUID id) {
        return mapperFromEntityToTransferDto.map(
                getPlayerById(id),
                Player.class,
                TransferPlayerDto.class
        );
    }

    @Override
    public List<TransferPlayerDto> getAllEntities() {
        return mapperFromEntityToTransferDto.mapToList(
                playersRepository.findAll(),
                Player.class,
                TransferPlayerDto.class
        );
    }

    @Override
    public TransferPlayerDto updateEntity(UUID id, UpdatePlayerDto updateDto) {
        Player playerForUpdate = getPlayerById(id);
        Player playerWithNewData = mapperFromUpdateDtoToEntity.map(updateDto, UpdatePlayerDto.class, Player.class);
        Map<FieldNames, Object> changes = differenceUtility.getChanges(playerForUpdate, playerWithNewData, Player.class);
        playerForUpdate = classUtility.setValuesForFields(playerForUpdate, Player.class, changes);
        return mapperFromEntityToTransferDto.map(
                playersRepository.save(playerForUpdate),
                Player.class,
                TransferPlayerDto.class
        );
    }

    @Override
    public void deleteEntityById(UUID id) {
        playersRepository.deleteById(id);
    }

    private Player getPlayerById(UUID id) {
        Optional<Player> playerByIdOptional = playersRepository.findPlayerById(id);
        if (playerByIdOptional.isEmpty()) {
            throw new NoExistentEntityException(String.format("Player with id: '%s' does not exists.", id));
        } else {
            return playerByIdOptional.get();
        }
    }

}
