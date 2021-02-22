package DemoCoding2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoCoding2.exception.GameCustomException;
import DemoCoding2.exception.serviceException.GameServiceException;
import DemoCoding2.model.Player;
import DemoCoding2.model.Team;
import DemoCoding2.repository.PlayerRepository;
import DemoCoding2.repository.TeamRepository;
import DemoCoding2.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public boolean addTeam(Team team) throws GameServiceException {
		// TODO Auto-generated method stub
		try {
			teamRepository.save(team);
			return true;
		} catch (Exception e) {
			throw new GameServiceException(e);
		}
	}

	@Override
	public boolean addPlayer(Player player, int teamId) throws GameServiceException {
		// TODO Auto-generated method stub
		try {
			Team team = teamRepository.findById(teamId).get();
			player.setTeam(team);
			playerRepository.save(player);
			return true;
		} catch (Exception e) {
			throw new GameServiceException(e);
		}
	}

	@Override
	public List<Player> getAllPlayerByTeam(String teamName) throws GameServiceException {
		// TODO Auto-generated method stub
		try {
			List<Player> player = playerRepository.getPlayerByTeam(teamRepository.getTeamByTeamName(teamName));
			if (player.isEmpty()) {
				throw new GameCustomException("No Such Player Found");
			}
			return player;
		} catch (GameCustomException e) {
			throw new GameServiceException(e);
		}

	}

	@Override
	public boolean updateTeamById(int teamId, String location) throws GameServiceException {
		// TODO Auto-generated method stub
		try {
			Team temp = teamRepository.findById(teamId).get();
			temp.setLocation(location);
			teamRepository.save(temp);
			return true;

		} catch (Exception e) {
			throw new GameServiceException("Team Not Found");
		}
	}

	@Override
	public boolean deletePlayerById(int playerId) throws GameServiceException {
		// TODO Auto-generated method stub
		try {
			playerRepository.deleteById(playerId);

		} catch (Exception e) {
			throw new GameServiceException(e);
		}

		return true;
	}

}
