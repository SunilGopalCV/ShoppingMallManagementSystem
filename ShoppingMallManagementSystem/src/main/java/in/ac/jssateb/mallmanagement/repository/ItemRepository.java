package in.ac.jssateb.mallmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.jssateb.mallmanagement.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
}
