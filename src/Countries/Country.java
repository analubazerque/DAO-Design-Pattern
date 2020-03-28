package Countries;

public abstract class Country {

    protected String name;
    protected Continent continent;
    protected String code;
    protected float area;
    protected String headOfState;

    protected Country() {
    }

    protected Country(CountryBuilder builder) {
        this.name = builder.name;
        this.continent = builder.continent;
        this.code = builder.code;
        this.area = builder.area;
        this.headOfState = builder.headOfState;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent(String continentSt) {
        return Continent.getContinentEnum(continentSt);
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

    public static class CountryBuilder extends Country {
        private String name;
        private Continent continent;
        private String code;
        private float area;
        private String headOfState;

        public CountryBuilder(String name, Continent continent, String code, float area, String headOfState) {
            this.name = name;
            this.continent = continent;
            this.code = code;
            this.area = area;
            this.headOfState = headOfState;

        }

        public CountryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder setContinent(Continent continent) {
            this.continent = continent;
            return this;
        }

        public CountryBuilder setArea(float area) {
            this.area = area;
            return this;
        }

        public CountryBuilder setHeadOfState(String headOfState) {
            this.headOfState = headOfState;
            return this;
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
}


