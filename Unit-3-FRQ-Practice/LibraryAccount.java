public class LibraryAccount {
    private String studentName;
    private int studentID;
    private int booksCheckedOut;
    private boolean hasOutstandingFees;
    private boolean accountSuspended;

        public LibraryAccount(String studentName, int studentID, int booksCheckedOut, boolean hasOutstandingFees, boolean accountSuspended) {
            //LibraryAccount myAccount = new LibraryAccount();
            this.studentName = studentName;
            this.studentID = studentID;
            this.booksCheckedOut = booksCheckedOut;
            this.hasOutstandingFees = hasOutstandingFees;
            this.accountSuspended = accountSuspended;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            else if (other == null || !(other instanceof LibraryAccount)) {
                return false;
            }
            LibraryAccount otherAccount = (LibraryAccount) other;
            return this.studentID == otherAccount.studentID;
        }

        public boolean canCheckOut() {
            if (accountSuspended == false && hasOutstandingFees == false && booksCheckedOut< 5) {
                return true;
            }
            else {
                return false;
            }
        }

        public String getAccountStatus() {
            if (accountSuspended == true) {
                return "Suspended";
            }
            if (hasOutstandingFees == true) {
                return "Payment Required";
            }
            if (booksCheckedOut >= 5) {
                return "Checkout Limit Reached";
            }
            else {
                return "Account in Good Standing";
            }
        }

        public boolean canAccessResearchDatabase() {
            if (accountSuspended == false && hasOutstandingFees == false && (booksCheckedOut >= 1 || booksCheckedOut < 3)) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            LibraryAccount charAccount = new LibraryAccount("Charlotte", 21, 2, false, false);
            LibraryAccount mildaAccount = new LibraryAccount("Milda", 13, 3, false, false);
            System.out.println(charAccount.canCheckOut());
            System.out.println(charAccount.getAccountStatus());
            System.out.println(charAccount.canAccessResearchDatabase());
            System.out.println(charAccount.equals(mildaAccount));
        }
    }


