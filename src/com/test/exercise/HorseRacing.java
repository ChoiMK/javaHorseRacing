package com.test.exercise;

import java.util.ArrayList;

public class HorseRacing {
	
	private Horse[] horses;
	private ArrayList<Horse> finishLine = new ArrayList<Horse>();
	
	public HorseRacing(){
		//�� 10������ �迭�� ������ ���´�.
		horses = new Horse[10];
		horses[0] = new Horse("1����",finishLine);
		horses[1] = new Horse("2����",finishLine);
		horses[2] = new Horse("3����",finishLine);
		horses[3] = new Horse("4����",finishLine);
		horses[4] = new Horse("5����",finishLine);
		horses[5] = new Horse("6����",finishLine);
		horses[6] = new Horse("7����",finishLine);
		horses[7] = new Horse("8����",finishLine);
		horses[8] = new Horse("9����",finishLine);
		horses[9] = new Horse("10����",finishLine);
	}
		
	
	public void start(){
		//�� ������ �渶�� ���󾲷��� ���̸鼭 ���� �޸��� �����Ѵ�.
		//�̷��� �Ǹ� �渶�� ������ �Ǹ� ���� 100���͸� �� �޸��� �ʾҴ���
		//���� �����尡 ����ǰ� �˴ϴ�.
		
		for(Horse horse : horses){
			horse.setDaemon(true);
			horse.start();
		}
		
		//��¼��� 10������ �� ������ ����ǵ����Ѵ�.
		while(finishLine.size()<horses.length){
			try {
				//0.3�ʸ��� �ѹ��� ����� ����Ѵ�.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//���м� 
			System.out.println("====================================================="
							   +"=====================================================");
			for(int i=0; i<horses.length; i++){
				//���� �޸��Ÿ� ��ŭ .�� ����ش�.
				for(int j=0; j<horses[i].distance; j++){
					System.out.print(".");
				}
				//.�� ���� �������� ���� �̸��� ���� �ٹٲ�
				System.out.println(horses[i].name);
			}
			//���м�
			System.out.println("====================================================="
					           +"=====================================================");
		}
		
		//���� ������ ǥ��
		for(int i=0; i<finishLine.size(); i++){
			Horse rankHorse = finishLine.get(i);
			System.out.println((i+1)+"����"+rankHorse.name); 
		}
	
	}
	

	public static void main(String[] args) {
			HorseRacing racing = new HorseRacing();
			racing.start();
	}
			
	
	
	
}
