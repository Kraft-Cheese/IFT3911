public class ConcreteNavalFactory extends AbstractEntityFactory {

	private static ConcreteNavalFactory instance;

	public static ConcreteNavalFactory getInstance() {
		return this.instance;
	}

	private ConcreteNavalFactory() {
		// TODO - implement ConcreteNavalFactory.ConcreteNavalFactory
		throw new UnsupportedOperationException();
	}

}