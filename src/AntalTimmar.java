public class AntalTimmar {

    public static void main(String[] args) {


//3. Skapa ett program som läser in antal timmar, beräknar och skriver ut hur mycket det
//blir omvandlat till minuter resp sekunder.

        int hours = 2; // Antal timmar!
        int minutes = hours * 60; // Vi beräknar antalet minuter genom att gångra timmarna med.
        int seconds = hours * 3600; // Vi beräknar antalet sekunder igenom att gångra timmarna med 3600.

        System.out.println(hours + " timmar är " + minutes + " minuter och " + seconds + " sekunder");
    }
}

