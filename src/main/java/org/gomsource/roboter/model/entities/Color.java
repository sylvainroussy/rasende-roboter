package org.gomsource.roboter.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Color implements Serializable {

	@GraphId
	private Long id;
	
	private String name;
	
	@Relationship (type = "HAS_COLOR", direction = "INCOMING")
	private Set<Robot> robots = new HashSet<Robot> ();
	
	@Relationship(type = "FOR_COLOR", direction = "INCOMING")
	private Set<Target> goals = new HashSet<Target> ();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Robot> getRobots() {
		return robots;
	}

	public void setRobots(Set<Robot> robots) {
		this.robots = robots;
	}
	
	public void addRobot (Robot robot)
	{
		this.robots.add(robot);
	}

	public Set<Target> getGoals() {
		return goals;
	}

	public void setGoals(Set<Target> goals) {
		this.goals = goals;
	}
	
	public void addGoal (Target target)
	{
		this.goals.add(target);
	}
	
	
	
}
