package TGHM;

public class Statistics 
{
    public int success;
    public int total;
    public Statistics(int Success,int Total)
    {
        success = Success;
        total = Total;
    }
    
    public boolean equals(Statistics another){
        if(success==another.success){
            if(total == another.total){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
