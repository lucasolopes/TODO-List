import java.util.Scanner;

public class App {
    static int opcao = 0;
    static ToDo todo = new ToDo();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("ToDo Menu Principal");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- Criar Tarefa");
        System.out.println("2- Listar Tarefas");
        System.out.println("3- Deletar Tarefa");
        System.out.println("4- Buscar Com filtro");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira: ");
        opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                criarTarefa();
            case 2:
                listaTarefas();
            case 3:
                deletarTarefa();
            case 4:
                bucarTarefaPor();
        }
    }

    private static void criarTarefa() {
        String nome;
        String descricao;
        String dataTermino;
        Long prioridade_Int;
        String categoria;
        int status_Int;
        Status status = null;

        System.out.println("ToDo Menu CriarTarefa");
        System.out.print("Nome: ");
        Scanner entrada = new Scanner(System.in);
        nome = entrada.next();
        System.out.print("Descricao: ");
        descricao = entrada.next();
        System.out.print("data termino 'dd/MM/yyyy': ");
        dataTermino = entrada.next();
        System.out.print("Prioridade desejada (1-5): ");
        prioridade_Int = Long.parseLong(entrada.next());
        System.out.print("Categoria: ");
        categoria = entrada.next();
        System.out.print("Status ");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- ToDo");
        System.out.println("2- Doing");
        System.out.println("3- Done");
        System.out.print("Insira: ");
        status_Int = entrada.nextInt();
        switch (status_Int) {
            case 1:
                status = Status.ToDO;
            case 2:
                status = Status.Doing;
            case 3:
                status = Status.Done;
        }
        todo.CriarTarefa(nome, descricao, dataTermino, prioridade_Int, categoria, status);
        System.out.println("Criado Com Sucesso!");
        menuPrincipal();
    }

    private static void listaTarefas() {
        System.out.println("ToDo Menu ListarTarefas");
        todo.BuscarTarefas();
        System.out.println();
        menuPrincipal();
    }

    private static void deletarTarefa() {

        String remover;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ToDo Menu DeletarTarefa");
        // Scanner entrada = new Scanner(System.in);
        todo.BuscarTarefas();
        System.out.println("Qual Tarefa Deseja Remover?");
        System.out.print("Insira: ");
        remover = entrada.next();
        todo.RemoverTarefa(remover);
        System.out.println();
        menuPrincipal();
    }

    private static void bucarTarefaPor() {
        System.out.println("ToDo Menu BuscarTarefaPor");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- Categoria");
        System.out.println("2- Prioridade");
        System.out.println("3- Status");
        System.out.print("Insira: ");
        Scanner entrada = new Scanner(System.in);
        int buscarPor = entrada.nextInt();
        switch (buscarPor) {
            case 1:
                System.out.println("Qual categoria? ");
                todo.BuscarTarefasPoCategoria(entrada.next());
                break;

            case 2:
                System.out.println("Qual prioridade (1-5)? ");
                todo.BuscarTarefasPorPrioridade(Long.parseLong(entrada.next()));
                break;

            case 3:
                System.out.println("Status");
                System.out.println("Insira o numero  da Opcao Desejada: ");
                System.out.println("1- ToDo");
                System.out.println("2- Doing");
                System.out.println("3- Done");
                System.out.print("Insira: ");
                int status_Int = entrada.nextInt();
                switch (status_Int) {
                    case 1:
                        todo.BuscarTarefasPorStatus(Status.ToDO);
                        break;
                    case 2:
                        todo.BuscarTarefasPorStatus(Status.Doing);
                        break;
                    case 3:
                        todo.BuscarTarefasPorStatus(Status.Done);
                        break;
                }
                break;

        }
        System.out.println();
        menuPrincipal();
    }

}
