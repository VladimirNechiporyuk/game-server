package com.flamelab.gameserver.dtos.update;

import com.flamelab.gameserver.enums.Genders;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlayerDto extends CommonUpdateDto {

    private String name;
    private Genders gender;

}
