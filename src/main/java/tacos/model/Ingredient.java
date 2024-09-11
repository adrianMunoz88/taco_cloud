package tacos.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@AllArgsConstructor
@Table(name = "Ingredient")
@Entity
public class Ingredient {

    @Id
    @Column(name = "id")
    private  String id;
    @Column(name = "name")
    private  String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private  Type type;


    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
