package Application;

// iterator interface
public interface Iterator {

	void add(Entity e);

	Entity next();

	Entity previous();

	Entity getCurrent();

	void remove(Entity e);

	Entity first();

	boolean isDone();

}