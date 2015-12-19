package org.gomsource.roboter.model.entities;

import java.io.Serializable;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Target implements Serializable{
	
	@GraphId
	private long id;
	
	@Relationship(type = "GOALS", direction = "INCOMING")
	private Tile tile;
	
	@Relationship(type = "FOR_COLOR", direction = "OUTGOING")
	private Color color;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
