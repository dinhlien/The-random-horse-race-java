/**
 * Linh Le
 * CS161
 * Fall 2017
 * Project 2
 */

/**
 *
 * @author Linh
 */
public class Applications {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] names = {"Une", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Onze", "Douze"};
        RaceOrganizer model = new RaceOrganizer(25, 200);
        NameSelector selector = new NameSelector(names, model);
        selector.buildFrame();
        selector.setModel(model);

        //delay loop
        while (!selector.getSelectionFinished()) {
            System.out.print("");
        }

        RaceGUI race = new RaceGUI(model, "Random Horse Race");
        model.runRace();
        selector.resetSelectionFinished();

        //2nd delay loop
        while (!selector.getSelectionFinished()) {
            System.out.print("");
        }
    }
}
