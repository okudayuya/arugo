class StackExample {

    ListObject stack;

    StackExample() {
	stack = null;
    }

    public void push(Object element) {		// スタックへの書き込み
	ListObject listObject = new ListObject(element);
	listObject.setNext(stack);
	stack = listObject;
    }

    public Object pop() {			// スタックからの取出し
	Object element = stack.getElement();
	stack = stack.getNext();
	return(element);
    }

    public void printIntValue() {		// スタックの内部状態の表示
	ListObject listObject = stack;
	System.out.print("This stack is (");
        while (listObject != null) {
	    System.out.print(" " + ((Integer) listObject.getElement()).intValue());
	    listObject = listObject.getNext();
	}
	System.out.println(" )");
    }

}