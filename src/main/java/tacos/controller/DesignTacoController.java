package tacos.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.Order;
import tacos.model.Taco;
import tacos.repository.IngredientRepository;
import tacos.repository.impl.JdbcTacoRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final JdbcTacoRepository jdbcTacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, JdbcTacoRepository jdbcTacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.jdbcTacoRepository = jdbcTacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model){


    /*    List<Ingredient> ingredientes = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)

        );
*/

        List<Ingredient> ingredientes = new ArrayList<>();
        Iterable<Ingredient> ingredientesRep = ingredientRepository.findAll();

        ingredientesRep.forEach(x-> ingredientes.add(x));
        Type[] types = Ingredient.Type.values();

        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredientes,type));
        }

        Taco taco = new Taco();
        taco.setIngredients(new ArrayList<>());
        model.addAttribute("taco",taco);
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredientes, Type type) {



        return ingredientes.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .toList();

    }

    @PostMapping
    public String proccessDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "/design";
        }
        Taco saveTaco = jdbcTacoRepository.save(taco);
        order.addDesign(saveTaco);
//        log.info("Processing design: "+ taco);
        return "redirect:/orders/current";
    }

}
