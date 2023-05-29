package exceptionExamples;

public class Example6 {
    public static void a() throws OnOff1Exception, OnOff2Exception {
        throw new OnOff1Exception();
//        throw new OnOff2Exception();
    }

    public static void main(String[] args) {
        Switch aSwitch = new Switch();

        try {
            aSwitch.on();
            a();
        } catch (OnOff1Exception e) {
            System.out.println("перехвачен OnOff1Exception ");
            e.printStackTrace(System.out);
        } catch (OnOff2Exception e) {
            System.out.println("перехвачен OnOff2Exception ");
            e.printStackTrace(System.out);
        } finally {
            aSwitch.off();
        }


    }
}

class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
//        String result = "";
//        if (state) result = "вкл";
//        else result = "выкл";
//        return result;

        return state ? "вкл" : "выкл";
    }
}

class OnOff1Exception extends Exception {}
class OnOff2Exception extends Exception {}