package com.flamelab.gameserver.entities;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Score extends CommonEntity {

    private ObjectId playerId;
    private Integer score;

}
