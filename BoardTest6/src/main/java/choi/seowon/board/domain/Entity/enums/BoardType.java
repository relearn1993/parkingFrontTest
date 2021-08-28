package choi.seowon.board.domain.Entity.enums;

public enum BoardType {
	notice("공지사항"),
	press("보도자료");
	
	private String value;
	BoardType(String value){
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}
	/*------------------------------*/
	
	/*public static BoardType getBoardType(final String value) {
		for(final BoardType boardType : values()) {
			if(boardType.value.equalsIgnoreCase(value)) {
				return boardType;
			}
		}
		final String message = "Unknown VoteType " + value + ", allowed values are " + Arrays.toString(values());
	    throw new Exception(message);
	}*/
	
	
	/*public static void main(String[] args) {
		System.out.println(BoardType.press);
	}*/

}
