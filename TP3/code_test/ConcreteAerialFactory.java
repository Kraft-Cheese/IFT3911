public class ConcreteAerialFactory extends AbstractEntityFactory {

	private static ConcreteAerialFactory instance;

	public static ConcreteAerialFactory getInstance() {
		return this.instance;
	}

	private ConcreteAerialFactory() {
		// TODO - implement ConcreteAerialFactory.ConcreteAerialFactory
		throw new UnsupportedOperationException();
	}

}