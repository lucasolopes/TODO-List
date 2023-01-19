public class App {
    public static void main(String[] args) throws Exception {
        Tarefa tarefa = new Tarefa("Pokemon", "Desenvolver uma api", "20/02/2023", Prioridade.ONE, "BACKEND",
                Status.ToDO);
        System.out.println(tarefa);
    }
}
