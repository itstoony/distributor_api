package distribuitor.itstoony.com.github.model.enums;

public enum AddressType {

    CLIENTS(0, "Clients"),
    DEPOSIT(1, "Deposit"),
    COMPANY(2, "Company");

    private final int cod;

    private final String description;

    AddressType(int id, String description) {
        this.cod = id;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static AddressType toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (AddressType x : AddressType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID" + cod);

    }

}
