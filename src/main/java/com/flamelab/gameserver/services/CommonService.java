package com.flamelab.gameserver.services;

import com.flamelab.gameserver.dtos.create.CommonCreateDto;
import com.flamelab.gameserver.dtos.transcfer.CommonTransferDto;
import com.flamelab.gameserver.dtos.update.CommonUpdateDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface CommonService<
        C extends CommonCreateDto,
        T extends CommonTransferDto,
        U extends CommonUpdateDto
        > {

}
