package Countries;

import Continents.Continent;

public class Country{

    private String name;
    private Continent continent;
    private String code;
    private float area;
    private String headOfState;

    Country(){}

    public Country(String name, Continent continent, String code, float area, String headOfState) {
        this.name = name;
        this.continent = continent;
        this.code = code;
        this.area = area;
        this.headOfState = headOfState;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getCode() {
        return code;
    }

    public float getArea() {
        return area;
    }

    public String getHeadOfState() {
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

