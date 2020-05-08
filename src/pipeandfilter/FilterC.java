package pipeandfilter;
import javax.swing.*;
import java.util.Scanner;
public  class FilterC extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
	JTextField op1;
	JTextField op2;
	 JButton op;
     
    public FilterC(Pipe _dataINPipe, Pipe _dataOUTPipe, JTextField op1, JTextField op2, JButton op) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
		this.op1 = op1;
		this.op2 = op2;
		this.op = op;
	}
    public void setop(JButton op){
		this.op = op;

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

		//put the data in the pipe :
		_dataOUTPipe.dataIN(op1.getText());
		_dataOUTPipe.dataIN(op2.getText());
		_dataOUTPipe.dataIN(op.getText());
	}
} 