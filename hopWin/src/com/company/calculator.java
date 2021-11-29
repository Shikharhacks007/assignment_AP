package com.company;

public class calculator <template> {
    private template obj1;
    private template obj2;

    public template calculate(template a, template b){
        if (a instanceof Double && b instanceof Double){
            //do this
            return (template) (Double)((Double)a / (Double)b);
        }

        if (a instanceof String && b instanceof String){
            //do this
            return (template) (String) ((String)a + (String)b);
        }

        else{
            //do something
            return null;
        }
    }
}
