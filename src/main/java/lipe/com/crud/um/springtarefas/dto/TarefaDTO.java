package lipe.com.crud.um.springtarefas.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lipe.com.crud.um.springtarefas.model.Tarefa.StatusTarefa;

public class TarefaDTO {
  private Long id;
  @NotBlank(message = "Digite um titulo")
  private String titulo;
  private String descricao;
  private StatusTarefa status;
  private LocalDateTime dataCriacao;

  public TarefaDTO() {
  }

  public TarefaDTO(Long id, @NotBlank(message = "Digite um titulo") String titulo, String descricao,
      StatusTarefa status, LocalDateTime dataCriacao) {
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

}
