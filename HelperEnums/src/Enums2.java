class Enums2 {
 
    // Can also have member variables and functions.
    // Really classes!
    enum Country 
    {
        CANADA(35),
        USA(314),
        MEXICO(121);
 
        public final int population;
        
        Country(int population) {
            this.population = population;
        }
 
        public String toString()
        {
            return name() + " (" + population + " Million)";
        }
    };
 
    public static void main(String[] args)
    {
        //        Country c = Country.CANADA;
        //        System.out.println(c);
 
        //  Forbidden:
        // only the ones on the list above
        //        Country d = new Country(111);
 
        for (Country d : Country.values()) {
            System.out.println(d);
        }
 
    }
}