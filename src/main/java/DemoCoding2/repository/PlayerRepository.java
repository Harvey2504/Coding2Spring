package DemoCoding2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DemoCoding2.model.Player;
import DemoCoding2.model.Team;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	public List<Player> getPlayerByTeam(Team team);
}
