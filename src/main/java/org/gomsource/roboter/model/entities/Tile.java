package org.gomsource.roboter.model.entities;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Tile {

	@GraphId
	private long id;
	
	private int posX;
	private int posY;
	
	@Relationship(type = "LINKED_TO", direction = "OUTGOING")
    private Set<Tile> outlets = new HashSet<Tile>(4);
	
	@Relationship(type = "LINKED_TO", direction = "INCOMING")
    private Set<Tile> inlets = new HashSet<Tile>(4);
	
	@Relationship(type = "GOALS", direction = "OUTGOING")
    private Target goal ;
	
	
	
}
