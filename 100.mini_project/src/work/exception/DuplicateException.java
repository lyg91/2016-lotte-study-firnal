package work.exception;

/** ���ڵ� �ߺ��� �߻� ���� Ŭ���� : ��ϱ�� */
public class DuplicateException extends Exception {
	/** �⺻ ������ */
	public DuplicateException() {
		super("���ڵ� �ߺ� ����");
	}

	/** ���ڵ� �ߺ�Ű�� ��ť��Ʈ�� �޾Ƽ� ���ܸ޽��� ���� */
	public DuplicateException(String number) {
		super(number + " : ���ڵ� �ߺ� ����");
	}
}