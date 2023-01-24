import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Tarefa implements Comparator<Tarefa> {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;

    private LocalTime horaTermino;
    private Boolean alarm;
    private LocalDateTime dataAlarm;

    private Integer prioridade;
    private String categoria;
    private Status status;

    public Tarefa() {
    };

    public Tarefa(String nome, String descricao, String dataTermino, String horaTermino, Boolean alarm,
            String dataAlarm, Integer prioridade, String categoria,
            Status status) {

        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = LocalDate.parse(dataTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        this.horaTermino = LocalTime.parse(horaTermino, DateTimeFormatter.ofPattern("HH:mm"));
        this.alarm = alarm;
        if (dataAlarm != null) {
            this.dataAlarm = LocalDateTime.parse(dataAlarm, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } else {
            this.dataAlarm = LocalDateTime.of(getDataTermino(), getHoraTermino()).minusHours(2);
        }

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
        LocalDateTime dataHoraTermino = LocalDateTime.of(dataTermino, horaTermino);
        return "Nome: " + nome +
                " | Descricao: " + descricao +
                " | Data Termino: " + dataHoraTermino.toString() +
                " | Alarm: " + ((this.alarm) ? "Ativo" : "Desativado") +
                ((this.alarm) ? " | Data Alarm: " + dataAlarm.toString() : "") +
                " | Prioridade: " + prioridade +
                " | Categoria: " + categoria +
                " | Status: " + status;
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

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = LocalTime.parse(horaTermino, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public Boolean getAlarm() {
        return alarm;
    }

    public void setAlarm(Boolean alarm) {
        this.alarm = alarm;
    }

    public LocalDateTime getDataAlarm() {
        return dataAlarm;
    }

    public void setDataAlarm(String dataAlarm) {
        this.dataAlarm = LocalDateTime.parse(dataAlarm, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

}
