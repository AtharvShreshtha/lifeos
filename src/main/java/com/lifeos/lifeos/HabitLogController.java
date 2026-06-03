package com.lifeos.lifeos;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habits")

public class HabitLogController {
    private final HabitLogRepository habitLogRepository;
    private final HabitRepository habitRepository;
    private final StreakService streakService;

    public HabitLogController(HabitLogRepository habitLogRepository, HabitRepository habitRepository, StreakService streakService){
        this.habitLogRepository = habitLogRepository;
        this.habitRepository = habitRepository;
        this.streakService = streakService;
    }

    @PostMapping("/{habitId}/log")
    public HabitLog createHabitLog(@PathVariable Long habitId, @RequestBody HabitLog habitLog){
        habitRepository.findById(habitId).orElseThrow();
        habitLog.setHabitId(habitId);
        return habitLogRepository.save(habitLog);
    }

    @GetMapping("/{habitId}/stats")
    public HabitStats getHabitStats(@PathVariable Long habitId){
        List<HabitLog> logs = habitLogRepository.findByHabitId(habitId);
        Habit habit = habitRepository.findById(habitId).orElseThrow();
        int currentStreak = streakService.calculateCurrentStreak(logs);
        int longestStreak = streakService.calculateLongestStreak(logs);
        int consistency = streakService.calculateConsistency(logs, habit);
        return new HabitStats(currentStreak, longestStreak, consistency);
    }




}
