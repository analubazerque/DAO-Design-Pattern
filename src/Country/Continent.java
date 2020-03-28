package Country;

public enum Continent {

    EUROPE("Europe"),
    ASIA("Asia"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private final String continent;

    //Continent Constructor
    private Continent(String continent) {
        this.continent = continent;
    }

    public static Continent getContinentEnum(String continent){
        if(continent.equalsIgnoreCase("Europe"))
            return Continent.EUROPE;
        else if(continent.equalsIgnoreCase("Asia"))
            return Continent.ASIA;
        else if(continent.equalsIgnoreCase("North America"))
            return Continent.NORTH_AMERICA;
        else if(continent.equalsIgnoreCase("Africa"))
            return Continent.AFRICA;
        else if(continent.equalsIgnoreCase("Oceania"))
            return Continent.OCEANIA;
        else
            return Continent.SOUTH_AMERICA;
    };

    //To String method
    @Override
    public String toString() {
        return this.continent;
    }
}