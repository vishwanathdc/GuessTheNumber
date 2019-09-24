package com.vishwanath;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{

    // == fields ==
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) return "Congrats you guessed it correct. Number was " + game.getNumber();
        else if(game.isGameLOst()) return "You lose. Number was " + game.getNumber();
        else if(!game.isValidNumberRange()) return "invalid number range";
        else if(game.getRemainingChances() == game.getGuessCount()) return "what is your first guess?";
        else{
            String direction = "lower";
            if(game.getGuess() < game.getNumber())
                direction = "higher";
            return direction + "! you have " + game.getRemainingChances() + " guesses left";
        }
    }
}
