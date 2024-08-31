package in.ac.jssateb.mallmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.jssateb.mallmanagement.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
