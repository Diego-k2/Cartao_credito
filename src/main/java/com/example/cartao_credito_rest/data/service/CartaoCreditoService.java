package com.example.cartao_credito_rest.data.service;

import com.example.cartao_credito_rest.data.repository.CartaoCreditoRepository;
import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartaoCreditoService {

    final CartaoCreditoRepository cartaoCreditoRepository;
    public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository){
        this.cartaoCreditoRepository = cartaoCreditoRepository;
    }

    @Transactional
    public CartaoCreditoEntity save(CartaoCreditoEntity cartaoCreditoEntity){
        return cartaoCreditoRepository.save(cartaoCreditoEntity);
    }



}
