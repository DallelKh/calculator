package pipeandfilter;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
public  class FilterB extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
	JTextField resultat;
    
    public FilterB(Pipe _dataINPipe, Pipe _dataOUTPipe, JTextField resultat) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
		this.resultat= resultat;
	}
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
	@Override
	public void run() {

		execute();
	}
	@Override
	synchronized void execute() {

		//get data from pipe
		String op1  = _dataINPipe.dataOUT();
		String op2 = _dataINPipe.dataOUT();
		String res = _dataINPipe.dataOUT();
		String op = _dataINPipe.dataOUT();

		try {
			FileWriter writer = new FileWriter("MyFile.txt", true);
			writer.write("||     "+op1+"     |"+"|    "+op+"   |"+"|    "+op2+"    |"+"|    "+res+"    ||");
			writer.write("\r\n"); 
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
		}
		
		resultat.setText(res);
	}
}