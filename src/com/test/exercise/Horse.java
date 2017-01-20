package com.test.exercise;

import java.util.ArrayList;

public class Horse extends Thread{
	
	//말의 이름
	public String name;
	
	//말이 달린 거리
	public int distance = 0;
	
	//결승선
	private ArrayList<Horse>finishLine;
	
	
	public Horse(String name, ArrayList<Horse>finishLine){
		this.name = name;
		this.finishLine=finishLine;
	}
	
		
	
	@Override
	public void run() {
		//말이 거리 100에 도달할때 까지 달린다.
		while(distance<100){
			//한번에 달리는 거리는 1~3까지 랜덤하게
			int runDistance =(int)(Math.random()*3+1);
			//한번에 달린 거리를 총 달린거리에 누적시킨다.
			distance +=runDistance;
			
			//말이 결승선을 넘어가도 결승선까지만 달린거로 설정
			if(distance>100){
				distance = 100;
			}
			try {
				//0.3초 간격을 두고 실행합니다.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//결승선을 통과하게 되면 순위를 정하기 위해 결승선 통과 리스트에 추가해준다.
		synchronized (finishLine) {
			this.finishLine.add(this);
		}
		
	}
	
	
}
