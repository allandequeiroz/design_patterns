package udemy.casestudy.rendering;

import udemy.casestudy.documentstructure.improved.WorldObject;

public class DetailedRenderer implements WorldObjectRenderer{

	@Override
	public void render(WorldObject object) {
		System.out.println("I'm rendering with the detailed image renderer");
		
	}

}
