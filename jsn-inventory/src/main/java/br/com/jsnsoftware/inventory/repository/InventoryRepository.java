package br.com.jsnsoftware.inventory.repository;

import br.com.jsnsoftware.inventory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
}
