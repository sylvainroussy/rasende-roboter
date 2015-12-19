package org.gomsource.roboter.model.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Robot {

	@GraphId
	private Long id;
	
	@Relationship
	private Color color;
	
	@Relationship
	private Tile currentPosition;
}
