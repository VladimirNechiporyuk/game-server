package com.flamelab.gameserver.entities;

import com.flamelab.gameserver.enums.Genders;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "players")
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Player extends CommonEntity {

    @Id
    private UUID id;
    private String name;
    private Genders gender;
    private UUID armyId;

}
