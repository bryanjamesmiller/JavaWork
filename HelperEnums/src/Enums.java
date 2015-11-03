class Enums {
 
    // Basic standard use of enums.  It lets you have a finite number
    // of options. Harder to make a typo.  Useful when all possible values
	// for a variable are known, such as Gender {MALE, FEMLAE};
    enum Country { CANADA, USA, MEXICO, BRAZIL };
 
    public static void main(String[] args)
    {
        Country c = Country.CANADA;
        System.out.println(c.ordinal() + ", " + c);
 
        for (Country d : Country.values()) {
            System.out.println(d.ordinal() + ", " + d);
        }
 
        System.out.println(continent(Country.CANADA));
    }
 
    public static String continent(Country c)
    {
        String ans;
        switch (c) {
        case CANADA:
        case USA:
        case MEXICO:
            ans = "NorthAmerica";
            break;
        case BRAZIL:
            ans = "SouthAmerica";
            break;
        default:
            ans = "ERROR";
        }
        return ans;
    }
}