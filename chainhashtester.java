import java.util.Scanner;
class chainhashtester {
	static Scanner stdIn =new Scanner(System.in);

	//�f�[�^
	static class Data{
		static final int NO	=1;		//�ԍ��ǂݍ���
		static final int NAME  =2;	//�����ǂݍ���

		private Integer no;			//����ԍ�(key)
		private String name;		//����

		//key
		Integer keyCode(){
			return no;
		}

		//������\����Ԃ�
		public String toString(){
			return name;
		}

		//�f�[�^�̓ǂݍ���
		void scanData(String guide,int sw){
			System.out.println(guide+"����f�[�^����͂��Ă�������");

			if((sw&NO)==NO){
				System.out.print("�ԍ�:");
				no=stdIn.nextInt();
			}
			if((sw&NAME)==NAME){
				System.out.print("���O");
				name=stdIn.next();
			}
		}
	}

	//���j���[��
	enum Menu{
		ADD(    "�f�[�^�ǉ�"),
		REMOVE( "�f�[�^�폜"),
		SEARCH( "�f�[�^�T��"),
		DUMP(   "�S�f�[�^�\��"),
		TERMINATE("�I��");

		private final String message;

		static Menu MenuAt(int idx){
			for(Menu m: Menu.values())
				if(m.ordinal()==idx)
					return m;
			return null;
		}
		Menu(String string){
			message=string;
		}

		String getMessage(){
			return message;
		}
	}

	//���j���[�I��
	static Menu SelectMenu(){
		int key;
		do{
			for(Menu m:Menu.values()){
				System.out.printf("(%d)%s",m.ordinal(),m.getMessage());
				if((m.ordinal()%3)==2&&m.ordinal()!=Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(":");
			key=stdIn.nextInt();
		  }while (key<Menu.ADD.ordinal()||key>Menu.TERMINATE.ordinal());

		  return Menu.MenuAt(key);
		}

	public static void main(String args[]){
		Menu menu;//���j���[
		Data data;//�ǉ��p�f�[�^�Q��
		Data temp=new Data();//�ǂݍ��ݗp�f�[�^

		ChainHash<Integer, Data> hash=new ChainHash<Integer, Data>(13);

		do{
			switch (menu = SelectMenu()){
				case ADD ://�ǉ�
					data =new Data();
					data.scanData("�ǉ�",Data.NO|Data.NAME);
					hash.add(data.keyCode(),data);
					break;

				case REMOVE :
					temp.scanData("�폜",Data.NO);
					hash.remove(temp.keyCode());
					break;

				case SEARCH :
					temp.scanData("�T��",Data.NO);
					Data t=hash.search(temp.keyCode());
					if(t !=null)
						System.out.println("���̃L�[�����f�[�^��"+t+"�ł�");
					else
						System.out.println("�Y������f�[�^�͂���܂���");
					break;

					case DUMP :
						hash.dump();
						break;
					}
				}while (menu !=Menu.TERMINATE);
	}
}


