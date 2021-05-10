package iti.hadeer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

// @NoRepositoryBean
public interface UserDao extends PagingAndSortingRepository<User,Integer>{
    public int countByFirstName(String firstName);

    public List<User> findUsersByIdLessThan(int id);

    public User findUserByLastNameIgnoreCase(String lastName);

    @Query("from User u where u.firstName = ?1 and u.lastName = ?2")
    public User findUserByNames(String firstName, String lastName);
}
