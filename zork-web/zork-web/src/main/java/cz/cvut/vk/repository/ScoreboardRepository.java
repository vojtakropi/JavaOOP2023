package cz.cvut.vk.repository;

import cz.cvut.vk.model.ScoreboardRecord;
import cz.cvut.vk.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;

public interface ScoreboardRepository extends JpaRepository<ScoreboardRecord, Long> {

    LinkedList<ScoreboardRecord> findAll();

    LinkedList<ScoreboardRecord> findByName(String username);

}
