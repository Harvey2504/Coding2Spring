package DemoCoding2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamId;

	private String teamName;
	private String location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.LAZY)
	List<Player> player;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int teamId, String teamName, String location, List<Player> player) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.location = location;
		this.player = player;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonManagedReference
	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

}
