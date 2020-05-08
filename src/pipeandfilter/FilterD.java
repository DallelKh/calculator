package pipeandfilter;
public  class FilterD extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public FilterD(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
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
				System.out.printf(_dataINPipe.dataOUT()+"--> Filter D");
	}
}
 