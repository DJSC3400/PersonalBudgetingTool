package expenseTracker;

import java.time.LocalDateTime;
import java.util.Calendar;

public class RoutineItem extends LineItem{
	public int duration;//time between events; every day, every month
	public int frequency;// number of durations between events; every 3 days, every other month.
	public int occurance;//number of events; every 3 months for a year-> 4, if i begin paying rent in March 2023, and stop in December 2023 ->9
	public LocalDateTime firstOccurance;//when the payment began
	public LocalDateTime lastOccurance;//when the payment ends
	
	RoutineItem(UniqueItem instance, int duration, int frequency, int occurance){
	}
	RoutineItem(int duration, int frequency, int occurance, String name, double amount, String note, LocalDateTime purchaseTime, String tag){
		LineItem j = new UniqueItem(name, amount, note, purchaseTime, tag);
	}
	RoutineItem(double amount,int duration, int frequency, int occurance){
		LineItem j = new UniqueItem(SUPER_NAME, amount, SUPER_NOTE, SUPER_TAG);
		repeatTemporalAmount(superCalendar, duration, frequency, occurance);
	}
	
	//--------begin-getter/setter-section---------
	public int getDuration() {
		return duration;
	}

	
	public void setDuration(int duration) {
		//Requires format check. Must be calendar field
		this.duration = duration;
	}
	
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public int getOccurance() {
		return occurance;
	}

	public void setOccurance(int occurance) {
		//Requires format check. Must be calendar field
		this.occurance = occurance;
	}
	
	public LocalDateTime getFirstOccurance() {
		return firstOccurance;
	}

	public void setFirstOccurance(LocalDateTime firstOccurance) {
		//Requires format check. Must be LocalDateTime
		this.firstOccurance = firstOccurance;
	}
	
	public LocalDateTime getLastOccurance() {
		return lastOccurance;
	}

	public void setLastOccurance(LocalDateTime lastOccurance) {
		//Requires format check. Must be LocalDateTime
		this.lastOccurance = lastOccurance;
	}
	
	//--------begin-method-section---------
	
	public static void repeatTemporalAmount(Calendar calendar, int temporalField, int frequency, int repetitions) {
		
		for (int i = 0; i < repetitions; i++) {
		    calendar.add(temporalField, frequency);
		    LineItem j = new UniqueItem();
		}
	}
}
