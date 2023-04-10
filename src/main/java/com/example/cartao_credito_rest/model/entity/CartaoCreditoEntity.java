package com.example.cartao_credito_rest.model.entity;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_cartao_credito")
public class CartaoCreditoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(name = "cl_nome_titular", nullable = false)
    private String nomeTitular;

    @Column(name = "cl_numero_cartao", nullable = false, unique = true)
    private String numeroCartao;

    @Column(name = "cl_limite_cartao", nullable = false)
    private double limite;

    @Column(name = "cl_valor_fatura", nullable = false)
    private double valorFatura = 0.00;

    @Column(name = "cl_isDesbloqueado", nullable = false)
    private boolean isDesbloqueado = false;

    @Column(name = "cl_senha", nullable = false)
    private String senha;

    @Column(name = "cl_validade", nullable = false)
    private String validade = "10 ANOS";


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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public boolean isDesbloqueado() {
        return isDesbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        isDesbloqueado = desbloqueado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
