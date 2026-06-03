package com.lifeos.lifeos;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StreakService {

    public int calculateCurrentStreak(List<HabitLog> logs) {
        int streak = 0;
        for (HabitLog log : logs) {
            if (log.getStatus() == HabitLogStatus.DONE || log.getStatus() == HabitLogStatus.GRACE) {
                streak++;
            } else {
                break;
            }
        }
        return streak;
    }

    public int calculateLongestStreak(List<HabitLog> logs) {
        int longest = 0;
        int current = 0;
        for (HabitLog log : logs) {
            if (log.getStatus() == HabitLogStatus.DONE || log.getStatus() == HabitLogStatus.GRACE) {
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return longest;
    }

    public int calculateConsistency(List<HabitLog> logs, Habit habit) {
        int doneDays = 0;
        for (HabitLog log : logs) {
            if (log.getStatus() == HabitLogStatus.DONE) {
                doneDays++;
            }
        }
        int expectedDays = habit.getTargetDaysPerWeek() * 4;
        int consistency = (doneDays * 100) / expectedDays;
        return consistency;
    }
}