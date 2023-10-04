package com.insper.partida.equipe;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.insper.partida.game.Game;
import com.insper.partida.game.GameRepository;
import com.insper.partida.game.GameService;
import com.insper.partida.game.dto.GameReturnDTO;

@ExtendWith(MockitoExtension.class)
public class GameServiceTests {

    @InjectMocks
    GameService gameService;

    @Mock
    GameRepository gameRepository;

    @Test
    void getGameByIdentifier(){
        Game game = getGame();
        Mockito.when(gameRepository.findByIdentifier("teste")).thenReturn(game);
        GameReturnDTO response = gameService.getGame("teste");
        Assertions.assertEquals(game.getIdentifier(),response.getIdentifier());
    }

    private static Game getGame() {
        Game game = new Game();
        game.setIdentifier("teste");
        game.setHome("kCC");
        game.setAway("Miami");
        return game;
    }
}
