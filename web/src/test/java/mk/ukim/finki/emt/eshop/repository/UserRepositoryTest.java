package mk.ukim.finki.emt.eshop.repository;

import mk.ukim.finki.emt.eshop.model.User;
import mk.ukim.finki.emt.eshop.model.enumerations.Role;
import mk.ukim.finki.emt.eshop.model.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.eshop.model.projections.UserProjection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll(){
        List<User> userList=this.userRepository.findAll();
        Assert.assertEquals(2L,userList.size());
    }

    @Test
    public void testFetchAll(){
        List<User> userList=this.userRepository.fetchAll();
        Assert.assertEquals(2L,userList.size());
    }

    @Test
    public void testLoadAll(){
        List<User> userList=this.userRepository.loadAll();
        Assert.assertEquals(2L,userList.size());
    }

    @Test
    public void testProjectionUsernameAndNameAndSurname(){
        UserProjection userProjection=this.userRepository.findByRole(Role.ROLE_USER);
        Assert.assertEquals("nadica.dimitrovska",userProjection.getUsername());
        Assert.assertEquals("Nadica",userProjection.getName());
        Assert.assertEquals("Dimitrovska",userProjection.getSurname());
    }

    @Test
    public void testOptimisticLock(){
        User user1=this.userRepository.findByUsername("nadica.dimitrovska").orElseThrow(()->new UserNotFoundException("nadica.dimitrovska"));
        User user2=this.userRepository.findByUsername("nadica.dimitrovska").orElseThrow(()->new UserNotFoundException("nadica.dimitrovska"));

        user1.setName("nadica1");
        user2.setName("nadica2");

        this.userRepository.save(user1);
        this.userRepository.save(user2);
    }
}
