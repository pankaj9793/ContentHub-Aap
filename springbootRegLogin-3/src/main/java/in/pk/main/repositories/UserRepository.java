package in.pk.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import in.pk.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
    

   
}

