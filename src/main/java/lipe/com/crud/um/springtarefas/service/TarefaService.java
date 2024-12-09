package lipe.com.crud.um.springtarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lipe.com.crud.um.springtarefas.dto.TarefaDTO;
import lipe.com.crud.um.springtarefas.model.Tarefa;
import lipe.com.crud.um.springtarefas.model.Tarefa.StatusTarefa;
import lipe.com.crud.um.springtarefas.repository.TarefaRepository;

@Service
public class TarefaService {

  private final TarefaRepository repository;

  public TarefaService(TarefaRepository repository) {
    this.repository = repository;
  }

  public Tarefa criTarefa(TarefaDTO dto) {
    Tarefa tarefa = new Tarefa();
    tarefa.setTitulo(dto.getTitulo());
    tarefa.setDescricao(dto.getDescricao());
    return repository.save(tarefa);
  }

  public List<Tarefa> listarTarefas() {
    return repository.findAll();
  }

  public Tarefa atualizarStatus(Long id, StatusTarefa novoStatus) {
    Tarefa tarefa = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Id não encontrado"));
    tarefa.setStatus(novoStatus);
    return repository.save(tarefa);
  }

  public void excluirTarefa(Long id) {
    repository.deleteById(id);
  }

}
