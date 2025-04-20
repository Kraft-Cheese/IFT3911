public class ConcreteRailwayFactory extends AbstractEntityFactory {

	private static ConcreteRailwayFactory instance;

	public static ConcreteRailwayFactory getInstance() {
		return this.instance;
	}

	private ConcreteRailwayFactory() {
		// TODO - implement ConcreteRailwayFactory.ConcreteRailwayFactory
		throw new UnsupportedOperationException();
	}

}