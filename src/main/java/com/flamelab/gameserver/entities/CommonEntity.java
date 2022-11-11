package com.flamelab.gameserver.entities;

import com.flamelab.gameserver.utiles.data.ObjectWithData;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class CommonEntity extends ObjectWithData {

    private LocalDateTime createdDate;

}
