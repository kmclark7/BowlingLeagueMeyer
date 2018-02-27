package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="team")

public class Team {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="teamId")
private int teamID;
@Column(name="teamName")
private String teamName;
@Column(name="teamType")
private String teamType;
@Column(name="preferredNight")
private String preferredNight;

public Team() {
	super();
}



public Team(String teamName, String teamType, String preferredNight) {
	super();
	this.teamName = teamName;
	this.teamType = teamType;
	this.preferredNight = preferredNight;
}



public int getTeamID() {
	return teamID;
}
public void setTeamID(int teamID) {
	this.teamID = teamID;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public String getTeamType() {
	return teamType;
}
public void setTeamType(String teamType) {
	this.teamType = teamType;
}
public String getPreferredNight() {
	return preferredNight;
}
public void setPreferredNight(String preferredNight) {
	this.preferredNight = preferredNight;
}
@Override
public String toString() {
	return "TeamDetail [teamID=" + teamID + ", teamName=" + teamName + ", teamType=" + teamType + ", preferredNight="
			+ preferredNight + "]";
}


}
