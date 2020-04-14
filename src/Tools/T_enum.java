package Tools;

public class T_enum {
    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    public PizzaStatus getStatus() {
        return PizzaStatus.READY;
    }

    public static void main(String[] args) {
        T_enum e = new T_enum();
        System.out.println(e.isDeliverable());

        System.out.println(e.getStatus().equals(PizzaStatus.READY));
    }

    // Methods that set and get the status variable.
}