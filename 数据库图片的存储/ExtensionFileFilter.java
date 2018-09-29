package Blob;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter{//ʵ���ļ����˹���
private String description="";
private ArrayList<String>extensions=new ArrayList<>();
public void addExtension(String extension) {//��������ļ���չ��
	if(extension.startsWith(".")) {
		extension="."+extension;
		extensions.add(extension.toLowerCase());
	}
}
public void setDescription(String aDescription) {
	description=aDescription;
}
public String getDescription() {
	return description;
}
public boolean accept(File f) {//�̳�FileFilter����ʵ�ֵķ������жϸ��ļ��������Ƿ���ܸ��ļ�
	if(f.isDirectory())	return true;//�жϸ��ļ��Ƿ���·��
	String name=f.getName().toLowerCase();
	for(String extension :extensions) {//�ж���չ���Ƿ���ͬ�����ļ��ɽ���
		if(name.endsWith(extension)) {
			return true;
		}
	}
	return false;
}
}
