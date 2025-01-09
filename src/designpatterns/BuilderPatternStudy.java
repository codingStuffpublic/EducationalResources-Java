package designpatterns;

public class BuilderPatternStudy {
	
	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount
				  .BankAccountBuilder("John", "22738022275")
				  .withEmail("john@example.com")
				  .wantNewsletter(true)
				  .build();
		System.out.println(newAccount.name);
	}
}

class BankAccount {
    
    public BankAccount(BankAccountBuilder bankAccountBuilder) {
		this.name = bankAccountBuilder.name;
		this.accountNumber = bankAccountBuilder.accountNumber;
		this.email = bankAccountBuilder.email;
		this.newsletter = bankAccountBuilder.newsletter;
	}

    //making it default access level to access without getter. Not recommended.
	String name;
    String accountNumber;
    String email;
    boolean newsletter;

    public static class BankAccountBuilder {
    		private String name;
        private String accountNumber;
        private String email;
        private boolean newsletter;
        
        public BankAccountBuilder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public BankAccountBuilder wantNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }
        
        public BankAccount build() {
            return new BankAccount(this);
        }
    }
}

