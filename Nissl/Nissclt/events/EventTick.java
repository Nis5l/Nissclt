package me.Nissl.Nissclt.events;

import com.darkmagician6.eventapi.events.Event;

public class EventTick implements Event {

	public boolean Cancellable;

	public boolean isCancellable() {
		return Cancellable;
	}

	public void setCancellable(boolean cancellable) {
		Cancellable = cancellable;
	}
	
	
	
}