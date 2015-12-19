package org.gomsource.roboter.model.entities;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Color {

	@GraphId
	private Long id;
	
	private String name;
	
	@Relationship
	private Set<Robot> robots = new HashSet<Robot> ();
}
