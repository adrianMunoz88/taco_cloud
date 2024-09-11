package tacos.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import tacos.model.Order;
import tacos.model.Taco;
import tacos.repository.OrderRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Repository
public class JdbcOrderRepository  {

/*
    private SimpleJdbcInsert orderSimpleJdbcInsert;
    private SimpleJdbcInsert orderTacoSimpleJdbcInsert;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {

        this.orderSimpleJdbcInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        this.orderTacoSimpleJdbcInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();
    }



    public Order save(Order order) {

        order.setPlacedAt(new Date());
        long idOrder = saveOrderDetail(order);
        order.setId(idOrder);

        for(Taco taco : order.getDesign()){

            saveTacoOrderTacos(taco,idOrder);
        }

        return order;
    }

    public long saveOrderDetail(Order order){
        @SuppressWarnings("unchecked")
        Map<String,Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());
        return orderSimpleJdbcInsert.executeAndReturnKey(values).longValue();
    }

    public void saveTacoOrderTacos(Taco taco, long idOrder){

        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder",idOrder);
        values.put("taco",taco.getId());
        orderTacoSimpleJdbcInsert.execute(values);

    }

*/
}
