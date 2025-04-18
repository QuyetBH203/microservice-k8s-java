package com.chess.management.player.service;

import com.chess.management.player.dto.PlayerRequest;
import com.chess.management.player.dto.PlayerResponse;
import com.chess.management.player.model.Player;
import com.chess.management.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;


    public PlayerResponse createPlayer(PlayerRequest playerRequest) {

        Player player =  Player.builder()
                .username(playerRequest.username())
                .fullname(playerRequest.fullName())
                .dateOfBirth(playerRequest.dateOfBirth())
                .nationality(playerRequest.nationality())
                .elo(playerRequest.elo())
                .rankElo(playerRequest.rankElo())
                .build();

        Player savedPlayer = playerRepository.save(player);

        return  new PlayerResponse(
                savedPlayer.getUsername(),
                savedPlayer.getDateOfBirth(),
                savedPlayer.getNationality(),
                savedPlayer.getElo(),
                savedPlayer.getRankElo()
        );
    }

    public List<PlayerResponse> getAllPlayers(){
        List<Player> listOfPlayers = playerRepository.findAll();
        return listOfPlayers.stream()
                .map(player -> new PlayerResponse(
                        player.getUsername(),
                        player.getDateOfBirth(),
                        player.getNationality(),
                        player.getElo(),
                        player.getRankElo()))
                .toList();
    }

    public boolean isPlayerAvailable(Long playerId) {
        return playerRepository.existsById(playerId);
    }
}
