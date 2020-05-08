package pipeandfilter;
import java.io.IOException;
import static java.lang.Integer.toString;

import java.util.Scanner;

public class FilterA extends Filter {

	public FilterA(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}

	Pipe _dataINPipe;
	Pipe _dataOUTPipe;

	public String getData() {
		return _dataINPipe.dataOUT();
	}

	public void sendData(String tempData) {
		_dataOUTPipe.dataIN(tempData);
	}

	@Override
	public void run() {

		execute();
	}

	@Override
	synchronized void execute() {
		//get data from pipe
		String op1 = _dataINPipe.dataOUT();
		String op2 = _dataINPipe.dataOUT();
		String op = _dataINPipe.dataOUT();
		int op11 = Integer.parseInt(op1);
		int op22 = Integer.parseInt(op2);
		int res = 0;
		switch (op) 
		{
			case "(+) Somme": res = op11 + op22;
			break;
			case "(*) Produit": res = op11 * op22;
			break;
			case "(!) Factoriel": {
				int fact=1;
				for(int i =1; i <= op11;i++){fact = fact*i;}
				res = fact;
			}
			break;
			default: ;
		}
		String res1 = Integer.toString(res); 

		//put data in pipe 
		_dataOUTPipe.dataIN(op1);
		_dataOUTPipe.dataIN(op2);
		_dataOUTPipe.dataIN(res1);
		_dataOUTPipe.dataIN(op);
	}
}
 