import javax.swing.*;

public class Controller {

    String firstArg = "";
    String secondArg = "";
    String operator = "";
    Boolean hasPerformedACalculation = false;
    String saveArg = "";

    CalculatorApp gui;

    Controller(CalculatorApp gui){
        this.gui = gui;
    }

    public void enterButton(){
        //do enter button stuff
        hasPerformedACalculation = true;
        long firstNum = 0;
        long secondNum = 0;
        long result = 0;
        if(!firstArg.equals("")){
            firstNum = Integer.parseInt(firstArg);
        }
        if(!secondArg.equals("")){
            secondNum = Integer.parseInt(secondArg);
        }

        switch(operator){
            case "+":
                result =  MathUtil.add(firstNum, secondNum);
                //LABEL STUFF
                break;
            case "-":
                result =  MathUtil.sub(firstNum, secondNum);
                //LABEL STUFF
                break;
            case "*":
                result =  MathUtil.mul(firstNum, secondNum);
                //LABEL STUFF
                break;
            case "/":
                try{
                    result = MathUtil.div(firstNum, secondNum);
                }
                catch(IllegalArgumentException e){
                    //make popup window?
                    //otherwise set result to 0?
                    result = 0;
                }
                break;
            default:
                //set answer to 0?
                result = 0;
                //this should never happen
                break;
        }

        firstArg = String.valueOf(result);
        operator = "";
        secondArg = "";
        updateView();

    }

    public void numberButton(String num){
        //do stuff
        //displayLabel.setText(num);
        //update number1, if not operator
        //if operator, then update num 2
        //call UpdateView()
        if(operator.equals("")){
            if(hasPerformedACalculation){
                clearView();
                hasPerformedACalculation = false;
                firstArg += num;
            }else{
                firstArg += num;
            }
        }
        else{
            secondArg += num;
        }
        updateView();
    }

    public void setOperator(String op){
        if(firstArg.equals("") && op.equals("-")){
            firstArg += op;
        }
        else if((!firstArg.equals("") || !(firstArg.equals("-")))&&operator.equals("")){
            this.operator = op;
        }
        else if(!this.operator.equals("")){
            if(secondArg.equals("") && op.equals("-")){
                secondArg += op;
            }
            else if(!secondArg.equals("") || !secondArg.equals("-")){
                enterButton();
                this.operator = op;
            }
        }
        updateView();
        //if clicked again, hit enter then set new?
    }

    public void clearView(){
        firstArg = "";
        secondArg = "";
        operator = "";
        updateView();
    }

    private void updateView(){
        gui.updateView(firstArg, secondArg, operator);
    }

    public void setSaveArg(){
        if (secondArg != ""){
            saveArg = secondArg;
        }
        else{
            saveArg = firstArg;
        }
    }

    public void recallSaved(){
        if (saveArg != ""){
            if(operator != ""){
                secondArg = saveArg;
            }else{
                clearView();
                firstArg = saveArg;
            }
            updateView();
        }
    }

}
