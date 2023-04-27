package br.com.jsnsoftware.repository;

import br.com.jsnsoftware.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {


    @Query(value = "SELECT * FROM orders WHERE order_id =?1",  nativeQuery = true)
    OrderModel findId(Integer id);



}
