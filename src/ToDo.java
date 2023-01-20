import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private List<Tarefa> todo = new ArrayList<Tarefa>();

    public void CriarTarefa(String nome, String descricao, String dataTermino, Prioridade prioridade, String categoria,
            Status status) {
        todo.add(new Tarefa("Pokemon", "Desenvolver uma api", "20/02/2023", Prioridade.ONE, "BACKEND",
                Status.ToDO));
    }

    public void CriarTarefa(Tarefa tarefa) {
        todo.add(tarefa);
    }

    public void buscarTarefas() {
        todo.forEach(System.out::println);
    }

}
