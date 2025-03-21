import java.util.Scanner;

public class Library {

    static Scanner scan = new Scanner(System.in);
    static String[] livro = new String[30];
    static String[] autor = new String[30];
    static int contador = 0;

    public static void main(String[] args) {
        int opcao = 0;

        System.out.println("Bem-vindo ao Modern Library!");

        while(opcao != 5) {
            System.out.println("1 - Adicionar um novo livro: ");
            System.out.println("2 - Pesquisar livro por título: ");
            System.out.println("3 - Excluir livro pelo título: ");
            System.out.println("4 - Listar todos os livros da biblioteca: ");
            System.out.println("5 - Sair");

            System.out.println("Escolha umas das opções do menu acima: ");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    addNovoLivro();
                    break;
                case 2:
                    pesquisaLivro();
                    break;
                case 3:
                    excluirLivro();
                    break;
                case 4:
                    listarLivro();
                    break;
                case 5:
                    sairSistema();
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    public static void addNovoLivro() {
        if (contador < livro.length) {
            System.out.println("Digite o nome do livro");
            String nomeLivro = scan.nextLine();
            livro[contador] = nomeLivro;

            System.out.println("Digite o nome do autor");
            String nomeAutor = scan.nextLine();
            autor[contador] = nomeAutor;
            contador++;

            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("Não há mais espaço para adições.");
        }
    }

    public static void pesquisaLivro(){
        if(contador ==0){
            System.out.println("Não há livros cadastrados na biblioteca.");
            return;
        }

        System.out.println("Qual o título do livro que deseja pesquisar?");
        String tituloLivro = scan.nextLine();

        boolean encontrado = false;
        for(int i = 0; i < contador; i++){
            if(livro[i].equalsIgnoreCase(tituloLivro)){
                System.out.println("Encontrado!");
                System.out.println("Título: "+livro[i]);
                System.out.println("Autor: "+autor[i]);
                encontrado = true;
                break;
            }
        }

        if(!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void excluirLivro(){
        if(contador ==0){
            System.out.println("Não há livros para serem excluídos.");
            return;
        }

        System.out.println("Digite o nome do livro que deseja excluir.");
        String excluirTitulo = scan.nextLine();
        boolean encontrado = false;

        for(int i = 0; i < contador; i++){
            if(livro[i].equalsIgnoreCase(excluirTitulo)){
                for (int l = i; l < contador - 1; l++){
                    livro[l] = livro[l + 1];
                    autor[l] = autor[l + 1];
                }
                livro[contador-1] = null;
                autor[contador-1] = null;
                contador --;
                System.out.println("Livro excluído com sucesso.");
                encontrado = true;
                return;
            }
        }
        if(!encontrado){
            System.out.println("Livro não encontrado.");
        }
    }

    public static void listarLivro(){
        if(contador == 0){
            System.out.println("Não há livros a serem listados.");
        } else {
            System.out.println("Livro listado.");
            for (int i = 0; i < contador; i++){
                System.out.println("Livro número " +(i + 1)+ ": " +livro[i]+ " | Autor: " +autor[i]);
            }
        }
    }

    public static void sairSistema(){
        System.out.println("Saindo do sistema... Obrigado por usar o Modern Library. Até mais!");
    }
}


