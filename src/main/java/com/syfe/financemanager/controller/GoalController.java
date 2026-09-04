package com.syfe.financemanager.controller;

import com.syfe.financemanager.dto.GoalRequest;
import com.syfe.financemanager.dto.GoalResponse;
import com.syfe.financemanager.model.User;
import com.syfe.financemanager.service.GoalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/goals")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<GoalResponse> createGoal(@AuthenticationPrincipal User user,
                                                   @Valid @RequestBody GoalRequest request) {
        GoalResponse response = goalService.createGoal(user, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getGoals(@AuthenticationPrincipal User user) {
        List<GoalResponse> goals = goalService.getGoals(user);
        Map<String, Object> response = new HashMap<>();
        response.put("goals", goals);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponse> getGoal(@AuthenticationPrincipal User user,
                                                @PathVariable Long id) {
        GoalResponse response = goalService.getGoal(user, id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalResponse> updateGoal(@AuthenticationPrincipal User user,
                                                   @PathVariable Long id,
                                                   @RequestBody GoalRequest request) {
        GoalResponse response = goalService.updateGoal(user, id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoal(@AuthenticationPrincipal User user,
                                        @PathVariable Long id) {
        goalService.deleteGoal(user, id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Goal deleted successfully");
        return ResponseEntity.ok(response);
    }
}
