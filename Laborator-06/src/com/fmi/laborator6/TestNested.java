package com.fmi.laborator6;

class MyClass {

}

public class TestNested {

    class NestedA {

    }

    static class NestedStatic {

    }

    interface MyNestedInterface {
        void doNestedInterface();
        void doNested2();
    }

    public void doStuff() {

        class X {

        }

        X x = new X();

        MyNestedInterface y = new MyNestedInterface() {
            @Override
            public void doNestedInterface() {

            }
            @Override
            public void doNested2() {

            }
        };


    }


}
