public class Heater
{
    private double temperature, min,max,increasement;
    
    public Heater(double _min, double _max)
    {
        min = _min;
        max = _max;
        temperature = 15.0;
        increasement = 5.0;
    }
    
    public void warmer()
    {
        double temp = temperature + increasement;
        
        if(temp <= max)
        {
            temperature = temp;
        }
    }
    
    public void cooler()
    {
        double temp = temperature - increasement;
        
        if(temp >= min)
        {
            temperature = temp;
        }
    }
    
    public double getTemperature()
    {
        return temperature;
    }
   
    public void setIncreasement(double increasementValue)
    {
        if(increasementValue >= 0)
        {
            increasement = increasementValue;
        }
    }
}