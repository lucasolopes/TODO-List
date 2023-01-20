import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDo {
    private List<Tarefa> todo = new ArrayList<Tarefa>();

    public void criarTarefa(String nome, String descricao, String dataTermino, Long prioridade, String categoria,
            Status status) {
        todo.add(new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status));
    }

    public void criarTarefa(Tarefa tarefa) {
        todo.add(tarefa);
    }

    public void buscarTarefas() {
        todo.forEach(System.out::println);
    }

    public void removerTarefa(String nome) {
        todo.removeIf(tarefa -> tarefa.getNome().equals(nome));
    }

    public void buscarTarefasPorStatus(Status status) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.status.equals(status))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void buscarTarefasPorPrioridade(Long prioridade) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.prioridade.equals(prioridade))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void buscarTarefasPoCategoria(String categoria) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.categoria.equals(categoria))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public int consultarNumAtividades(Status status) {
        int quant = 0;

        for (Tarefa obj : todo) {
            if (obj.getStatus() == status)
                quant++;
        }
        return quant;
    }

    public void popularBanco() {
        criarTarefa("pokemon", "api", "01/02/2023", 1l, "BACK", Status.ToDO);
        criarTarefa("pokemon", "api", "01/02/2023", 1l, "FRONT", Status.ToDO);
        criarTarefa("pokebola", "api", "15/02/2023", 2l, "BACK", Status.ToDO);
        criarTarefa("pokebola", "api", "15/02/2023", 2l, "front", Status.ToDO);
        criarTarefa("personagem", "api", "30/02/2023", 4l, "BACK", Status.Doing);
        criarTarefa("personagem", "api", "30/02/2023", 4l, "front", Status.Doing);
        criarTarefa("ambiente", "api", "03/03/2023", 5l, "BACK", Status.Doing);
        criarTarefa("ambiente", "api", "03/03/2023", 5l, "front", Status.Doing);
        criarTarefa("vilao", "api", "25/01/2023", 1l, "BACK", Status.Done);
        criarTarefa("vilao", "api", "25/01/2023", 1l, "BACK", Status.Done);
    }
}
