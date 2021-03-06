package Code.prime;

public abstract class Mother {
    public int getAge(){
        return 45;
    }

    public abstract class Son{
        public int getAge(){
            return 38;
        }
    }

    public static void main(String[] args) {
        Mother m = new Mother() {
            @Override
            public int getAge() {
                return 22;
            }
        };

        Mother.Son s = m.new Son() {
            @Override
            public int getAge() {
                return 57;
            }
        };

        System.out.println(s.getAge()+ " " + m.getAge());
    }
}
