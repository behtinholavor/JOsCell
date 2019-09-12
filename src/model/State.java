package model;


public class State { 			
	private int state;

	public State() {
	}
				
	public State(int state) {
		this.state = state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getState() {
		String stt = "";		
		switch (state) {
			case 1:  stt = "Insert"; break;
			case 2:  stt = "Edit"; break;
			case 3:  stt = "Active"; break;
			case 4:  stt = "Inactive"; break;
			default: stt = "Empty"; break;
		}		
		return stt;
	}
				
}
