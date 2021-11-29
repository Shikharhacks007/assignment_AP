package com.company;

public class calculator <template> {
    private template obj1;
    private template obj2;

    public <template> template calculate(template a, template b){
        try{
            if (a instanceof Integer && b instanceof Integer){
                //do this
                return (template) (Integer)((Integer)a / (Integer) b);
            }

            else if (a instanceof String && b instanceof String){
                //do this
                return (template) (String) ((String)a + (String)b);
            }
        }

        catch (ArithmeticException e){
            System.out.println("Division by 0 is not allowed");
        }
        return null;
    }
}
