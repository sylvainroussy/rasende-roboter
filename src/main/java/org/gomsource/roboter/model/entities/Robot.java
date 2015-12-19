package org.gomsource.roboter.model.entities;

import java.io.Serializable;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Robot implements Serializable{

	@GraphId
	private Long id;
	
	@Relationship (type = "HAS_COLOR", direction = "OUTGOING")
	private Color color;
	
	@Relationship (type = "HAS_POSITION", direction = "OUTGOING")
	private Tile currentPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Tile getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Tile currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
}
