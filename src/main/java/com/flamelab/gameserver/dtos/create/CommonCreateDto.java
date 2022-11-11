package com.flamelab.gameserver.dtos.create;

import com.flamelab.gameserver.utiles.data.ObjectWithData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class CommonCreateDto extends ObjectWithData {
}
