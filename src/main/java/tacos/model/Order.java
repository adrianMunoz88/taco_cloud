package tacos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Taco_Order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "placedAt")
    private Date placedAt;

    @NotBlank(message = "Name is required")
    @Column(name = "deliveryName")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Column(name = "deliveryStreet")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Column(name = "deliveryCity")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Column(name = "deliveryState")
    private String deliveryState;

    @NotBlank(message = "Zip is required")
    @Column(name = "deliveryZip")
    private String deliveryZip;

    @CreditCardNumber
    @Column(name = "ccNumber")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    @Column(name = "ccExpiration")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "ccCVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    @JoinTable(name = "Taco_Order_Tacos",
            joinColumns = @JoinColumn(name = "tacoOrder"),
            inverseJoinColumns = @JoinColumn(name = "taco"))
    private List<Taco> tacos = new ArrayList<>();


    public void addDesign(Taco taco){
        tacos.add(taco);
    }

    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }

}
