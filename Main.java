/*
3212019029, Gkamplias Athanasios, Askhsh 3
 */

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        String petsName;

        UserAccess ua = new UserAccess();

        //Χρησιμοποίηση παράθυρων διαλόγου για την ανάγνωση των στοιχείων
        firstName = JOptionPane.showInputDialog("Please Enter your first name: ");
        lastName = JOptionPane.showInputDialog("Please enter your last name: ");
        petsName = JOptionPane.showInputDialog("PLease enter your pets name: ");

        ua.setUserInfo(firstName, lastName, petsName);

        //Χρησιμοποίηση παράθυρων διαλόγου για την εμφάνιση των στοιχείων
        JOptionPane.showMessageDialog(null, ua.createUserName());
        JOptionPane.showMessageDialog(null, ua.createPassword1());
        JOptionPane.showMessageDialog(null, ua.createPassword2());
    }
}
