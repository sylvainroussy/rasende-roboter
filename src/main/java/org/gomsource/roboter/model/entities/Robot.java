package org.gomsource.roboter.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Robot implements Serializable{

	@GraphId
	private Long id;
	
	@Relationship (type = "HAS_COLOR", direction = "OUTGOING")
	private Set<Color> colors = new HashSet<Color> ();
	
	@Relationship (type = "HAS_POSITION", direction = "OUTGOING")
	private Tile currentPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Tile getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Tile currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}
	
	public void addColor(Color color) {
		this.colors.add(color);
	}
	
	
}
