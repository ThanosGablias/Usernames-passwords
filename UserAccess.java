import java.util.Random;

public class UserAccess {
    //Δήλωση ιδιωτικών μεταβλητών της κλάσης UserAccess
    private String firstName;
    private String lastName;
    private String petsName;

    Random randNums = new Random();

    //Δημιουργία Default Constructor
    public UserAccess() {
        firstName = "";
        lastName = "";
        petsName = "";
    }

    //Δημιούργουμε μέθοδο 'setUserInfo' η οποία δίνει τα στοιχεία του χρήστη
    public void setUserInfo(String firstName, String lastName, String petsName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.petsName = petsName;
    }

    // Μέθοδος για την δημιουργία του ονόματος χρήστη
    public String createUserName() {
        //Δημιουργούμε κενά String
        String part1 = "";
        String part2 = "";
        String part3 = "";

        part1 = firstName.substring(0, 1).toLowerCase(); //Θα χρησιμοποίησουμε την μέθοδο 'substring()' για να πάρουμε
        //το 1ο γράμμα του ονόματος που θα δώσει ο χρήστης και κατόπιν το μετατρέπουμε σε πεζό μέσω της μεθόδου 'toLowerCase()'.

        int extraDigitsToCreate = 0; //Δημιουργούμε μία ακέραια μεταβλητή και την αρχικοποιούμε με μηδέν
        if (lastName.length() >= 8) {
            part2 = lastName.substring(lastName.length() - 8).toLowerCase(); //Θα χρησιμοποίησουμε την μέθοδο 'substring()'
            // για να πάρουμε τα 8 τελευταία γράμματα του επιθέτου και κατόπιν το μετατρέπουμε σε πεζό μέσω της μεθόδου 'toLowerCase()'.
        } else {
            //αλλιώς αν το επίθετο αποτελείται απο λιγότερους απο 8 χαρακτήρες τότε εγχώρησε τον αριθμό των χαρακτήρων που
            //λείπουν μέχρι να γίνουν 8 στην μεταβλητή 'extraDigitsToCreate'
            extraDigitsToCreate = 8 - lastName.length(); //oi aritmhoi poy leipoun mexri na ginoun 8
            part2 = lastName.toLowerCase(); //Μετατρέπει όλους τους χαρακτήρες του επιθέτου σε πεζούς και τους εγχωρεί στην
            // μεταβήτή 'part2'.
        }

        part3 = createRandomDigits(extraDigitsToCreate + 1); //Θέλουμε τουλάχιστον να εκτυπώνει έναν τυχαίο αριθμό

        return part1 + part2 + "_" + part3; //Επιστρέφει το username
    }

    //Μεθόδος για την δημιουργία τυχαίων αριθμών
    private String createRandomDigits(int howMany) {
        String digitsStr = "";

        for (int i = 0; i < howMany; i++) {
            int num = randNums.nextInt(10); //Παράγει τυχαίους αριθμούς απο το 0 μέχρι το 9
            digitsStr += String.valueOf(num); //Μετατρέπει τον τυχαίο αριθμό 'num' σε String για να μπορεί να
            //χρησιμοποιηθεί κατάλληλα στην μέθοδο 'createUserName'. Δηλαδή για να μπορεί να ενσωματωθεί με το
            //υπόλοιπο String.
        }
        return digitsStr; //Επιστρέφει τον τυχαίο αριθμό σε μορφή String
    }

    // Μέθοδος για την δημιουργία του 1ου συνθηματικού
    public String createPassword1() {
        String part1 = "";
        String part2 = "";
        String part3 = "";

        part1 = getRandomStr(firstName);
        part2 = getRandomStr(lastName);
        part3 = getRandomStr(petsName);

        String strall = (part1 + part2 + part3).toLowerCase(); //Εγχωρούμε στην 'strall' τα String, τα κάνουμε συνένωση
        //και κατοπιν μετατρέπουμε όλους τους χαρακτήρες του 'strall' σε πεζούς.

        char[] letters = strall.toCharArray(); //Δημιουργούμε έναν πίνακα χαρακτήρων για να μπορούμε να ελέγχουμε τους χαρακτήρες
        letters[0] = Character.toUpperCase(letters[0]); //Μετατρέπουμε τον 1ο χαρακτήρα σε κεφαλαίο γράμμα

        //Μετατρέπουμε τον τελευταίο χαρακτήρα σε κεφαλαίο γράμμα
        letters[strall.length() - 1] = Character.toUpperCase(letters[strall.length() - 1]);

        return String.valueOf(letters); //Μετατρέπει τον πίνακα χαρακτήρων 'letters' σε String και τον επιστρέφει
    }

    // Μέθοδος για την δημιουργία του 2ου συνθηματικού
    public String createPassword2(){
        String part1 = "";
        String part2 = "";
        String part3 = "";

        part1 = firstName.substring(0,1).toLowerCase();

        int number = randNums.nextInt(101); //Επιλέγουμε έναν τυχαίο αριθμό στο διάστημα από [0,100]

        part2 = String.valueOf(number); //Μετατρέπουμε τον τυχαίο ακέραιο αριθμό 'number' σε String
        part3 = lastName;

        String str = part1 + part2 + part3; //Συνένωση των String σε ένα

        str = str.toLowerCase(); //Μετατρέπουμε όλα τα γράμματα του str σε πεζά

        char[] letters = str.toCharArray(); //Δημιουργούμε έναν πίνακα χαρακτήρων για να μπορούμε να ελέγχουμε τους χαρακτήρες

        //Αντικατάσταση συγκεκριμένων χαρακτήρων με άλλους
        for(int i=0;i<str.length();i++) {
            if (letters[i] == 'a')
                letters[i] = '@';
            else if(letters[i] == 's')
                letters[i] = '$';
            else if(letters[i] == 'l')
                letters[i] = '1';
            else if(letters[i] =='o')
                letters[i] = '0';
        }

        return String.valueOf(letters); //Μετατρέπει τον πίνακα χαρακτήρων 'letters' σε String και τον επιστρέφει
    }

    private String getRandomStr(String name){
      int width = randNums.nextInt(name.length()); //Παίρνουμε τυχαία ένα μέρος της λέξης που θα χρησιμοποιήσουμε
      int startIndex = randNums.nextInt(name.length() - width); // Επόμενο βήμα είναι από που θα ξεκινήσει η λέξη
      String randomStr = name.substring(startIndex,startIndex + width); //Εγχωρουμε στο 'randomStr' το τυχαίο τμήμα του ονόματος
      return randomStr; //Επιστροφή του τυχαίου τμήματος του ονόματος
    }
}
