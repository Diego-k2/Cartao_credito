package com.example.cartao_credito_rest.data.repository;

import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCreditoEntity, UUID> {

}
