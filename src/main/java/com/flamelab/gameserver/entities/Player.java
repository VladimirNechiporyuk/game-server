package com.flamelab.gameserver.entities;

import com.flamelab.gameserver.enums.Genders;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Player extends CommonEntity {

    private String name;
    private Genders gender;
    private ObjectId armyId;

}
