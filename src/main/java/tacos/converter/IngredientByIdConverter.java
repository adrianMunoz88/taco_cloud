package tacos.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

//@Component
public class IngredientByIdConverter implements Converter <String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source).get();
    }
}
