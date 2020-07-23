package Tools;

/**
 * 枚举使用
 */
public class T_enum {
    private PizzaStatus status;

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public enum PizzaDeliverySystemConfiguration {
        INSTANCE;
        PizzaDeliverySystemConfiguration() {
            // Initialization configuration which involves
            // overriding defaults like delivery strategy
        }

        private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

        public static PizzaDeliverySystemConfiguration getInstance() {
            return INSTANCE;
        }

        public PizzaDeliveryStrategy getDeliveryStrategy() {
            return deliveryStrategy;
        }
    }

    public enum PizzaDeliveryStrategy {
        EXPRESS {
            @Override
            public void deliver(T_enum pz) {
                System.out.println("Pizza will be delivered in express mode");
            }
        },
        NORMAL {
            @Override
            public void deliver(T_enum pz) {
                System.out.println("Pizza will be delivered in normal mode");
            }
        };

        public abstract void deliver(T_enum pz);
    }

    public static void main(String[] args) {
//        T_enum e = new T_enum();
//        System.out.println(e.isDeliverable());
//
//        System.out.println(e.getStatus().equals(PizzaStatus.READY));

        T_enum pz = new T_enum();
        pz.setStatus(T_enum.PizzaStatus.READY);
        pz.deliver();
        pz.printTimeToDeliver();
        System.out.println(pz.getStatus());

    }
}

