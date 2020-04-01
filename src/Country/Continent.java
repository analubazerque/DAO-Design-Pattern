
/*
 *  @Author Ana Luiza Bazerque
 */

package Country;

// enum with the only option valid for continent

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

    /* this method was a work around the fact that
    *  there was a problem and someone was able to
    * add an empty entry in the Continent and the valueOf()
    * method stopped working for a while.
    * I only left it there for the sake of problem solving skills.
    * */

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