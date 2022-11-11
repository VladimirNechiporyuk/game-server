package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.create.CreatePlayerDto;
import com.flamelab.gameserver.dtos.transcfer.TransferPlayerDto;
import com.flamelab.gameserver.dtos.update.UpdatePlayerDto;

public interface PlayersService extends CommonService<CreatePlayerDto, TransferPlayerDto, UpdatePlayerDto> {
}
