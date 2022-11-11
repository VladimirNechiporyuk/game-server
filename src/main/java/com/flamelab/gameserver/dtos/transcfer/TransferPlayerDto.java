package com.flamelab.gameserver.dtos.transcfer;

import com.flamelab.gameserver.enums.Genders;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TransferPlayerDto extends CommonTransferDto {

    private String name;
    private Genders gender;
    private UUID armyId;

}
