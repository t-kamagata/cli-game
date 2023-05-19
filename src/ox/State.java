package ox;

public enum State {
	Empty(" "),
	Circle("O"),
	Cross("X"),
	Block("");
	
	final String state;
	State(String s) {
		state = s;
	}
	
	@Override
	public String toString() {
		return state;
	}
}
