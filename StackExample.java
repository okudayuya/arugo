class StackExample {

    ListObject stack;

    StackExample() {
	stack = null;
    }

    public void push(Object element) {		// �X�^�b�N�ւ̏�������
	ListObject listObject = new ListObject(element);
	listObject.setNext(stack);
	stack = listObject;
    }

    public Object pop() {			// �X�^�b�N����̎�o��
	Object element = stack.getElement();
	stack = stack.getNext();
	return(element);
    }

    public void printIntValue() {		// �X�^�b�N�̓�����Ԃ̕\��
	ListObject listObject = stack;
	System.out.print("This stack is (");
        while (listObject != null) {
	    System.out.print(" " + ((Integer) listObject.getElement()).intValue());
	    listObject = listObject.getNext();
	}
	System.out.println(" )");
    }

}