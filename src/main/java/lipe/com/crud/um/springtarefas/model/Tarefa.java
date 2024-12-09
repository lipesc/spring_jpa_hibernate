package lipe.com.crud.um.springtarefas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Digite um titulo")
  private String titulo;

  private String descricao;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "Digite o status")
  private StatusTarefa status = StatusTarefa.PENDENTE;

  @Column(name = "data_criacao", nullable = false, updatable = false)
  private LocalDateTime dataCriacao;

  @PrePersist
  protected void onCreate() {
    this.dataCriacao = LocalDateTime.now();
  }

  public Tarefa() {

  }

  public Tarefa(Long id, @NotBlank(message = "Digite um titulo") String titulo, String descricao, StatusTarefa status,
      LocalDateTime dataCriacao) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.dataCriacao = dataCriacao;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public StatusTarefa getStatus() {
    return status;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setStatus(StatusTarefa status) {
    this.status = status;
  }

  public enum StatusTarefa {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDO
  }
}
