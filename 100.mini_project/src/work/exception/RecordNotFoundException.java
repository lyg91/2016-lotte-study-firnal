package work.exception;

public class RecordNotFoundException extends Exception {
	/** �⺻ ������ */
	public RecordNotFoundException() {
		super("���ڵ带 ã�� �� �����ϴ�.");
	}
	
	/** */
	public RecordNotFoundException(String key) {
	}
}