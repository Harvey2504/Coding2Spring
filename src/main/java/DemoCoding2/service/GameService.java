package DemoCoding2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import DemoCoding2.exception.serviceException.GameServiceException;
import DemoCoding2.model.Player;
import DemoCoding2.model.Team;

@Service
public interface GameService {

	boolean addTeam(Team team) throws GameServiceException;

	boolean addPlayer(Player player, int teamId) throws GameServiceException;

	List<Player> getAllPlayerByTeam(String teamName) throws GameServiceException;

	boolean updateTeamById(int teamId, String location) throws GameServiceException;

	boolean deletePlayerById(int playerId) throws GameServiceException;

}
