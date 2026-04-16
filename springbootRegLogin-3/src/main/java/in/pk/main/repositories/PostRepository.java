package in.pk.main.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import in.pk.main.entities.Post;
import in.pk.main.entities.User;


public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);

}
