package com.flamelab.gameserver.dtos.update;

import com.flamelab.gameserver.utiles.data.ObjectWithData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class CommonUpdateDto extends ObjectWithData {
}
