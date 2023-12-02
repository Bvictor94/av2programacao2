package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import orm.modelo.Aluno;

public class ListarAlunos {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlunoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Aluno> alunos = entityManager.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();

        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
            System.out.println("Naturalidade: " + aluno.getNaturalidade());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("-----------------------");
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
