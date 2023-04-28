public class EmailApplication {
    private String firstname;
    private String lastname;
    private String company;
    private String department;
    private String email;
    private String alternateEmail;
    private int mailboxCapacity;
    private String password;
    private void generateEmail() {
        if (department.equals("")) {
            email = firstname + "." + lastname + "@" + company + ".com";
        }
        else {
            email = firstname + "." + lastname + "@" + department + "." + company + ".com";
        }
    }
    private void generatePassword() {
        int[] rangeAZ = {65, 90}; // ascii range A-Z
        int[] rangeaz = {97, 122}; // ascii range a-z
        int[] range09 = {48, 57}; // ascii range 0-9
        int[] rangeSpecialSymbols = {33, 47}; // ascii range !-/

        int passwordLength = (int)(Math.random()*(9) + 8); // min length - 8, max length - 16
        for (int i = 0; i < passwordLength; ++i) {
            int option = (int)(Math.random()*(4) + 1);
            int number = switch (option) {
                case 1 -> (int) (Math.random() * (rangeAZ[1] - rangeAZ[0] + 1) + rangeAZ[0]);
                case 2 -> (int) (Math.random() * (rangeaz[1] - rangeaz[0] + 1) + rangeaz[0]);
                case 3 -> (int) (Math.random() * (range09[1] - range09[0] + 1) + range09[0]);
                default ->
                        (int) (Math.random() * (rangeSpecialSymbols[1] - rangeSpecialSymbols[0] + 1) + rangeSpecialSymbols[0]);
            };
            password += (char)number;
        }
    }
    EmailApplication(String ... input) {
        int len = input.length;
        if (len > 2) {
            firstname = input[0];
            lastname = input[1];
            company = input[2];
            password = "";

            if (len == 4) {
                department = input[3];
            }
            else {
                department = "";
            }
            generateEmail();
            generatePassword();
        }
        else {
            System.out.println("Too few argumets.");
        }
    }
    public void setPassword(String password) {
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"; // RegEx validator
        if (password.matches(regexPassword)) { this.password = password; }
        else { System.out.println("Password is not valid."); }
    }
    public void setMailboxCapacity(int capacity) {
        mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String email) {
        String domain = this.company + ".com"; // company.com (takes company from class attribute COMPANY)
        String regexEmail = "^[\\w.%+-]+@(?:"
                + this.department.replace(".", "\\.") + "\\.)?" // replace "department" with the value of department
                + domain.replace(".", "\\.") + "$"; // RegEx validator
        if (email.matches(regexEmail)) { alternateEmail = email; }
        else { System.out.println("Email is not valid."); }
    }
    public void getName() {
        System.out.println("Name: " + firstname + " " + lastname);
    }
    public void getEmail() {
         System.out.println("Email: " + email + "Alternate email: " + alternateEmail);
    }
    public void getMailboxCapacity() {
        System.out.println("Mailbox capacity: " + mailboxCapacity);
    }
    public void printInfo(){
        System.out.println("Name: " + firstname);
        System.out.println("Surname: " + lastname);
        System.out.println("Company: " + company);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
        System.out.println("Alternate Email: " + alternateEmail);
        System.out.println("Mailbox Capacity: " + mailboxCapacity);
        System.out.println("Password: " + password);
    }
}
