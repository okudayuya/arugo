//TreeMap�N���X
import java.util.*;
public class TreeMapSample {
public static void main(String[] args){
// Map�̎����ł���HashMap�N���X�̃C���X�^���X�����C����̓L�[���l��������^
// �W�F�l���N�X�i���̌^�j���g���Ă���i���K�j
TreeMap<String,String> map = new TreeMap<String,String>();
map.put("red","��"); // �v�f�̒ǉ�
map.put("blue","��");
map.put("green","��");
map.put("green","��"); // �����v�f��ǉ����Ă��v�f�͏d������Ȃ�
System.out.println(map.get("blue")); // �L�[���w�肵�ĕ\��
System.out.println("");
for(String key:map.keySet()){ // �v�f�̈ꗗ��\���G �g��For���i���K�j
System.out.println(key+" = "+map.get(key));
}
System.out.println("");
map.remove("green"); //�L�[���w�肵�č폜
for(String key:map.keySet()){ // �v�f�̈ꗗ��\���G �g��For���i���K�j
System.out.println(key+" = "+map.get(key));
}
}
}
