package org.gomsource.roboter.services;

import org.gomsource.roboter.model.entities.Color;
import org.gomsource.roboter.model.entities.Robot;
import org.gomsource.roboter.model.entities.Target;
import org.gomsource.roboter.model.entities.Tile;
import org.gomsource.roboter.model.repositories.ColorRepository;
import org.gomsource.roboter.model.repositories.RobotRepository;
import org.gomsource.roboter.model.repositories.TargetRepository;
import org.gomsource.roboter.model.repositories.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarterService {
	
	@Autowired
	RobotRepository robotRepository;
	
	@Autowired
	ColorRepository colorRepository;
	
	@Autowired
	TileRepository tileRepository;
	
	@Autowired
	TargetRepository targetRepository;
	
	
	
		
	
	
	public long [] getRandomCoords ()
	{
		long [] coords = new long [2];
		coords[0]= Math.round(Math.random() * 15) ;
		coords[1] = Math.round(Math.random() * 15) ;
		return coords;
	}

	public void affectColorsToRobots (Color[] colors, Robot[] robots)
	{
		for (int i = 0; i < robots.length; i++) {
			robots[i].addColor(colors[i]);
			robots[i].addColor(colors[4]);
			colors[i].addRobot(robots[i]);
			colors[4].addRobot(robots[i]);
			
			robotRepository.save(robots[i]);
			
			
		}
	}
	
	public Robot [] generateRobots ()
	{
		Robot [] robots = new Robot [4];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot ();			
		}
		return robots;
	}
	
	public Color [] generateColors ()
	{
		final Color [] colors = new Color [5];
		
		String scolors []={"blue","red","yellow","green","all"};
		for (int i = 0; i < scolors.length; i++) {
			colors[i] = new Color ();
			colors[i].setName(scolors[i]);
			colorRepository.save(colors[i]);
		}
		
		return colors;
	}
	
	public Target [] generateTargets ()
	{
		final Target [] targets = new Target [16];
		
		Color blue = colorRepository.findByName("blue");
		Color red = colorRepository.findByName("red");
		Color yellow = colorRepository.findByName("yellow");
		Color green = colorRepository.findByName("green");
		Color all = colorRepository.findByName("all");
		
		targets[0] = this.addTarget(red, 1, 3);
		targets[0] = this.addTarget(green,4, 1);
		targets[0] = this.addTarget(yellow, 5, 5);
		targets[0] = this.addTarget(blue, 3, 6);
		
		return targets;
	}
	
	private Target addTarget (Color color, int posX, int posY)
	{
		Target target = new Target ();
		Tile tile = loadTile (posX, posY);
		target.setTile(tile);
		tile.setGoal(target);
		target.setColor(color);
		color.addGoal(target);
		return targetRepository.save(target);
	}
	
	
	public Tile loadTile (int posX, int posY)
	{
		Tile t = tileRepository.findByPosXAndPosY(posX, posY);
		return t;
	}
	
	public static void main (String args[])
	{
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		System.out.println(Math.round(Math.random() * 16));
		
	}
}
