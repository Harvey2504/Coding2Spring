package DemoCoding2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DemoCoding2.exception.serviceException.GameServiceException;
import DemoCoding2.model.Player;
import DemoCoding2.model.Team;
import DemoCoding2.service.impl.GameServiceImpl;

@RestController
@RequestMapping(path = "/game")
public class GameController {
	static String msg = "";

	@Autowired
	public GameServiceImpl service;

	@PostMapping("/add/team")
	public ResponseEntity<?> addTrack(@RequestBody Team team) {
		try {
			boolean flag = service.addTeam(team);
			if (flag) {
				return new ResponseEntity<>("Team Created Successfully", HttpStatus.CREATED);
			}

		} catch (GameServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add/player/{teamId}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player, @PathVariable Integer teamId) {
		try {
			boolean flag = service.addPlayer(player, teamId);
			if (flag) {
				return new ResponseEntity<>("Player Created Successfully", HttpStatus.CREATED);
			}

		} catch (GameServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all/{teamName}")
	public ResponseEntity<?> getPlayerDetailsByTeam(@PathVariable String teamName) {
		try {
			return new ResponseEntity<>(service.getAllPlayerByTeam(teamName), HttpStatus.OK);
		} catch (GameServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update/{teamId}")
	public ResponseEntity<?> updateTeam(@RequestBody String location, @PathVariable Integer teamId) {
		try {
			if (service.updateTeamById(teamId, location)) {
				return new ResponseEntity<>("Updated Succesfully", HttpStatus.OK);
			}

		} catch (GameServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/player/{playerId}")
	public ResponseEntity<?> deleteTrack(@PathVariable Integer playerId) {
		try {
			if (service.deletePlayerById(playerId)) {
				return new ResponseEntity<>("Deleted Player Successfully", HttpStatus.OK);
			}

		} catch (GameServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

}
