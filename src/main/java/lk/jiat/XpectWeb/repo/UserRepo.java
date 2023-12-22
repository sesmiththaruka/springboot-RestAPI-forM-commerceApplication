package lk.jiat.XpectWeb.repo;

import lk.jiat.XpectWeb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM USER WHERE firebase_user_id = ?1",nativeQuery = true)
    User getUserByFirebaseUserId(String userId);
}
