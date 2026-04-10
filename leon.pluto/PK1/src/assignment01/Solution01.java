package assignment01;

public class Solution01 {
    public static void main(String[] args) {

        task1();

        task2();
        
        task3();

        task4();

        task5();

        task6();
    }

    

        public static void task1()
        {
        //Print an Easterbunny
        System.out.println(" \nAufgabe 1 Easterbunny:");
        System.out.println(" \n (\\ /) ");
        System.out.println(" (`.´)"); 
        System.out.println("(\")(\")*");
        }


        public static void task2()
        {
            System.out.println(" \nAufgabe 2 Name, declare, and initialize:");
        // Aufgabe 2
        // - Benennen - Deklarieren - Initialisieren von folgenden Statements:
        // 1. How many students attend PK1?
        // 2. How many students are enrolled at the University?
        // 3. How many people are living in the European Union?
        // 4. How many people are living on Earth?
        // 5. How many semesters are you planning for your entire studies?
        // 6. With which letter does your last name start with?
        // 7. What was your final average grade in school?
        // 8. Is the current year a leap year?

        // Bennenen:
        // 1. students_in_PK1 - Students in PK1             ->           115  byte /   1 byte:
        // 2. students_at_UNI - Students at UNI             ->        10 500  short /  2 bytes:
        // 3. people_in_EU -  People living in EU        ->   448 000 000  int /    4 bytes:
        // 4. people_at_Earth  -  People living on Earth     -> 8 000 000 000  long /   8 bytes:
        // 5. smester_to_go   -  Semester to go             -> 7              byte /   1 byte:
        // 6. last_name_starting_latter  -  Last name starting Latter  -> P              char /   2 bytes:
        // 7. average_grade_in_school  -  Average Grade in School    -> 2.6            float /  4 bytes:    
        // 8. current_year_leap_year  -  Current year leap year?    -> true           boolean/ 1 byte:


        // Deklarieren:
        boolean current_year_leap_year;
        byte smester_to_go, students_in_PK1;
        char last_name_starting_latter;
        short students_at_UNI;
        int people_in_EU;
        float average_grade_in_school;
        long people_at_Earth;

        // Initialisieren
        students_in_PK1 = 115;
        students_at_UNI = 10500;
        people_in_EU = 448000000;
        people_at_Earth = 8000000000l;
        smester_to_go = 7;
        last_name_starting_latter = 'P';
        average_grade_in_school = 2.6f;
        current_year_leap_year = true;

        // Ausgeben (optional)
        System.out.println("\n" + students_in_PK1);
        System.out.println(students_at_UNI);
        System.out.println(people_in_EU);
        System.out.println(people_at_Earth);
        System.out.println(smester_to_go);
        System.out.println(last_name_starting_latter);
        System.out.println(average_grade_in_school);
        System.out.println(current_year_leap_year);
        }

        public static void task3()
        {
            System.out.println(" \nAufgabe 3 Cut Number:");
            // Name: value
            //Deklaration
            double value;           
            double valueKurz;
            double ergebnis;
            int umrechnung;

            // Initialisierung
            value = 2.046234183;

            // Umrechnung
            valueKurz  = value * 100;    // Damit die beiden ersten Nachkommastellen gespeichert werden können wärend der Rest im späteren durch das umändern zum Int. wegfällt.
            umrechnung = (int) valueKurz; // Data type Casting
            ergebnis   = (double) umrechnung / 100;

            System.out.println("\nOriginal Zahl ist: " + value);
            System.out.println("Zahl bis auf die Letzten 2 Nachkommastellen abgeschnitten ist: " + ergebnis);
        }

        public static void task4()
        {
            System.out.println(" \nAufgabe 4 Logik Operatoren Schaltung:");
            boolean leuchten;    // leuchtet die Lampe ja, nein?
            boolean schaltungA = false;  // Schalter A --> hier wie in Schaltung auf Bild
            boolean schaltungB = false;  // Schalter B --> hier wie in Schaltung auf Bild
            boolean schaltungC = false;  // Schalter C --> hier wie in Schaltung auf Bild

            leuchten = (schaltungA || schaltungB) && schaltungC;       // Parrallel Sschaltung + Reihenschaltung --> Entweder A oder B. Und C muss geschlossen sein, damit die lampe leuchten kann.
            String status;                                                           //     A    ||    B     &&       C
            if (leuchten){                                             
                status = "Lampe leuchtet";  
                
            }
            else{
                status = "Lampe leuchtet nicht";
            }
            System.out.println(status);

        }


        public static void task5()
        {
            System.out.println(" \nAufgabe 5 Dimensionen der Dose:");
            //Deklarierung
            double lenght;
            double width;
            double pi;
            double diameter;
            double baseArea;
            double curvedSurfaceArea;
            double overallArea;
            double capacity;

            //Initialisierung
            lenght = 2.5;
            width = 3.5;
            pi = 3.141592;

            // Diameter of the Base: Lenght / Pi         ---> (diameter)
            diameter = lenght / pi;

            // The area of the base: (Diameter / 2)^2    ---> (baseArea)
            baseArea = pi * ((diameter / 2) * (diameter / 2));

            // The curved surface area: lenght * width   ---> (curvedSurfaceArea)
            curvedSurfaceArea = lenght * width;

            // The overall area of the can: 2 * baseArea + curvedSurfaceArea ---> (overallArea)
            overallArea = 2 * baseArea + curvedSurfaceArea;

            // The capacity of the can: baseArea * width ---> (capacity)
            capacity = baseArea * width;

            System.out.println("\nlenght is: " + lenght + "cm");
            System.out.println("width is: " + width + "cm");
            System.out.println("pi is: " + pi);
            System.out.println("diameter is: " + diameter + "cm");
            System.out.println("baseArea is: " + baseArea + "cm²");
            System.out.println("curvedSurfaceArea is: " + curvedSurfaceArea + "cm²");
            System.out.println("overallArea is: " + overallArea + "cm²");
            System.out.println("capacity is: " + capacity + "cm³");
        }







        public static void task6()
        {
            System.out.println(" \nAufgabe 6 converts a given number:");
            // Deklarierung
            int inputseconds;
            int years;
            int days;
            int hours;
            int minutes;
            int seconds;
            int verbleibend;

            //Initialisierung
            inputseconds = 100000000;

            years = inputseconds / (365 * 24 * 60 * 60);            // Rechnung wieviele Jahre es sind
            verbleibend = inputseconds % (365 * 24 * 60 * 60);      // Rest-bestimmung, initialisierung von verbleibenden Sekunden

            days = verbleibend / (24 * 60 * 60);                    // Rechnung wieviele Tage es sind
            verbleibend %= (24 * 60 * 60);                          // Erneute Rest-bestimmung und neu-initialisierung von verbleibenden Sekunden

            hours = verbleibend / (60 * 60);                        // -----..----- Stunden
            verbleibend %= (60 * 60);                               // -----..-----

            minutes = verbleibend / 60;                             // -----..----- Minuten
            seconds = verbleibend % 60;                             // -----..----- Sekunden

            System.out.println("\nYears: " + years);                  // Ausgabe
            System.out.println("Days: " + days);
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + minutes);
            System.out.println("Seconds: " + seconds);
        }
}        
