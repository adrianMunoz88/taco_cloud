package tacos.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.repository.TacoRepository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

//@Repository
public class JdbcTacoRepository {

    /*
   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Taco save(Taco taco) {

       long id = saveTacoInfo(taco);
       taco.setId(id);

       for (Ingredient ingredient : taco.getIngredients()){
           saveIngredientToTaco(ingredient,taco.getId());
       }
        return taco;
    }

    private long saveTacoInfo(Taco taco){

       taco.setCreatedAt(new Date());

       PreparedStatementCreatorFactory  pscf = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP);

       pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime())));

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(psc,keyHolder);

        return keyHolder.getKey().longValue();

    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId){

       jdbcTemplate.update("Insert into Taco_Ingredients (taco, ingredient) values (?,?)"
               ,tacoId,ingredient.getId());


    }
*/
}
