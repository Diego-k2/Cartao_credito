package com.example.cartao_credito_rest.controller;

import com.example.cartao_credito_rest.data.service.CartaoCreditoService;
import com.example.cartao_credito_rest.model.dto.CartaoCreditoDto;
import com.example.cartao_credito_rest.model.dto.CartaoNumeroSenhaDto;
import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartaoCreditoController {

    final CartaoCreditoService cartaoCreditoService;
    public CartaoCreditoController(CartaoCreditoService cartaoCreditoService){
        this.cartaoCreditoService = cartaoCreditoService;
    }

    @PostMapping("/cartao")
    public ResponseEntity<Object> criaCartao(@Valid @RequestBody CartaoCreditoDto cartaoCreditoDto, BindingResult bindingResult){

        try{
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
            }
            CartaoCreditoEntity cartaoCreditoEntity = cartaoCreditoDto.parseToEntity();
            return ResponseEntity.status(HttpStatus.CREATED).body(cartaoCreditoService.save(cartaoCreditoEntity));

        } catch (Exception exception){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

        }
    }

    @PatchMapping("/cartao/desbloquear")
    public ResponseEntity<Object> desbloquearCartao(@RequestBody CartaoNumeroSenhaDto cartaoNumeroSenhaDto, BindingResult bindingResult){

        try {
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
            }

            if(!cartaoCreditoService.existsByNumeroCartao(cartaoNumeroSenhaDto.getNumeroCartao()) ||
                    !cartaoCreditoService.existsByNumeroCartaoAndSenha(cartaoNumeroSenhaDto.getNumeroCartao(),  cartaoNumeroSenhaDto.getSenhaCartao())){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Numero do Cartão ou Senha não estão corretos.");
            }

            CartaoCreditoEntity cartaoCreditoEntity = cartaoCreditoService.findByNumeroCartao(cartaoNumeroSenhaDto.getNumeroCartao()).get();

            if(cartaoCreditoEntity.isDesbloqueado()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cartão já se encontra desbloqueado");
            } else {
                cartaoCreditoEntity.setDesbloqueado(true);
            }

            return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.save(cartaoCreditoEntity));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

}
