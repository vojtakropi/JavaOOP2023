package cz.cvut.vk.repository;

import cz.cvut.vk.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRecord, Long> {

    UserRecord findByUsername(String username);
}
