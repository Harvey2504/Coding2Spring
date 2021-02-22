package DemoCoding2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerId;

	private String playerName;
	private int age;
	private String role;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int playerId, String playerName, int age, String role, Team team) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.age = age;
		this.role = role;
		this.team = team;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonBackReference
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
