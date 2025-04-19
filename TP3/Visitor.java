public interface Visitor {

	/**
	 * 
	 * @param hub
	 */
	String visit(Hub hub);

	/**
	 * 
	 * @param modeTransport
	 */
	String visit(ModeTransport modeTransport);

	/**
	 * 
	 * @param parcours
	 */
	String visit(Parcours parcours);

	/**
	 * 
	 * @param cie
	 */
	String visit(Cie cie);

}