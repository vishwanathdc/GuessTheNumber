package com.vishwanath.console;

import com.vishwanath.config.AppConfig;
import com.vishwanath.Game;
import com.vishwanath.MessageGenerator;
import com.vishwanath.NumberGenerator;
import com.vishwanath.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Welcome to the number game");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}
