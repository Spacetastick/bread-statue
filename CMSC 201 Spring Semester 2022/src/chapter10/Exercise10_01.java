package chapter10;

public class Exercise10_01 {

	static class Time {
		private int hour, minute, second;
		
		public Time() {
			//set values of data fields to the current time
			//note: currentTimeMillis gives the elapset time in milliseconds since midnight january 1 1970
			long timeMillis = System.currentTimeMillis();
			//four is subtracted in order to convert from utc to eastern time
			hour = (int)(timeMillis/3600000 % 12 -4);
			if (hour < 1)
				hour = 12 + hour;
			timeMillis %= 3600000;
			minute = (int)(timeMillis/60000);
			timeMillis %= 60000;
			second = (int)(timeMillis/1000);
			
		}
		
		public Time(long elapsedTime) {
			//time is set to the time at milliseconds elapsed from midnight january 1 1970
			hour = (int)(elapsedTime/3600000 % 12);
			if (hour < 1)
				hour = 12 + hour;
			elapsedTime %= 3600000;
			minute = (int)(elapsedTime/60000);
			elapsedTime %= 60000;
			second = (int)(elapsedTime/1000);
		}
		
		public Time(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		
		public int getHour() {
			return hour;
		}
		
		public int getMinute() {
			return minute;
		}
		
		public int getSecond() {
			return second;
		}
		
		public void setTime(long elapsedTime) {
			//sets a new time for the object using the elapsed time (in milliseconds)
			hour = (int)(elapsedTime/3600000 % 12);
			if (hour < 1)
				hour = 12 + hour;
			elapsedTime %= 3600000;
			minute = (int)(elapsedTime/60000);
			elapsedTime %= 60000;
			second = (int)(elapsedTime/1000);
		}
		
		public void printTime() {
			System.out.println(hour+":"+minute+":"+second);
		}
	}
	
	public static void main(String[] args) {
		Time currentTime = new Time();
		currentTime.printTime();
		
		Time elapsedTime = new Time(555550000);
		elapsedTime.printTime();
		
		Time customTime = new Time(5, 23, 55);
		customTime.printTime();
	}
	
}
