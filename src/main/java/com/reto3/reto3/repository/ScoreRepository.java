package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Score;
import com.reto3.reto3.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getScoreAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScoreId(int id) {
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }
}
