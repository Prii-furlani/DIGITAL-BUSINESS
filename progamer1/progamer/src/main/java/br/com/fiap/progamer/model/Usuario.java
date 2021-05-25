package br.com.fiap.progamer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
	@Id
	@Column(name = "cd_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name = "nm_usuario", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_email", length = 80, nullable = false, unique = true)
	private String email;
	
	@Column(name = "ds_senha", length = 30, nullable = false)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private Date dataNascimento;
	
	public Usuario() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", dataNascimento=" + dataNascimento + "]";
	}

}
