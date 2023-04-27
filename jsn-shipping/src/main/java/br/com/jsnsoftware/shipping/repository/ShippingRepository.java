package br.com.jsnsoftware.shipping.repository;

import br.com.jsnsoftware.shipping.model.ShippingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingModel, Long> {
}
