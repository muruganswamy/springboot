package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.ShoppingItem;
import net.javaguides.springboot.entity.User;

@Repository
public interface ItemRepository extends JpaRepository<ShoppingItem, Long>{

}
