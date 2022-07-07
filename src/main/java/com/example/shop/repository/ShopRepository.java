package com.example.shop.repository;

import com.example.shop.repository.model.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer>{

}