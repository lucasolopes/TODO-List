import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ToDo {
    private List<Tarefa> todo = new ArrayList<Tarefa>();
    private String filePath = "dados.csv";

    public void criarTarefa(String nome, String descricao, String dataTermino, String horaTermino, Boolean alarm,
            String dataAlarm, Integer prioridade, String categoria,
            Status status) {

        Tarefa tarefa = new Tarefa(nome, descricao, dataTermino, horaTermino, alarm, dataAlarm, prioridade, categoria,
                status);
        todo.add(tarefa);
        salvarTarefa(tarefa);
        Collections.sort(todo, new Tarefa());
    }

    public void criarTarefa(Tarefa tarefa) {
        todo.add(tarefa);
    }

    public void buscarTarefas() {
        Collections.sort(todo, new Tarefa());
        todo.forEach(System.out::println);
    }

    public void removerTarefa(String nome) {
        todo.removeIf(tarefa -> tarefa.getNome().equals(nome));
    }

    public void buscarTarefasPorStatus(Status status) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.getStatus().equals(status))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void buscarTarefasPorPrioridade(Integer prioridade) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.getPrioridade().equals(prioridade))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void buscarTarefasPoCategoria(String categoria) {
        List<Tarefa> collect = todo.stream().filter(tarefa -> tarefa.getCategoria().equals(categoria))
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
            Integer prioridade, String categoria, Status status) {
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
        Collections.sort(todo, new Tarefa());
        atualizarTarefaArquivo();
    }

    private void atualizarTarefaArquivo() {
        for (Tarefa tarefa : todo) {
            try (FileWriter fw = new FileWriter(filePath, false);) {
                fw.append(tarefa.getNome() + "," +
                        tarefa.getDescricao() + "," +
                        tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "," +
                        tarefa.getHoraTermino().format(DateTimeFormatter.ofPattern("HH:mm")) + "," +
                        tarefa.getAlarm() + "," +
                        tarefa.getDataAlarm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "," +
                        tarefa.getPrioridade() + "," +
                        tarefa.getCategoria() + "," +
                        tarefa.getStatus() + "\n");
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
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
        Collections.sort(todo, new Tarefa());
        tarefasPorData.forEach(System.out::println);
    }

    public void popularBanco() {
        criarTarefa("pokemon", "api", "01/02/2023", "23:12", true, "30/01/2023 12:10", 1, "BACK", Status.ToDO);

        criarTarefa("pokemon1", "api", "01/02/2023", "23:12", true, "30/01/2023 12:10", 1, "FRONT", Status.ToDO);

        criarTarefa("pokebola", "api", "15/02/2023", "23:12", true, "30/01/2023 12:10", 2, "BACK", Status.ToDO);

        criarTarefa("pokebola1", "api", "15/02/2023", "23:12", true, "30/01/2023 12:10", 2, "front", Status.ToDO);

        criarTarefa("personagem", "api", "30/02/2023", "23:12", true, "30/01/2023 12:10", 5, "BACK", Status.Doing);

        criarTarefa("personagem1", "api", "30/02/2023", "23:12", true, "30/01/2023 12:10", 4, "front", Status.Doing);

        criarTarefa("ambiente", "api", "03/03/2023", "23:12", true, "30/01/2023 12:10", 1, "BACK", Status.Doing);

        criarTarefa("ambiente1", "api", "03/03/2023", "23:12", true, "30/01/2023 12:10", 5, "front", Status.Doing);

        criarTarefa("vilao", "api", "25/01/2023", "23:12", true, "30/01/2023 12:10", 1, "BACK", Status.Done);

        criarTarefa("vilao1", "api", "25/01/2023", "23:12", true, "30/01/2023 12:10", 1, "BACK", Status.Done);
    }

    private void salvarTarefa(Tarefa tarefa) {
        try (FileWriter fw = new FileWriter(filePath, true);) {

            fw.append(tarefa.getNome() + "," +
                    tarefa.getDescricao() + "," +
                    tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "," +
                    tarefa.getHoraTermino().format(DateTimeFormatter.ofPattern("HH:mm")) + "," +
                    tarefa.getAlarm() + "," +
                    tarefa.getDataAlarm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "," +
                    tarefa.getPrioridade() + "," +
                    tarefa.getCategoria() + "," +
                    tarefa.getStatus() + "\n");
            fw.flush();

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(todo, new Tarefa());
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
                object.setHoraTermino(values[3]);
                object.setAlarm(Boolean.parseBoolean(values[4]));
                object.setDataAlarm(values[5]);
                object.setPrioridade(Integer.parseInt(values[6]));
                object.setCategoria(values[7]);
                object.setStatus(Status.valueOf(values[8]));
                todo.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alarmesAtivos() {

        LocalDateTime agora = LocalDateTime.now();
        for (Tarefa tarefa : todo) {
            if (tarefa.getAlarm()) {
                if (agora.isEqual(tarefa.getDataAlarm()) || agora.isAfter(tarefa.getDataAlarm())) {
                    System.out.println("Alarme Disparado: " + tarefa.getNome());
                }
            }
        }

    }

    public void desativarAlarmes() {
        LocalDateTime agora = LocalDateTime.now();
        for (Tarefa tarefa : todo) {
            if (tarefa.getAlarm()) {
                if (agora.isEqual(tarefa.getDataAlarm()) || agora.isAfter(tarefa.getDataAlarm())) {
                    tarefa.setAlarm(false);
                }
            }
        }
        atualizarTarefaArquivo();
    }

}
