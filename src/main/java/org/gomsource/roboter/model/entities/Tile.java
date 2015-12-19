package org.gomsource.roboter.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Tile implements Serializable{

	@GraphId
	private Long id;
	
	private int posX;
	private int posY;
	
	@Relationship(type = "LINKED_TO", direction = "OUTGOING")
    private Set<Tile> outlets = new HashSet<Tile>(4);
	
	@Relationship(type = "LINKED_TO", direction = "INCOMING")
    private Set<Tile> inlets = new HashSet<Tile>(4);
	
	@Relationship(type = "GOALS", direction = "OUTGOING")
    private Target goal ;
	
	@Relationship (type = "HAS_POSITION", direction = "INCOMING")
	private Robot robot;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Set<Tile> getOutlets() {
		return outlets;
	}

	public void setOutlets(Set<Tile> outlets) {
		this.outlets = outlets;
	}

	public Set<Tile> getInlets() {
		return inlets;
	}

	public void setInlets(Set<Tile> inlets) {
		this.inlets = inlets;
	}

	public Target getGoal() {
		return goal;
	}

	public void setGoal(Target goal) {
		this.goal = goal;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;

        Tile entity = (Tile) o;

        if (!id.equals(entity.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (id == null) ? -1 : id.hashCode();
    }
	
}
