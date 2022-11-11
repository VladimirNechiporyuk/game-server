package com.flamelab.gameserver.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Score extends CommonEntity {

    private UUID playerId;
    private Integer score;

}
