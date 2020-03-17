package Continents;

public enum Continent {
    AFRICA ("AFRICA"),
    ASIA ("ASIA"),
    ANTARCTICA ("ANTARCTICA"),
    EUROPE ("EUROPE"),
    NORTH_AMERICA ("NORTH_AMERICA"),
    OCEANIA ("OCEANIA"),
    SOUTH_AMERICA ("SOUTH_AMERICA");

    String name;

    Continent(String name){
        name = name;
    }

    public String getName(){
        return name;
    }
    public String toString() {
        return this.name;
    }



}
