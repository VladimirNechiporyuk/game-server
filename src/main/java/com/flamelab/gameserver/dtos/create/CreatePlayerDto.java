package com.flamelab.gameserver.dtos.create;

import com.flamelab.gameserver.enums.Genders;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerDto extends CommonCreateDto {

    private String name;
    private Genders gender;

}
