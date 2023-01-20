import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Tarefa implements Comparator<Tarefa> {
    String nome;
    String descricao;
    LocalDate dataTermino;
    Integer prioridade;
    String categoria;
    Status status;

    public Tarefa() {
    };

    public Tarefa(String nome, String descricao, String dataTermino, Integer prioridade, String categoria,
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

    public Integer getPrioridade() {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = LocalDate.parse(dataTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int compare(Tarefa o1, Tarefa o2) {
        // TODO Auto-generated method stub
        return Integer.compare(o1.prioridade, o2.prioridade);
    }

}
