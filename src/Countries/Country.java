package Countries;

import Continents.Continent;

public class Country{

    private char name;
    private Continent continent;
    private char code;
    private float area;
    private char headOfState;

    private Country(){}

    private Country(char name, Continent continent, char code, float area, char headOfState) {
        this.name = name;
        this.continent = continent;
        this.code = code;
        this.area = area;
        this.headOfState = headOfState;
    }

    public char getName() {
        return name;
    }

    public Enum getContinent() {
        return continent;
    }

    public char getCode() {
        return code;
    }

    public float getArea() {
        return area;
    }

    public char getHeadOfState() {
        return headOfState;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name=" + name +
                ", continent=" + continent +
                ", code=" + code +
                ", area=" + area +
                ", headOfState=" + headOfState +
                '}';
    }
}

