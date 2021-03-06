
/*
 *  @Author Ana Luiza Bazerque
 */

package Country;

/*
* Class of the object country
*
 */
public class Country {
    private String code;
    private String name;
    private Continent continent;
    private float area;
    private String headOfState;

    protected Country(CountryBuilder builder) {

        this.code = builder.code;
        this.name = builder.name;
        this.continent = builder.continent;
        this.area = builder.area;
        this.headOfState = builder.headOfState;
    }

    // this class contains the getter to get info from the db

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public float getArea() {
        return area;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    @Override
    public String toString() {
        return "Country {" +
                "code = '" + code + '\'' +
                ", name = '" + name + '\'' +
                ", continent = " + continent +
                ", area = " + area +
                ", headOfState = '" + headOfState + '\'' +
                '}';
    }

    /* class constructor of a country, implementing the Bulder Design Pattern
    *  this is the class responsible for instantiating the object country
    * */
    public static class CountryBuilder {
        private String code;
        private String name;
        private Continent continent;
        private float area;
        private String headOfState;

        public CountryBuilder(String code, String name, Continent continent, float area, String headOfState) {
            super();
            this.code = code;
            this.name = name;
            this.continent = continent;
            this.area = area;
            this.headOfState = headOfState;

        }

        // these are the setters to set values to the country attributes
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
        /* this method creates an instance of the
        * Country class with the data set in the builder
        * */
        public Country build(){
            return new Country(this);
        }


    }
}


