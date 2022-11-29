package distribuitor.itstoony.com.github.model.enums;

public enum OrderStatus {

    PENDING(0, "Pending"),
    ACCOMPLISHED(1, "Accomplished"),
    CANCELED(2, "Canceled"),
    FINISHED(3, "Finished");

    private int cod;

    private String description;

    OrderStatus(int id, String description) {
        this.cod = id;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static OrderStatus toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (OrderStatus x : OrderStatus.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid ID" + cod);
    }
}