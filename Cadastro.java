import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {

    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();

        do {
            // Opções de cadastro
            System.out.println("Opções: ");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Curso");
            System.out.println("3. Cadastrar Aluno");
            System.out.println("4. Listar Professores");
            System.out.println("5. Listar Cursos");
            System.out.println("6. Listar Alunos");
            System.out.println("7. Sair");

            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção Inválida");
                scanner.nextLine(); // Limpa a entrada
                continue;
            }

            switch (opt) {
                case 1: // Cadastro de professor
                    System.out.println("Digite o id do Professor: ");
                    int idProfessor = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nomeProfessor = scanner.next();
                    professores.add(new Professor(idProfessor, nomeProfessor));
                    break;

                case 2: // Cadastro de curso
                    System.out.println("Digite o id do curso: ");
                    int idCurso = scanner.nextInt();
                    System.out.println("Digite o nome do curso: ");
                    String nomeCurso = scanner.next();
                    System.out.println("Digite a carga horária do curso: ");
                    int cargaHoraria = scanner.nextInt();
                    cursos.add(new Curso(idCurso, nomeCurso, cargaHoraria));
                    break;

                case 3: // Cadastro de aluno
                    System.out.println("Digite o id do Aluno: ");
                    int idAluno = scanner.nextInt();
                    System.out.println("Digite o nome do Aluno: ");
                    String nomeAluno = scanner.next();
                    System.out.println("Digite a data de Nascimento: ");
                    String dataNascimento = scanner.next();
                    System.out.println("Digite o CPF: ");
                    String cpf = scanner.next();
                    alunos.add(new Aluno(idAluno, nomeAluno, dataNascimento, cpf));
                    break;

                case 4: // Listar professores
                    for (Professor prof : professores) {
                        System.out.println("Professor: " + prof.getNome());
                    }
                    break;

                case 5: // Listar cursos
                    for (Curso cur : cursos) {
                        System.out.println("Curso: " + cur.getNome() + " - Carga Horária: " + cur.getCargaHoraria());
                    }
                    break;

                case 6: // Listar alunos
                    for (Aluno al : alunos) {
                        System.out.println("Aluno: " + al.getNome() + " - Data de Nascimento: " + al.getDataNascimento() + " - CPF: " + al.getCpf());
                    }
                    break;

                case 7: // Sair do programa
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opt != 7);

        scanner.close();
    }
}
