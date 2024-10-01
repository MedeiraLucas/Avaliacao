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
            // Aqui vamos imprimir as opções para iniciar os cadastros.
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
                System.out.println("Opção Invalida");
                scanner.nextLine();
                continue;
            }

            switch (opt) {
                case 1: // aqui iremos fornecer as informacoes
                    System.out.println("Digite o id do Professor: ");
                    int idProfessor = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nomeProfessor = scanner.next();
                    Professor professor = new Professor(idProfessor, nomeProfessor);
                    professores.add(professor);
                    break;

                case 2:
                    System.out.println("Digite o id do curso: ");
                    int idCurso = scanner.nextInt();
                    System.out.println("Digite o nome do curso: ");
                    String nomeCurso = scanner.next();
                    System.out.println("Digite a carga horária do curso: ");
                    int cargaHoraria = scanner.nextInt();
                    Curso curso = new Curso(idCurso, nomeCurso, cargaHoraria);
                    cursos.add(curso);
                    break;

                case 3:
                    System.out.println("Digite o id do Aluno: ");
                    int idAluno = scanner.nextInt();
                    System.out.println("Digite o nome do Aluno: ");
                    String nomeAluno = scanner.next();
                    System.out.println("Digite a sua data de Nascimento: ");
                    String dataNascimento = scanner.next();
                    System.out.println("Digite o CPF: ");
                    String cpf = scanner.next();
                    Aluno aluno = new Aluno(idAluno, nomeAluno, dataNascimento, cpf);
                    alunos.add(aluno);
                    break;

                case 4:
                    for (Professor prof : professores) {
                        System.out.println("Professor: " + prof.getNome());
                    }
                    break;

                case 5:
                    for (Curso cur : cursos) {
                        System.out.println("Curso: " + cur.getNome() + " - Carga Horária: " + cur.getCargaHoraria());
                    }
                    break;

                case 6:
                    for (Aluno al : alunos) {
                        System.out.println("Aluno: " + al.getNome() + " - Data de Nascimento: " + al.getDataNascimento()
                                + " - CPF: " + al.getCpf());
                    }
                    break;

                case 7:
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

class Professor {
    private int id;
    private String nome;

    public Professor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;

    public Curso(int id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}

class Aluno {
    private int id;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Aluno(int id, String nome, String dataNascimento, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}
