import com.lab3.DTOs.ExamsEntity;
import com.lab3.Database.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ExamRepositoryTest {
    private EntityManager entityManager;
    private ExamRepository examRepository;

    @BeforeEach
    public void setUp() {
        entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        examRepository = new ExamRepository(entityManager);
    }

    @Test
    public void testGetExams() {
        ExamsEntity exam = new ExamsEntity();
        exam.setName("fdgdfgfd");
        entityManager.persist(exam);
        ExamsEntity found = examRepository.getExamName(exam.getName());
        assert(found.getName().equals(exam.getName()));
    }

}
