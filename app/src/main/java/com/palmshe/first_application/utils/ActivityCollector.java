package com.palmshe.first_application.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	
	private static List<Activity> activityCollector= new ArrayList<Activity>();
	
	public static void addActivity(Activity act){
		if (act!= null) {
			activityCollector.add(act);
		}else {
			throw new NullPointerException("���ʧ�ܣ�activityΪ��");
		}
	}
	
	public static void removeActivity(Activity act){
		if (activityCollector.contains(act)) {
			activityCollector.remove(act);
		}else {
			throw new MyException("�Ƴ�ʧ�ܣ������ڸû");
		}
	}
	
	public static void finished(){
		for (Activity activity : activityCollector) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
	static class  MyException extends RuntimeException{
		public MyException(){
			super();
		}
		public MyException(String msg){
			super(msg);
		}
	}
}
