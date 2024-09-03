package tacos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 caracteres long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void creatAt(){
        this.createdAt = new Date();
    }

}
