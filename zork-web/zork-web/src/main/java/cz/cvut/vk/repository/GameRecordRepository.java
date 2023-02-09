package cz.cvut.vk.repository;

import cz.cvut.vk.model.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {

    LinkedList<GameRecord> findAll();

    LinkedList<GameRecord> findByUser_id(Long id);

    GameRecord findById(long id);

}
