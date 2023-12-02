package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;
import orm.modelo.Aluno;

public class AlunoDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AlunoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("AlunoPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void adicionarAluno(Aluno aluno) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(aluno);
        transaction.commit();
    }

    public void fecharConexao() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do aluno:");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF do aluno:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a data de nascimento do aluno:");
        String dataNascimento = scanner.nextLine();

        System.out.println("Digite a naturalidade do aluno:");
        String naturalidade = scanner.nextLine();

        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setNaturalidade(naturalidade);
        aluno.setEndereco(endereco);

        alunoDAO.adicionarAluno(aluno);

        System.out.println("Aluno cadastrado com sucesso!");

        alunoDAO.fecharConexao();
    }
}
