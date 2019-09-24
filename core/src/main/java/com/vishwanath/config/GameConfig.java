package com.vishwanath.config;

import com.vishwanath.GuessCount;
import com.vishwanath.MaxNumber;
import com.vishwanath.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.vishwanath")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    @Value("${game.minNumber}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){ return maxNumber; }

    @Bean
    @MinNumber
    public int minNumber(){ return minNumber; }

    @Bean
    @GuessCount
    public int guessCount(){ return guessCount; }
}
