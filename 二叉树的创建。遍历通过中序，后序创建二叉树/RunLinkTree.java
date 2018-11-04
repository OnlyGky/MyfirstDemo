package helloworld;

import java.util.Stack;

import helloworld.CreateTree.Node;



public class RunLinkTree {//�������
	public static void FirstRun(Node root) {
		System.out.println("�������");
		Stack<Node> NodeStack=new Stack<Node>();
		Node node=root;
		while(node!=null||!NodeStack.isEmpty()) {
			while(node!=null) {
				if(node.data!=' ')
				System.out.print(node.data);
				
				NodeStack.push(node);
				node=node.lchild;
			}
			if(!NodeStack.isEmpty()) {
				node=NodeStack.pop();
				node=node.rchild;
			}
		}
	System.out.println();	
	}
	public static void SecondRun(Node root) {//�������
		System.out.println("�������");
		Stack<Node> NodeStack=new Stack<Node>();
		while(root!=null||!NodeStack.isEmpty()) {
			while(root!=null) {
				NodeStack.push(root);
				root=root.lchild;
			}
			if(!NodeStack.isEmpty()) {
				root=NodeStack.pop();
				System.out.print(root.data+" ");
				root=root.rchild;//����ýڵ�ֻ�����������������������
			}
		}
		System.out.println();
	}
	public static void LastRun(Node root) {//�������
		System.out.println("�������");
		Node lastVisit=root;
		Stack<Node> NodeStack=new Stack<Node>();
		while(root!=null||!NodeStack.isEmpty()) {
		while(root!=null) {
			NodeStack.push(root);
			root=root.lchild;
		}
		root = NodeStack.peek();//�鿴��ǰջ���Ƿ���Ϊ�ջ����Ѿ���ȷ�Ϲ�
        //�����������ҲΪ�գ������������Ѿ�����
        //�����ֱ�������ǰ�ڵ��ֵ
        if (root.rchild == null || root.rchild == lastVisit) {
            System.out.print(root.data + " ");
            NodeStack.pop();
            lastVisit = root;
            root = null;
        } else {
            //���򣬼�������������
            root = root.rchild;
        }
		}
		System.out.println();
	}	
}
