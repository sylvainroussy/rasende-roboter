package org.gomsource.roboter.model.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Target {
	
	@GraphId
	private long id;
	
	@Relationship(type = "GOALS", direction = "INCOMING")
	private Tile tile;
	
	@Relationship(type = "HAS_COLOR", direction = "OUTGOING")
	private Color color;
}
