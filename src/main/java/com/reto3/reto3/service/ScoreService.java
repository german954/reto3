package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Score;
import com.reto3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScoreAll() {
        return scoreRepository.getScoreAll();
    }

    public Optional<Score> getScoreId(Integer scoreId) {
        return scoreRepository.getScoreId(scoreId);
    }

    public Score save(Score score) {

        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> e = scoreRepository.getScoreId(score.getIdScore());
            if (e.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }

        }

    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> e = scoreRepository.getScoreId(score.getIdScore());
            if (!e.isEmpty()) {
                if (score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null && score.getStars() >= 0 && score.getStars() <= 5) {
                    e.get().setStars(score.getStars());
                }
                scoreRepository.save(e.get());
                return e.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    /*public boolean deleteScore(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }*/
}


