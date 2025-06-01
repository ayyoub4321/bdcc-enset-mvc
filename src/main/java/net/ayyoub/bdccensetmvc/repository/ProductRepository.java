package net.ayyoub.bdccensetmvc.repository;

import net.ayyoub.bdccensetmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
