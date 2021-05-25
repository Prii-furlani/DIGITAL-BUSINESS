package br.com.fiap.progamer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SETUP")
public class Setup {
	
	@Id
	@Column(name = "cd_setup")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nm_setup", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "ds_setup", length = 200, nullable = false)
	private String descricao;
	
	@Column(name = "vl_preco", nullable = false)
	private BigDecimal preco;
	
	public Setup() {}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Setup [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
}

