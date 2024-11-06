import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cadastro {

    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/cadastro";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

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
                scanner.nextLine(); 
                continue;
            }

            switch (opt) {
                case 1:
                    try { // Cadastro de professor
                        System.out.println("Digite o nome: ");
                        String nomeProfessor = scanner.next();
                        System.out.println("Digite o departamento: ");
                        String departamento = scanner.next();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Professor (nome, departamento) VALUES ('" + nomeProfessor + "','" + departamento + "')");
                        if (!sql) {
                            System.out.println("Cadastro realizado com sucesso.");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {  // Cadastro de curso
                        System.out.println("Digite o nome do curso: ");
                        String nomeCurso = scanner.next();
                        System.out.println("Digite a carga horária do curso: ");
                        int cargaHoraria = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Curso (curso, cargaHoraria) VALUES ('" + nomeCurso + "', '" + cargaHoraria + "')");
                        if (!sql) {
                            System.out.println("Cadastro realizado com sucesso.");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {  // Cadastro de aluno
                        System.out.println("Digite o nome do Aluno: ");
                        String nomeAluno = scanner.next();
                        System.out.println("Digite a data de Nascimento (yyyy-mm-dd): ");
                        String dataNascimento = scanner.next();
                        System.out.println("Digite o CPF: ");
                        String cpf = scanner.next();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Aluno (nome, cpf, data_nascimento) VALUES ('" + nomeAluno + "', '" + cpf + "', '" + dataNascimento + "')");
                        if (!sql) {
                            System.out.println("Cadastro realizado com sucesso.");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM Professor;");
                        while (sql.next()) {
                            System.out.println("Nome: " + sql.getString("nome") + ", Departamento: " + sql.getString("departamento"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM Curso;");
                        while (sql.next()) {
                            System.out.println("Curso: " + sql.getString("curso") + ", Carga Horária: " + sql.getInt("cargaHoraria"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM Aluno;");
                        while (sql.next()) {
                            System.out.println("Nome: " + sql.getString("nome") + ", Data de Nascimento: " + sql.getString("data_nascimento") + ", CPF: " + sql.getString("cpf"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
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
