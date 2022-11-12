package com.flamelab.gameserver.dtos.transcfer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flamelab.gameserver.utiles.serializers.ObjectIdJsonSerializer;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TransferScoreDto extends CommonTransferDto {

    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    private ObjectId playerId;
    private Integer score;

}
