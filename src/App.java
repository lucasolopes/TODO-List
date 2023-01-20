public class App {
    public static void main(String[] args) throws Exception {

        ToDo todo = new ToDo();

        todo.CriarTarefa("Pokemon", "Desenvolver uma api", "20/02/2023", Prioridade.ONE, "BACKEND", Status.ToDO);

        todo.buscarTarefas();
    }
}
