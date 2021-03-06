package com.example.shop.repository;

import com.example.shop.model.StoreByWareDto;
import com.example.shop.repository.model.ShopEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {

    Optional<ShopEntity> getShopEntityByWareAndStore(String ware, String store);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ShopEntity e SET e.amount = ?2 where e.prodId = ?1")
    void updateAmount(Long id, Integer amount);

    @Query(value = "SELECT new com.example.shop.model.StoreByWareDto(st.store, st.address, sh.amount) FROM ShopEntity sh " +
                    "JOIN StoreEntity st ON sh.store = st.store WHERE sh.ware = ?1")
    List<StoreByWareDto> getStoresByWare(String ware);

}
