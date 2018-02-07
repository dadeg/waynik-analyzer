package com.waynik.analyzer.strategies;

import com.waynik.analyzer.Checkin;
import com.waynik.analyzer.alerts.AlertInterface;

public interface StrategyInterface {
	public AlertInterface analyze(Checkin[] checkins);
}
