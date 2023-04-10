package com.example.cartao_credito_rest.data.service;

import com.example.cartao_credito_rest.data.repository.CartaoCreditoRepository;
import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public Optional<CartaoCreditoEntity> findByNumeroCartao(String numeroCartao){
        return cartaoCreditoRepository.findByNumeroCartao(numeroCartao);
    }

    @Transactional
    public boolean existsByNumeroCartao(String numeroCartao){
        return cartaoCreditoRepository.existsByNumeroCartao(numeroCartao);
    }

    @Transactional
    public boolean existsByNumeroCartaoAndSenha(String numeroCartao, String senha){
        return cartaoCreditoRepository.existsByNumeroCartaoAndSenha(numeroCartao, senha);
    }

}
