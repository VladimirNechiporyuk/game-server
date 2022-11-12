package com.flamelab.gameserver.dtos.transcfer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flamelab.gameserver.enums.Genders;
import com.flamelab.gameserver.utiles.serializers.ObjectIdJsonSerializer;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TransferPlayerDto extends CommonTransferDto {

    private String name;
    private Genders gender;
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    private ObjectId armyId;

}
