package helloworld;

import java.util.Scanner;

import helloworld.CreateTree.Node;
public class Init {
	
public static void main(String[] args) {//������
	Scanner input=new Scanner(System.in);
	@SuppressWarnings("resource")
	CreateTree tree=new CreateTree();
	Node root=tree.new Node();
//	tree.createTree(root);//�����������д���һ�������������ַ���#��ʾ
//	RunLinkTree.FirstRun(root);
//	RunLinkTree.SecondRun(root);
//	RunLinkTree.LastRun(root);
	System.out.println("ͨ������ͺ��򴴽�������");
	String s=new String();
	s=input.nextLine();
	char []zhonxu=s.toCharArray();
	
	s=input.nextLine();
	char []houxu=s.toCharArray();
	
	Node root1=tree.new Node();
	root1=tree.createNode(root1,zhonxu,houxu);//ͨ�����򣬺��򴴽�������
	RunLinkTree.FirstRun(root1);
//	tree.preTraverseBinTree(root1);
	RunLinkTree.SecondRun(root1);
	RunLinkTree.LastRun(root1);
}
}
