import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    String nome;
    String descricao;
    LocalDate dataTermino;
    Long prioridade;
    String categoria;
    Status status;

    public Tarefa(String nome, String descricao, String dataTermino, Long prioridade, String categoria,
            Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = LocalDate.parse(dataTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public Long getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome: " + nome + " | Descricao: " + descricao + " | Data Termino: " + dataTermino.toString()
                + " | Prioridade: " + prioridade + " | Categoria: " + categoria + " | Status: " + status;
    }

}
