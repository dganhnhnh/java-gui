public class Converter {
    private String from="m";
    private int to=0;
    private double[][] chart = 
        {{1, 0.001,0.0006213689,3.280839895},
        {1000,1,0.6213688756,3280.839895},
        {1609.35,1.60935,1,5280.019685},
        {0.3048,0.0003048,0.0001893932,1},};
    private double inputValue;


    public Converter(String from, int to, double inputValue){
        this.from=from;
        this.to=to;
        this.inputValue=inputValue;
    }

    public double outputValue(){
        double result=0;
        switch(from){
            case "m": result=inputValue*chart[0][to]; break;
            case "km":result=inputValue*chart[1][to];break;
            case "mile":result=inputValue*chart[2][to];break;
            case "foot":result=inputValue*chart[3][to];break;
        }
        return result;
    }
    public void setUnitTo(int to){
        this.to=to;
    }
    public void setUnitFrom(String from){
        this.from=from;
    }
    public void setInput(double inputValue){
        this.inputValue=inputValue;
    }
}
