package pipeandfilter;


import javax.swing.*;

public abstract class Filter  implements Runnable{
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public String getData(){
        return _dataINPipe.dataOUT();
    }
    public void setop(JButton op){}
    public void sendData( final String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
    abstract void execute();
}
 
