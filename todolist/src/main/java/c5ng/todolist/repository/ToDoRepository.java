package c5ng.todolist.repository;

import c5ng.todolist.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {

    private final EntityManager em;

    public void save(ToDo todo) {
        em.persist(todo);
    }

    public List<ToDo> findAll() {
        return em.createQuery("select t from todos t", ToDo.class)
                .getResultList();
    }

    public ToDo findOne(Long id) {
        return em.find(ToDo.class, id);
    }

    public void updateOne (Long id) {

    }

    public void removeAll() {
        em.createQuery("select t from todos t", ToDo.class)
                .getResultList();

    }

    public void removeOne(Long id) {
        ToDo toDo = em.find(ToDo.class, id);

    }
}
