import java.util.Scanner;

public class App {
    static int opcao = 0;
    static ToDo todo = new ToDo();

    public static void main(String[] args) {
        todo.puxarDadosParaObjeto();
        menuPrincipal();
    }

    public static void menuPrincipal() {

        System.out.println("ToDo Menu Principal");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- Criar Tarefa");
        System.out.println("2- Listar Tarefas");
        System.out.println("3- Deletar Tarefa");
        System.out.println("4- Buscar Com filtro");
        System.out.println("5- Consultar Numero de Atividades");
        System.out.println("6- Atualizar Tarefa");
        System.out.println("7- Buscar Por Data");
        System.out.println("0- popular banco");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira: ");
        opcao = entrada.nextInt();
        switch (opcao) {
            case 0:
                popularTarefas();
                break;
            case 1:
                criarTarefa();
                break;
            case 2:
                listaTarefas();
                break;
            case 3:
                deletarTarefa();
                break;
            case 4:
                bucarTarefaPor();
                break;
            case 5:
                listarQuantidadeAtividades();
                break;
            case 6:
                atualizarTarefa();
                break;
            case 7:
                buscarPorData();
            default:
                menuPrincipal();

        }
    }

    private static void buscarPorData() {
        System.out.println("Menu Atualizar BuscarPordata");
        System.out.print("Insira a data de Inicio que deseja dd/MM/yyyy: ");
        Scanner entrada = new Scanner(System.in);
        String dataInicio = entrada.nextLine();
        System.out.println("Insira a data de Fim que deseja dd/MM/yyyy: ");
        String dataFim = entrada.nextLine();
        todo.filtrarTarefaPorData(dataInicio, dataFim);
    }

    private static void atualizarTarefa() {
        String nome_Tarefa = null;
        String nome = null;
        String descricao = null;
        String dataTermino = null;
        Long prioridade_Int = null;
        String categoria = null;
        Status status = null;

        System.out.println("Menu Atualizar Tarefa");
        todo.buscarTarefas();
        System.out.print("Insira o nome de qual tarefa deseja Alterar: ");
        Scanner entrada = new Scanner(System.in);
        nome_Tarefa = entrada.nextLine();
        System.out.println("Insira os novos dados se desejar nao atualizar deixe ele em branco!");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Descricao: ");
        descricao = entrada.nextLine();
        System.out.print("data termino 'dd/MM/yyyy': ");
        dataTermino = entrada.nextLine();
        System.out.print("Prioridade desejada (1-5): ");
        String prioridade_String = entrada.nextLine();
        prioridade_Int = (prioridade_String == "") ? null : Long.parseLong(prioridade_String);
        System.out.print("Categoria: ");
        categoria = entrada.nextLine();
        System.out.print("Status ");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- ToDo");
        System.out.println("2- Doing");
        System.out.println("3- Done");
        System.out.print("Insira: ");
        String status_String = entrada.nextLine();

        switch (status_String) {
            case "1":
                status = Status.ToDO;
                break;
            case "2":
                status = Status.Doing;
                break;
            case "3":
                status = Status.Done;
                break;
            default:
                break;
        }
        todo.atualizarTarefa(nome_Tarefa, nome, descricao, dataTermino, prioridade_Int, categoria, status);
        menuPrincipal();
    }

    private static void popularTarefas() {
        todo.popularBanco();
        System.out.println();
        menuPrincipal();
    }

    private static void listarQuantidadeAtividades() {
        System.out.println("ToDo Menu Listar Atividades");
        System.out.println("Lista de quantas atividades por status existem: ");
        System.out.println("Quantidade ToDo: " + todo.consultarNumAtividades(Status.ToDO));
        System.out.println("Quantidade Doing: " + todo.consultarNumAtividades(Status.Doing));
        System.out.println("Quantidade Done: " + todo.consultarNumAtividades(Status.Done));
        System.out.println();
        menuPrincipal();
    }

    private static void criarTarefa() {
        String nome;
        String descricao;
        String dataTermino;
        Long prioridade_Int;
        String categoria;
        Integer status_Int = null;
        Status status = null;

        System.out.println("ToDo Menu CriarTarefa");
        System.out.print("Nome: ");
        Scanner entrada = new Scanner(System.in);
        nome = entrada.nextLine();
        System.out.print("Descricao: ");
        descricao = entrada.nextLine();
        System.out.print("data termino 'dd/MM/yyyy': ");
        dataTermino = entrada.nextLine();
        System.out.print("Prioridade desejada (1-5): ");
        String prioridade_String = entrada.nextLine();
        prioridade_Int = (prioridade_String == "") ? null : Long.parseLong(prioridade_String);
        System.out.print("Categoria: ");
        categoria = entrada.nextLine();
        System.out.print("Status ");
        System.out.println("Insira o numero  da Opcao Desejada: ");
        System.out.println("1- ToDo");
        System.out.println("2- Doing");
        System.out.println("3- Done");
        System.out.print("Insira: ");
        String status_String = entrada.nextLine();
        status_Int = (status_String == "") ? null : Integer.parseInt(status_String);
        switch (status_Int) {
            case 1:
                status = Status.ToDO;
                break;
            case 2:
                status = Status.Doing;
                break;
            case 3:
                status = Status.Done;
                break;
        }
        todo.criarTarefa(nome, descricao, dataTermino, prioridade_Int, categoria, status);
        System.out.println("Criado Com Sucesso!");
        menuPrincipal();
    }

    private static void listaTarefas() {
        System.out.println("ToDo Menu ListarTarefas");
        todo.buscarTarefas();
        System.out.println();
        menuPrincipal();
    }

    private static void deletarTarefa() {

        String remover;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ToDo Menu DeletarTarefa");
        // Scanner entrada = new Scanner(System.in);
        todo.buscarTarefas();
        System.out.println("Qual Tarefa Deseja Remover?");
        System.out.print("Insira: ");
        remover = entrada.nextLine();
        todo.removerTarefa(remover);
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
                todo.buscarTarefasPoCategoria(entrada.nextLine());
                break;

            case 2:
                System.out.println("Qual prioridade (1-5)? ");
                todo.buscarTarefasPorPrioridade(Long.parseLong(entrada.nextLine()));
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
                        todo.buscarTarefasPorStatus(Status.ToDO);
                        break;
                    case 2:
                        todo.buscarTarefasPorStatus(Status.Doing);
                        break;
                    case 3:
                        todo.buscarTarefasPorStatus(Status.Done);
                        break;
                }
                break;

        }
        System.out.println();
        menuPrincipal();
    }

}
