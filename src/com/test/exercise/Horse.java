package com.test.exercise;

import java.util.ArrayList;

public class Horse extends Thread{
	
	//���� �̸�
	public String name;
	
	//���� �޸� �Ÿ�
	public int distance = 0;
	
	//��¼�
	private ArrayList<Horse>finishLine;
	
	
	public Horse(String name, ArrayList<Horse>finishLine){
		this.name = name;
		this.finishLine=finishLine;
	}
	
		
	
	@Override
	public void run() {
		//���� �Ÿ� 100�� �����Ҷ� ���� �޸���.
		while(distance<100){
			//�ѹ��� �޸��� �Ÿ��� 1~3���� �����ϰ�
			int runDistance =(int)(Math.random()*3+1);
			//�ѹ��� �޸� �Ÿ��� �� �޸��Ÿ��� ������Ų��.
			distance +=runDistance;
			
			//���� ��¼��� �Ѿ�� ��¼������� �޸��ŷ� ����
			if(distance>100){
				distance = 100;
			}
			try {
				//0.3�� ������ �ΰ� �����մϴ�.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//��¼��� ����ϰ� �Ǹ� ������ ���ϱ� ���� ��¼� ��� ����Ʈ�� �߰����ش�.
		synchronized (finishLine) {
			this.finishLine.add(this);
		}
		
	}
	
	
}
