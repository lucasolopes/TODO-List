import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDo {
    private List<Tarefa> todo = new ArrayList<Tarefa>();
    private String filePath = "dados.csv";

    public void criarTarefa(String nome, String descricao, String dataTermino, Long prioridade, String categoria,
            Status status) {
        Tarefa tarefa = new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status);
        todo.add(tarefa);
        salvarTarefa(tarefa);
    }

    public void criarTarefa(Tarefa tarefa) {
        todo.add(tarefa);
        ;
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

    public void atualizarTarefa(String nomeTarefa, String nome, String descricao, String dataTermino,
            Long prioridade, String categoria, Status status) {
        for (Tarefa tarefa : todo) {
            if (tarefa.getNome().equals(nomeTarefa)) {
                if (!nome.isBlank())
                    tarefa.setNome(nome);
                if (!descricao.isBlank())
                    tarefa.setDescricao(descricao);
                if (!dataTermino.isBlank())
                    tarefa.setDataTermino(dataTermino);
                if (prioridade != null)
                    tarefa.setPrioridade(prioridade);
                if (!categoria.isBlank())
                    tarefa.setCategoria(categoria);
                if (status != null)
                    tarefa.setStatus(status);
            }
        }
    }

    public void filtrarTarefaPorData(String dataInicio, String dataFim) {
        LocalDate start = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate end = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Tarefa> tarefasPorData = todo.stream()
                .filter(e -> e.getDataTermino().isAfter(start.minusDays(1))
                        && e.getDataTermino().isBefore(end.plusDays(1)))
                .collect(Collectors.toList());
        tarefasPorData.forEach(System.out::println);
    }

    public void popularBanco() {
        criarTarefa("pokemon", "api", "01/02/2023", 1l, "BACK", Status.ToDO);
        criarTarefa("pokemon1", "api", "01/02/2023", 1l, "FRONT", Status.ToDO);
        criarTarefa("pokebola", "api", "15/02/2023", 2l, "BACK", Status.ToDO);
        criarTarefa("pokebola1", "api", "15/02/2023", 2l, "front", Status.ToDO);
        criarTarefa("personagem", "api", "30/02/2023", 4l, "BACK", Status.Doing);
        criarTarefa("personagem1", "api", "30/02/2023", 4l, "front", Status.Doing);
        criarTarefa("ambiente", "api", "03/03/2023", 5l, "BACK", Status.Doing);
        criarTarefa("ambiente1", "api", "03/03/2023", 5l, "front", Status.Doing);
        criarTarefa("vilao", "api", "25/01/2023", 1l, "BACK", Status.Done);
        criarTarefa("vilao1", "api", "25/01/2023", 1l, "BACK", Status.Done);
    }

    private void salvarTarefa(Tarefa tarefa) {
        try (FileWriter fw = new FileWriter(filePath, true);) {

            fw.append(tarefa.getNome() + "," + tarefa.getDescricao() + ","
                    + tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ","
                    + tarefa.getPrioridade() + "," + tarefa.getCategoria() + "," + tarefa.getStatus() + "\n");
            fw.flush();

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void puxarDadosParaObjeto() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Tarefa object = new Tarefa();
                object.setNome(values[0]);
                object.setDescricao(values[1]);
                object.setDataTermino(values[2]);
                object.setPrioridade(Long.parseLong(values[3]));
                object.setCategoria(values[4]);
                object.setStatus(Status.valueOf(values[5]));
                todo.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
