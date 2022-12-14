package com.flamelab.gameserver.dtos.transcfer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flamelab.gameserver.utiles.data.ObjectWithData;
import com.flamelab.gameserver.utiles.serializers.ObjectIdJsonSerializer;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class CommonTransferDto extends ObjectWithData {

    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    private ObjectId id;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;

}
