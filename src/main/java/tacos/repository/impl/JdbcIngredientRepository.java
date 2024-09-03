package tacos.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }


    public Iterable<Ingredient> findAll() {

        //jdbc.query("select id, name, type from Ingredient",(x,y)->unIngredient(x,y));
        return jdbc.query("select id, name, type from Ingredient",this::mapRowToIngredient);
    }

    public Ingredient findOne(String id) {

        return jdbc.queryForObject("select id, name, type from Ingredient where id=?",this::mapRowToIngredient,id);
    }

    public Ingredient save(Ingredient ingredient) {
         jdbc.update("insert into Ingredient (id, name, type) values(?,?,?)",ingredient.getId()
                ,ingredient.getName(),ingredient.getType().toString());
         return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type")));

    }
}
