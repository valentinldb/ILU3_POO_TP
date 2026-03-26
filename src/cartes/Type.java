package cartes;

public enum Type {
	FEU("feu rouge", "feu vert", "prioritaire"), 
	ESSENCE("panne d'essence", "essence", "citerne"), 
	CREVAISON("crevaison", "roue de secours", "increvable"), 
	ACCIDENT("accident", "réparation", "as du volant");
	
	private Type(String affichageAttaque, String affichageParade, String affichageBotte) {
		msgAttaque = affichageAttaque;
		msgParade = affichageParade;
		msgBotte = affichageBotte;
	}
	
	public String getMsgAttaque() {
		return msgAttaque;
	}
	
	public String getMsgBotte() {
		return msgBotte;
	}
	
	public String getMsgParade() {
		return msgParade;
	}
	
	private final String msgAttaque, msgParade, msgBotte;
}
