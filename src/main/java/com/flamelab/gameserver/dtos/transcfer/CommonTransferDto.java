package com.flamelab.gameserver.dtos.transcfer;

import com.flamelab.gameserver.utiles.data.ObjectWithData;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class CommonTransferDto extends ObjectWithData {

    private UUID id;
    private LocalDateTime createdDate;

}
