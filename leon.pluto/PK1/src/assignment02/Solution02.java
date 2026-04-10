package assignment02;
public class Solution02 {



public static void main(String[] args)
{
    //Task 1: a && b
    System.out.println("\n---------Task 1---------");
    boolean a = false;
    boolean b = false;
    System.out.println("a-" +a + " && " + "b-" + b + " = " + andGate(a, b)); 

    //Task 2: BMI  
    System.out.println("\n---------Task 2---------");
    double kg = 80;
    double height = 1.80;
    System.out.println("Der BMI mit dem Gewicht: ["+ kg +" Kg]" + " und der Körpergröße ["+ height +"m]" + " liegt bei"+  ": " + BMI(kg, height));  

    //Task 3: Bet-Check
    System.out.println("\n---------Task 3---------");
    
    System.out.println("[Determined] - Bet-Score = "+soccerBet(3, 3, 3, 3)); // home, guest, betHome, betGuest

    //-----------------------
    //----Task 3 (Random)----
    task3(args);
    //-----------------------

    //Task 4
    System.out.println("\n---------Task 4---------");
    int day = 2;
    int month = 7;
    int year = 2005;
    System.out.println(getWeekDay(day, month, year));
}






/**
 * 
 * @param switchA - The first boolean input (True / False)
 * @param switchB - The second boolean input (True / False)
 * @return  switchA && switchB 
 */
public static boolean andGate(boolean switchA, boolean switchB)
{
    if (switchA == false){    // False, wenn einer von beiden bzw beide false sind.
        return false;
    }
    else if (switchB == false){
        return false;
    }
    else if (switchA == switchB){
        return true;
    }
    else {
        return false;
    }
}





/**
 * 
 * @param kg - Weight in Kilogramms
 * @param height - Height in Meters
 * @return - BMI - Body Mass Index
 */
    public static String BMI(double kg, double height) // Task 1
{
    double bmi = kg / (height * height);
    String BMI = "Null";
    if (bmi <= 18.5){
        BMI = "underweight";
    }
   else if (bmi <=25){
        BMI = "normal";
   }
   else if (bmi <=30){
        BMI = "overweight";
    }
    else if (bmi >30){
        BMI = "obese";
    }
    //System.out.println(BMI);
    return BMI;
}

//---------------------------------------------------------------------------
// (Code snipped added but not to main)
// "task3" = soccerBet with random outcome
public static void task3(String[] args){
    int home = (int) (Math.random() * 5);
    int guest = (int) (Math.random() * 5);
    int homeBet = 2;
    int guestBet = 3;
    System.out.println("[Random]     - Result: " + home + ":" + guest +
    " bet: " + homeBet + ":" + guestBet +
    " points scored: " + soccerBet(home, guest, homeBet, guestBet));
}
//---------------------------------------------------------------------------

/**
 * 
 * @param home - Punkte die "Home" - Team erziehlt hat
 * @param guest - Punkte die "Guest" - Team erziehlt hat
 * @param betHome - Score der gewettet wurde für das Team "Home"
 * @param betGuest - Score der gewettet wurde für das Team "Guest"
 * @return  - Vergleich der Wetten: Richtiger Punktestand = 3
 *                                  Richtiges Team gewonnen = 1
 *                                  Wette ist falsch  = 0
 */
public static int soccerBet(int home , int guest, int betHome, int betGuest)
{
    
if( home == betHome && guest == betGuest){ 
    return 3;                                           // Gleicher Score
    }
    else if (home == guest && betHome == betGuest){     // Bet und tatsächlich Gleichstand
        return 1;
    }
    else if (home > guest && betHome > betGuest){       // Gleiches Team
        return 1;
    }
    else if (home < guest && betHome < betGuest){        // Gleiches Team
        return 1;
    }
    else{                                           // Nichts richtig
        return 0;
}

}
/**
 * 
 * @param day - Tag eines Datums
 * @param month - Monat eines Datums
 * @param year - Jahr eines Datums
 * @return  -  Wochentag des Datums                       
 */
public static String getWeekDay(int day, int month, int year){          // Vorgegebene Rechnung zur Aufteilung in Wochentage
    if (month <=2){
        month = month + 10;
        year = year -1;
    }
    else {
        month = month -2;
    }

    int c = year / 100;
    int y = year % 100;

    int h = (((26 * month -2)/10)+ day + y + y/4 + c/4 - 2 * c) % 7;
    if (h < 0 )
    {
        h = h+7;
    }

    switch (h) {                    // Zuweisung des Wochentages zum ausgerechneten Wert.
        case 0:
            return "Sunday";
        case 1:
            return "Monday";
        case 2:
            return "Tuesday";
        case 3:
            return "Wednesday";
        case 4:
            return "Thursday";
        case 5:
            return "Friday";
        case 6:
            return "Saturday";
        default:
            return "ERROR";
    }
}
}
//Test