package com.example.cartao_credito_rest.model.dto;

import com.example.cartao_credito_rest.model.entity.CartaoCreditoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CartaoCreditoDto {

    @NotBlank(message = "Nome não pode estar em Branco")
    private String nomeTitular;

    @NotBlank(message = "Numero não pode estar em Branco")
    private String numeroCartao;

    @NotNull(message = "Limite não pode estar em Branco")
    private Double limite;

    @NotBlank(message = "Senha não pode estar em Branco")
    private String senha;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CartaoCreditoEntity parseToEntity(){

        CartaoCreditoEntity cartaoCreditoEntity = new CartaoCreditoEntity();

        cartaoCreditoEntity.setNomeTitular(this.nomeTitular);
        cartaoCreditoEntity.setNumeroCartao(this.numeroCartao);
        cartaoCreditoEntity.setLimite(this.limite);
        cartaoCreditoEntity.setSenha(this.senha);

        return cartaoCreditoEntity;
    }



}
