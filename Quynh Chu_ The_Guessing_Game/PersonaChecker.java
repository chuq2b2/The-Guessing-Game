/**
 * @author Steven Bogaerts (starter code)
 */

public class PersonaChecker {

    /***********************************************************************
     * Given code
     ***********************************************************************/

    public static void main(String[] args) {
        //                                          tie     armUp   clothes eating  horns   belt    walks   animal
        Persona bear =    new Persona(0, "Bear",    false,  false,  true,   false,  false,  false,  true,   true);
        Persona tiger =   new Persona(1, "Tiger",   true,   false,  true,   false,  false,  true,   true,   true);
        Persona unicorn = new Persona(2, "Unicorn", false,  true,   false,  false,  true,   false,  true,   true);
        Persona dog =     new Persona(3, "Dog",     false,  false,  false,  false,  false,  false,  true,   true);
        Persona fox =     new Persona(4, "Fox",     true,   true,   true,   false,  false,  true,   true,   true);
        Persona lion =    new Persona(5, "Lion",    true,   true,   true,   false,  false,  false,  true,   true);
        Persona panda =   new Persona(6, "Panda",   false,  false,  false,  true,   false,  false,  true,   true);
        Persona parrot =  new Persona(7, "Parrot",  false,  false,  false,  false,  false,  false,  false,  true);
        Persona shark =   new Persona(8, "Shark",   true,   true,   true,   false,  false,  true,   false,  true);

        PersonaChecker pc = new PersonaChecker();
        
        pc.printAllTests(unicorn);
        
        pc.printAllTests(fox);
        pc.printAllTests(lion);
    }

    public void printAllTests(Persona p) {

        System.out.println("---------- " + p.getName() + " ----------");
        System.out.println("                    has belt: " + hasBelt(p));
        System.out.println("   has clothes and an arm up: " + hasClothesAndArmUp(p));
        System.out.println("       has arm up and no tie: " + hasArmUpAndNoTie(p));
        System.out.println("has tie or belt but not both: " + hasTieOrBeltButNotBoth(p));
    }

    public boolean hasBelt(Persona p){
        return p.getHasBelt();
    }

    public boolean hasClothesAndArmUp(Persona p){
        return p.getHasClothes() && p.getIsArmUp();
    }

    public boolean hasArmUpAndNoTie(Persona p){
        return p.getIsArmUp() && !p.getHasTie();
    }

    public boolean hasTieOrBeltButNotBoth(Persona p){
        return (p.getHasTie() && !p.getHasBelt()) || (!p.getHasTie() && p.getHasBelt());
    }

    /* Expected output for the main above (tests for Cow, Fox, and Lion only):

    ---------- Unicorn ----------
    has belt: false
    has clothes and an arm up: false
    has arm up and no tie: true
    has tie or belt but not both: false
    ---------- Fox ----------
    has belt: true
    has clothes and an arm up: true
    has arm up and no tie: false
    has tie or belt but not both: false
    ---------- Lion ----------
    has belt: false
    has clothes and an arm up: true
    has arm up and no tie: false
    has tie or belt but not both: true    

     */
}
