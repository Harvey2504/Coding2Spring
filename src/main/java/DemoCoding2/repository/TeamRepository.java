package DemoCoding2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DemoCoding2.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
	public Team getTeamByTeamName(String teamName);
}
