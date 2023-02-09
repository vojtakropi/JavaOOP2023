package cz.cvut.vk.repository;

import cz.cvut.vk.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRecord, Long> {

    UserRecord findByUsername(String username);

}
