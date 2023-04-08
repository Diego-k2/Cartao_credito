package com.example.cartao_credito_rest.controller;

import com.example.cartao_credito_rest.data.service.CartaoCreditoService;
import com.example.cartao_credito_rest.model.dto.CartaoCreditoDto;
import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartaoCreditoController {

    final CartaoCreditoService cartaoCreditoService;
    public CartaoCreditoController(CartaoCreditoService cartaoCreditoService){
        this.cartaoCreditoService = cartaoCreditoService;
    }

    @PostMapping("/novo/cartao")
    public ResponseEntity<Object> criaCartao(@Valid @RequestBody CartaoCreditoDto cartaoCreditoDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
        }

        try{
            CartaoCreditoEntity cartaoCreditoEntity = cartaoCreditoDto.parseToEntity();
            return ResponseEntity.status(HttpStatus.CREATED).body(cartaoCreditoService.save(cartaoCreditoEntity));

        } catch (Exception exception){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

        }
    }
}
