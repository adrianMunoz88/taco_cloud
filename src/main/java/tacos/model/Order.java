package tacos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Table(name = "Taco_Order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Name is required")
    private String deliveryName;
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @NotBlank(message = "State is required")
    private String deliveryState;
    @NotBlank(message = "Zip is required")
    private String deliveryZip;

    @CreditCardNumber
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> design = new ArrayList<>();


    public void addDesign(Taco taco){
        design.add(taco);
    }

    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }

}
