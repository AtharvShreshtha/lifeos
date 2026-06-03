package com.lifeos.lifeos;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/goals")

public class GoalController {
    private final GoalRepository goalRepository;

    public GoalController(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @GetMapping
    public List<Goal> getAllGoals (){
        return goalRepository.findAll();
    }

    @PostMapping
    public Goal createGoal (@RequestBody Goal goal){
        return goalRepository.save(goal);
    }

    @PatchMapping("/{id}/status")
    public Goal getGoalStatus(@PathVariable Long id, @RequestBody Goal updatedGoal) {
        Goal goal = goalRepository.findById(id).orElseThrow();
        goal.setStatus(updatedGoal.getStatus());
        return goalRepository.save(goal);
    }
}
