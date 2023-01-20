import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDo {
    private List<Tarefa> todo = new ArrayList<Tarefa>();

    public void CriarTarefa(String nome, String descricao, String dataTermino, Long prioridade, String categoria,
            Status status) {
        todo.add(new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status));
    }

    public void CriarTarefa(Tarefa tarefa) {
        todo.add(tarefa);
    }

    public void BuscarTarefas() {
        todo.forEach(System.out::println);
    }

    public void RemoverTarefa(String nome) {
        todo.removeIf(tarefa -> tarefa.getNome().equals(nome));
    }

    public void BuscarTarefasPorStatus(Status status) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.status.equals(status))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void BuscarTarefasPorPrioridade(Long prioridade) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.prioridade.equals(prioridade))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void BuscarTarefasPoCategoria(String categoria) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.categoria.equals(categoria))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
