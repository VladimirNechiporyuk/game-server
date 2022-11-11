package com.flamelab.gameserver.dtos.create;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerDto extends CommonCreateDto {

    private String name;

}
